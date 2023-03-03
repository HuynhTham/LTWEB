package database;


import java.io.FileNotFoundException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import java.util.stream.Collectors;


import org.jdbi.v3.core.Jdbi;




import model.Account;
import model.Encode;
import model.Role;

public class DAOAccounts {
	public DAOAccounts() {

	}
	
	public int getSizeListAccountNormal(){
		Jdbi me = JDBiConnector.me();
		String query = "select distinct ac.idUser from animeweb.accounts ac join animeweb.account_roles acr on ac.idUser = acr.idUser where 4 not in"
				+ " (select idrole from animeweb.account_roles where idUser = ac.idUser)";
		List<Account> result = me.withHandle(handle -> {
			return handle.createQuery(query).mapToBean(Account.class).stream()
					.collect(Collectors.toList());
		});
		return result.size();
	}
	public List<Account> getListAccountNormal(int offset,int limit){
		Jdbi me = JDBiConnector.me();
		String query = "select distinct ac.idUser,UserName,Password,Email,avatar,typeId,isActive,joinDate,FullName,PhoneNumber from animeweb.accounts ac join animeweb.account_roles acr on ac.idUser = acr.idUser where 4 not in"
				+ " (select idrole from animeweb.account_roles where idUser = ac.idUser) LIMIT :limit OFFSET :offset";
		List<Account> result = me.withHandle(handle -> {
			return handle.createQuery(query).bind("limit", limit).bind("offset", offset).mapToBean(Account.class).stream()
					.collect(Collectors.toList());
		});

		return result;
	}
	
	public boolean blockAccount(int idUser) throws SQLException {
		Connection conn = DataSource.getConnection();
		PreparedStatement prepare = conn.prepareStatement("UPDATE animeweb.accounts SET isActive = 0 WHERE idUser=? ");
		prepare.setInt(1, idUser);
		return prepare.executeUpdate() == 1;
	}

	public int findIdByUserName(String userName) throws SQLException {
		int idUser = -1;
		Connection conn = DataSource.getConnection();
		PreparedStatement prepare = conn
				.prepareStatement("SELECT idUser FROM animeweb.accounts where UserName=? and typeId=1");
		prepare.setString(1, userName);
		ResultSet rs = prepare.executeQuery();
		if (rs.next()) {
			idUser = rs.getInt("idUser");
			return idUser;
		}
		return idUser;

	}

	public Account findUserByUserNameandEmail(String userName, String Email) {
		Jdbi me = JDBiConnector.me();
		String query = "SELECT idUser,UserName,Password,Email,avatar,typeId,isActive FROM animeweb.accounts where UserName= :UserName and Email= :Email and typeId=1";

		Account account;
		account = me.withHandle(handle -> {
			return handle.createQuery(query).bind("UserName", userName).bind("Email", Email).mapToBean(Account.class)
					.findFirst().orElse(null);

		});
		return account;
	}

	public List<Role> getRoleUser(int idUser) throws SQLException, FileNotFoundException {
		String query = "select a.idrole,description from animeweb.account_roles a join animeweb.roles r on a.idrole = r.idrole where a.idUser=?";
		Jdbi me = JDBiConnector.me();
		List<Role> result = me.withHandle(handle -> {
			return handle.createQuery(query).bind(0, idUser)
					.map((resultSet, ctx) -> new Role(resultSet.getInt("idrole"), resultSet.getString("description")))
					.list();
		});

		return result;

	}

	public Account baseLogin(String userName, String passWord) throws SQLException, FileNotFoundException {

		Account account = null;
		String query = "SELECT idUser,UserName,Password,Email,avatar,typeId,isActive,FullName,PhoneNumber FROM animeweb.accounts where UserName= :UserName and Password = :Password and typeId=1";
		Jdbi me = JDBiConnector.me();
		account = me.withHandle(handle -> {
			return handle.createQuery(query).bind("UserName", userName).bind("Password", passWord)
					.mapToBean(Account.class).findFirst().orElse(null);

		});
		if (account != null) {
			account.setRoles(getRoleUser(account.getIdUser()));
		}
		return account;
	}

	public int findIdUserGoogle(String idGoogle, String email) throws SQLException {
		int id;
		Jdbi me = JDBiConnector.me();
		System.out.println(idGoogle);
		System.out.println(email);
		String query = "SELECT idUser from animeweb.accounts_google where idGoogle =:idGoogle and EMAIL=:Email";
		id = me.withHandle(handle -> {
			return handle.createQuery(query).bind("idGoogle", idGoogle).bind("Email", email).mapToBean(Account.class)
					.findFirst().orElse(new Account()).getIdUser();
		});
		return id;
	}

	public Account loginAccountByGoogle(int idUser, int type) throws SQLException, FileNotFoundException {
		Account account = null;

		Jdbi me = JDBiConnector.me();
		String query = "SELECT idUser,UserName,Password,Email,avatar,typeId,isActive FROM animeweb.accounts where idUser=:idUser and typeId=:typeId";
		account = me.withHandle(handle -> {
			return handle.createQuery(query).bind("idUser", idUser).bind("typeId", type).mapToBean(Account.class)
					.findFirst().orElse(null);
		});
		if (account != null) {
			account.setRoles(getRoleUser(idUser));
		}
		return account;
	}

	public int findIdUserAccount(String email, int type) throws SQLException {
		int id;

		Jdbi me = JDBiConnector.me();
		String query = "SELECT idUser from animeweb.accounts where  Email=:Email and typeId =:typeId";
		id = me.withHandle(handle -> {
			return handle.createQuery(query).bind("Email", email).bind("typeId", type).mapToBean(Account.class)
					.findFirst().orElse(new Account()).getIdUser();
		});
		return id;
	}

	public void addBaseUser(String userName, String password, String email, String fullName, String phoneNumber) {
		Encode encrypt = new Encode();
		String encryptPassword = encrypt.toSHA1(password);
		Jdbi me = JDBiConnector.me();
		String avatarPath = "/anime-main/storage/avatarUser/";
		me.useHandle(handle -> {
			handle.begin();
			try {
				String query = "INSERT INTO accounts (Username, Password,Email,avatar,typeId,isActive,FullName,PhoneNumber) VALUES (:Username,:Password,:Email,:avatar,1,1,:FullName,:PhoneNumber) ";
				int idUser = handle.createUpdate(query).bind("Username", userName).bind("Password", encryptPassword)
						.bind("Email", email).bind("avatar", avatarPath + "defaultavatar.jpg")
						.bind("FullName", fullName).bind("PhoneNumber", phoneNumber).executeAndReturnGeneratedKeys()
						.mapTo(Integer.class).findFirst().orElse(-1);

				String query1 = "INSERT INTO  account_roles (idUser, idrole) VALUES (:idUser,:idrole) ";
				handle.createUpdate(query1).bind("idUser", idUser).bind("idrole", Role.base_User).execute();
				handle.commit();

			} catch (Exception e) {
				e.printStackTrace();
				handle.rollback();

			}
		});

	}

	public void addGoogle(String idGoogle, String email, String userName, String avatar, String fullName, String phone)
			throws SQLException {

		Encode encrypt = new Encode();
		String pass = encrypt.toSHA1(idGoogle);

		Jdbi me = JDBiConnector.me();
		me.useHandle(handle -> {
			handle.begin();
			try {
				String query = "INSERT INTO accounts (Username, Password,Email,avatar,typeId,isActive,FullName,PhoneNumber) VALUES (:Username,:Password,:Email,:avatar,2,1,:FullName,:PhoneNumber) ";
				int idUser = handle.createUpdate(query).bind("Username", userName).bind("Password", pass)
						.bind("Email", email).bind("avatar", avatar).bind("FullName", fullName)
						.bind("PhoneNumber", phone).executeAndReturnGeneratedKeys().mapTo(Integer.class).findFirst()
						.orElse(-1);
				String query2 = "INSERT INTO  accounts_google (idGoogle, Username,idUser,Email) VALUES (:idGoogle,:Username,:idUser,:Email) ";
				handle.createUpdate(query2).bind("idGoogle", idGoogle).bind("Username", userName).bind("idUser", idUser)
						.bind("Email", email).execute();
				String query3 = "INSERT INTO  account_roles (idUser, idrole) VALUES (:idUser,:idrole) ";
				handle.createUpdate(query3).bind("idUser", idUser).bind("idrole", Role.base_User).execute();

				handle.commit();
			} catch (Exception e) {
				e.printStackTrace();
				handle.rollback();

			}
		});

	}

	public void changeProfile(String userName, String passWord, String email, String img)
			throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = DataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("update account set PassW=?,Email=?,avatar=? where UserName =?");
		ps.setString(1, passWord);
		ps.setString(2, email);
		ps.setString(3, img);
		ps.setString(4, userName);
		ps.executeUpdate();

	}

	public boolean settingUser(String userName, String passWord, String email)
			throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = DataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("update account set PassW=?,Email=? where UserName=?");
		ps.setString(1, passWord);
		ps.setString(2, email);
		ps.setString(3, userName);
		int check = ps.executeUpdate();

		boolean result = check == 1 ? true : false;
		return result;
	}

	public boolean deleteUser(String userName) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = DataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete account where UserName=?");
		ps.setString(1, userName);
		int check = ps.executeUpdate();
		boolean rs = check == 1 ? true : false;
		return rs;
	}

	// log in withfb
	public Account checkAcountFacebook(String email, String idfb) throws SQLException, FileNotFoundException {
		Account account = null;
		String query = "SELECT a.idUser,a.UserName,a.Password,a.Email,a.avatar,a.typeId,a.isActive,fb.idFacebook FROM animeweb.accounts a join animeweb.accounts_facebook fb on a.idUser=fb.idUser where a.Email= ? and fb.idFacebook=? and a.typeId=3;";

		Jdbi me = JDBiConnector.me();
		account = me.withHandle(handle -> {
			return handle.createQuery(query).bind(0, email).bind(1, idfb).mapToBean(Account.class).findFirst()
					.orElse(null);

		});
		if (account != null) {
			account.setRoles(getRoleUser(account.getIdUser()));
		}
		return account;

	}

	// add account fb if not exist on database
	public void insertAcountFB(String userName, String idFB, String email) throws SQLException {
		Encode encryption = new Encode();
		String query1 = "INSERT INTO animeweb.accounts (UserName,Password,Email,avatar,typeId,isActive)VALUES (?,?,?,null,3,1)";
		String query2 = "INSERT INTO animeweb.accounts_facebook (idFacebook,Username,idUser,Email)values(?,?,?,?)";
		String query3 = "INSERT INTO animeweb.account_roles(idUser,idrole)values(?,?)";

		Jdbi me = JDBiConnector.me();

		me.useHandle(handle -> {
			handle.begin();
			try {
				int userID = handle.createUpdate(query1).bind(0, userName).bind(1, encryption.toSHA1(idFB))
						.bind(2, email).executeAndReturnGeneratedKeys().mapTo(Integer.class).findFirst().orElse(-1);
				handle.execute(query2, idFB, userName, userID, email);
				handle.execute(query3, userID, 1);

				handle.commit();
			} catch (Exception e) {
				handle.rollback();
				e.printStackTrace();
			}
		});

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
//		System.out.println(new DAOAccounts().checkAcountFacebook("20130115@gmail.com", "12345678"));
//		new DAOAccounts().insertAcountFB("ádsada", "1231111", "he123he@gmail.com");
		//System.out.println(getListAccountNormal(0, 100).size());
		//System.out.println(getSizeListAccountNormal());

	}
}
