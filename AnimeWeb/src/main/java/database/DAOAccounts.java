package database;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.login;
import model.Account;
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
		int idUser=-1;
		Connection conn = DataSource.getConnection();
		PreparedStatement prepare = conn.prepareStatement("SELECT idUser FROM animeweb.accounts where UserName=? and typeId=1");
		prepare.setString(1, userName);
		ResultSet rs = prepare.executeQuery();
		if(rs.next()) {
			idUser = rs.getInt("idUser");
			return idUser;
		}
		return idUser;
		
		
	}
	public ArrayList<Role> getRoleUser(int idUser) throws SQLException{
		ArrayList<Role> result = new ArrayList<Role>();
		Connection conn = DataSource.getConnection();
		PreparedStatement prepare = conn.prepareStatement("select a.idrole,description from animeweb.account_roles a join animeweb.roles r on a.idrole = r.idrole where a.idUser=?");
		prepare.setInt(1, idUser);
		ResultSet rs = prepare.executeQuery();
		Role role;
		while(rs.next()) {
			role = new Role(rs.getInt("idrole"), rs.getString("description"));
			result.add(role);
		}
		return result;
	}
	public Account baseLogin(String userName,String passWord) throws SQLException {
		Account account = null;
		Connection conn = DataSource.getConnection();
		PreparedStatement prepare = conn.prepareStatement("SELECT idUser,UserName,Password,Email,avatar,typeId,isActive FROM animeweb.accounts where UserName=? and Password =? and typeId=1");
		prepare.setString(1, userName);
		prepare.setString(2, passWord);
		ResultSet rs = prepare.executeQuery();
		if(rs.next()) {
			account = new Account(rs.getInt("idUser"), rs.getString("UserName"),rs.getString("Password"), rs.getString("Email"), rs.getString("avatar"), rs.getInt("typeId"), rs.getInt("isActive"),null);
			account.setRoles(getRoleUser(account.getIdUser()));
			
		}
		return account;
	}
	public 
	


	public void changeProfile(String userName, String passWord, String email, String img) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = DataSource.getConnection();
			
		PreparedStatement ps = conn.prepareStatement("update account set PassW=?,Email=?,avatar=? where UserName =?");
		ps.setString(1, passWord);
		ps.setString(2,email);
		ps.setString(3, img);
		ps.setString(4, userName);
		ps.executeUpdate();
		
		
		
	}
	public boolean settingUser(String userName,String passWord,String email) throws ClassNotFoundException, SQLException {
			Connection conn = null;
			conn = DataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement("update account set PassW=?,Email=? where UserName=?");
			ps.setString(1, passWord);
			ps.setString(2, email);
			ps.setString(3, userName);
			int check = ps.executeUpdate();
			
		boolean result=	check==1?true:false;
		return result;
	}
	public boolean deleteUser(String userName) throws ClassNotFoundException, SQLException{
		Connection conn = null;
		conn = DataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement("delete account where UserName=?");
		ps.setString(1, userName);
		int check = ps.executeUpdate();
		boolean rs = check==1?true:false;
		return rs;
	}
	
	

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//	System.out.println(new DAOAccounts().getConnection());
//	System.out.println(new movie().getMovie());
//	System.out.println(new blog().getlistBlog());
	Connection conn = null;
	conn = DataSource.getConnection();
	PreparedStatement ps = conn.prepareStatement("SELECT `AUTO_INCREMENT` FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = ? AND   TABLE_NAME   = ?");
	ps.setString(1, "animeweb");
	ps.setString(2, "accounts");
	ResultSet n = ps.executeQuery();
	n.next();
	System.out.println(n.getInt(1));
	}
}
