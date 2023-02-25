package database;

import java.io.FileNotFoundException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.result.ResultBearing;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import controller.login;
import model.Account;
import model.Encode;
import model.Role;

public class DAOAccounts {
	public DAOAccounts() {

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
		String query = "SELECT idUser,UserName,Password,Email,avatar,typeId,isActive FROM animeweb.accounts where UserName= :UserName and Password = :Password and typeId=1";
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
		Connection conn = DataSource.getConnection();
		PreparedStatement prepare = conn
				.prepareStatement("SELECT idUser from animeweb.accounts_google where idGoogle =? and Email=? ");
		prepare.setString(1, idGoogle);
		prepare.setString(2, email);
		ResultSet rs = prepare.executeQuery();
		if (rs.next()) {
			id = rs.getInt("idUser");
			return id;
		}
		return -1;
	}
//
//	public Account loginAccountByGoogle(int idUser, int type) throws SQLException, FileNotFoundException {
//		Account account = null;
//		Connection conn = DataSource.getConnection();
//		PreparedStatement prepare = conn.prepareStatement(
//				"SELECT idUser,UserName,Password,Email,avatar,typeId,isActive FROM animeweb.accounts where idUser=? and typeId=?");
//		prepare.setInt(1, idUser);
//		prepare.setInt(2, type);
//		ResultSet rs = prepare.executeQuery();
//
//		if (rs.next()) {
//			account = new Account(rs.getInt("idUser"), rs.getString("UserName"), rs.getString("Password"),
//					rs.getString("Email"), rs.getString("avatar"), rs.getInt("typeId"), rs.getInt("isActive"),
//					getRoleUser(idUser));
//
//		}
//		return account;
//
//	}

	public int findIdUserAccount(String email, int type) throws SQLException {
		int id;
		Connection conn = DataSource.getConnection();
		PreparedStatement prepare = conn
				.prepareStatement("SELECT idUser from animeweb.accounts where  Email=? and typeId =?");
		prepare.setString(1, email);
		prepare.setInt(2, type);
		ResultSet rs = prepare.executeQuery();
		if (rs.next()) {
			id = rs.getInt("idUser");
			return id;
		}
		return -1;
	}

	public void addGoogle(String idGoogle, String email, String userName) throws SQLException {
		Connection conn = null;

		Encode encrypt = new Encode();
		ResultSet rs = null;
		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement prepare = conn.prepareStatement(
					"INSERT INTO accounts (Username, Password,Email,avatar,typeId,isActive) VALUES (?,?,?,null,2,1) ",
					Statement.RETURN_GENERATED_KEYS);
			prepare.setString(1, userName);
			prepare.setString(2, encrypt.toSHA1(userName));
			prepare.setString(3, email);
			int num = prepare.executeUpdate();
			rs = prepare.getGeneratedKeys();

			int idUser = 0;
			if (rs.next()) {
				idUser = rs.getInt(1);
				System.out.println(idUser);
			}
			if (num == 1) {
				PreparedStatement prepare2 = conn.prepareStatement(
						"INSERT INTO  accounts_google (idGoogle, Username,idUser,Email) VALUES (?,?,?,?) ");
				prepare2.setString(1, idGoogle);
				prepare2.setString(2, userName);
				prepare2.setInt(3, idUser);
				prepare2.setString(4, email);
				prepare2.executeUpdate();

				conn.commit();
			} else {

				conn.rollback();
			}
		} catch (Exception e) {
			try {
				if (conn != null)
					conn.rollback();
			} catch (SQLException e1) {
				System.out.println(e.getMessage());
			}
		}
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
				int userID = handle.createUpdate(query1).bind(0, userName)
						.bind(1, encryption.toSHA1(idFB)).bind(2, email)
						.executeAndReturnGeneratedKeys().mapTo(Integer.class).findFirst().orElse(-1);
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
		new DAOAccounts().insertAcountFB("ádsada", "1231111", "he123he@gmail.com");

	}
}
