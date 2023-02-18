package model;

import java.sql.SQLException;
import java.util.ArrayList;

import database.Rate;

public class Account {
	private int idUser;
	private String userName;
	private String passWord;
	private String email;
	private String avatar;
	private int typeId;
	private int isActive;
	private ArrayList<Role> roles;
	public Account(int idUser, String userName, String passWord, String email, String avatar, int typeId,
			int isActive, ArrayList<Role> roles) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.avatar = avatar;
		this.typeId = typeId;
		this.isActive = isActive;
		this.roles = roles;
	}
	
	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}
	public int isAdmin() {
		for(Role role : roles) {
			if(role.getIdRole()==4) {
				return 1;
			}
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Account [idUser=" + idUser + ", userName=" + userName + ", passWord=" + passWord + ", email=" + email
				+ ", avatar=" + avatar + ", typeId=" + typeId + ", isActive=" + isActive + ", roles=" + roles + "]";
	}

	public int getmyRate(int idMovie) throws ClassNotFoundException, SQLException {
		Rate rate = new Rate();
		int rs=rate.getRate(userName, idMovie);
		return rs;
	}

}
