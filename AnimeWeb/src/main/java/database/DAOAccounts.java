package database;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

	public void blockAccount(int idUser) throws SQLException {
		Connection conn = DataSource.getConnection();
		PreparedStatement prepare = conn.prepareStatement("UPDATE animeweb.accounts SET isActive = 0 WHERE idUser=? ");
		prepare.setInt(1, idUser);
		prepare.execute();
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

	public ArrayList<Role> getRoleUser(int idUser) throws SQLException {
		ArrayList<Role> result = new ArrayList<Role>();
		Connection conn = DataSource.getConnection();
		PreparedStatement prepare = conn.prepareStatement(
				"select a.idrole,description from animeweb.account_roles a join animeweb.roles r on a.idrole = r.idrole where a.idUser=?");
		prepare.setInt(1, idUser);
		ResultSet rs = prepare.executeQuery();
		Role role;
		while (rs.next()) {
			role = new Role(rs.getInt("idrole"), rs.getString("description"));
			result.add(role);
		}
		return result;
	}

	public Account baseLogin(String userName, String passWord) throws SQLException {
		Account account = null;
		Connection conn = DataSource.getConnection();
		PreparedStatement prepare = conn.prepareStatement(
				"SELECT idUser,UserName,Password,Email,avatar,typeId,isActive FROM animeweb.accounts where UserName=? and Password =? and typeId=1");
		prepare.setString(1, userName);
		prepare.setString(2, passWord);
		ResultSet rs = prepare.executeQuery();
		if (rs.next()) {
			account = new Account(rs.getInt("idUser"), rs.getString("UserName"), rs.getString("Password"),
					rs.getString("Email"), rs.getString("avatar"), rs.getInt("typeId"), rs.getInt("isActive"), null);
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

	public Account loginAccountByGoogle(int idUser, int type) throws SQLException {
		Account account = null;
		Connection conn = DataSource.getConnection();
		PreparedStatement prepare = conn.prepareStatement(
				"SELECT idUser,UserName,Password,Email,avatar,typeId,isActive FROM animeweb.accounts where idUser=? and typeId=?");
		prepare.setInt(1, idUser);
		prepare.setInt(2, type);
		ResultSet rs = prepare.executeQuery();

		if (rs.next()) {
			account = new Account(rs.getInt("idUser"), rs.getString("UserName"), rs.getString("Password"),
					rs.getString("Email"), rs.getString("avatar"), rs.getInt("typeId"), rs.getInt("isActive"),
					getRoleUser(idUser));

		}
		return account;

	}

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
	public Account checkAcountFacebook(String email, String idfb) throws SQLException {
		Connection conn = null;
		conn = DataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement(
				"SELECT a.idUser,a.UserName,a.Password,a.Email,a.avatar,a.typeId,a.isActive,fb.idFacebook FROM animeweb.accounts a join animeweb.accounts_facebook fb \r\n"
						+ "on a.idUser=fb.idUser where a.Email=?and fb.idFacebook=? and a.typeId=3;");
		ps.setString(1, email);
		ps.setString(2, idfb);
		ResultSet rs = ps.executeQuery();
		int idUser;
		Account account = null;
		while (rs.next()) {
			idUser = rs.getInt("idUser");
			account = new Account(idUser, rs.getString("UserName"), rs.getString("Password"), rs.getString("Email"),
					rs.getString("avatar"), rs.getInt("typeId"), rs.getInt("isActive"), getRoleUser(idUser));
		}
		return account;
	}

	// add account fb if not exist on database

	public void insertAcountFB(String userName, String idFB, String email) throws SQLException {
		Account res = null;
		Connection conn = null;
		Encode encryption = new Encode();

		// Dùng để lấy idUser vừa thêm vào
		ResultSet rs = null;

		PreparedStatement ps = null;
		PreparedStatement ps2 = null;

		try {
			conn = DataSource.getConnection();
			conn.setAutoCommit(false);// bật transaction
			// insert vào bảng aacount
			ps = conn.prepareStatement(
					"INSERT INTO animeweb.accounts (UserName,Password,Email,avatar,typeId,isActive)VALUES (?,?,?,null,3,1)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, userName);
			ps.setString(2, encryption.toSHA1(idFB));
			ps.setString(3, email);
			ps.executeUpdate();

			rs = ps.getGeneratedKeys();
			int candidateId = 0;
			if (rs.next()) {
				candidateId = rs.getInt(1);
				// insert vào table fb
				ps2 = conn.prepareStatement(
						"INSERT INTO animeweb.accounts_facebook (idFacebook,Username,idUser,Email)values(?,?,?,?)");
				ps2.setString(1, idFB);
				ps2.setString(2, userName);
				ps2.setInt(3, candidateId);
				ps2.setString(4, email);
				ps2.executeUpdate();
			} else {
				conn.commit();

			}
		} catch (SQLException e) {
			if (conn != null) {
				try {
					conn.rollback(); // Rollback transaction nếu có lỗi
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (ps2 != null) {
					ps2.close();
				}
				if (conn != null) {
					conn.setAutoCommit(true); // Tắt transaction
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

	}
}
