package model;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jdbi.v3.core.Jdbi;

import database.JDBiConnector;
import database.Rate;

public class Account {
	private int idUser;
	private String userName;
	private String passWord;
	private String email;
	private String avatar;
	private int typeId;
	private int isActive;
	private List<Role> roles;
	private List<Movie> moviesFollow;
	private List<Movie> moviesPurchased;
	private LocalDateTime joinDate;
	private String fullName;
	private String phoneNumber;
	static Map<Integer, String> isActiveMapping = new HashMap<>();
	static {
		isActiveMapping.put(0, "Bị khóa");
		isActiveMapping.put(1, "Đang hoạt động");
		

	}
	public static int LOCK = 0;
	public static int ACTIVED = 1;
	public Account(int idUser, String avatar, String fullName, String phoneNumber, String email, int isActive,
			LocalDateTime joinDate) {
		this.idUser = idUser;
		this.avatar = avatar;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.isActive = idUser;
		this.joinDate = joinDate;
	}

	public Account(int idUser, String userName, String passWord, String email, String avatar, int typeId, int isActive,
			ArrayList<Role> roles, ArrayList<Movie> moviesFollow) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.avatar = avatar;
		this.typeId = typeId;
		this.isActive = isActive;
		this.roles = roles;
		this.moviesFollow = moviesFollow;
	}

	public Account() {

	}
	

	public Account(int idUser, String userName, String passWord, String email, String avatar, int typeId,
			int isActive) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.avatar = avatar;
		this.typeId = typeId;
		this.isActive = isActive;
	}

	public Account(int idUser, String userName, String passWord, String email, String avatar, int typeId, int isActive,
			String fullName) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.avatar = avatar;
		this.typeId = typeId;
		this.isActive = isActive;
		this.fullName = fullName;
	}

	public Account(int idUser, String userName, String passWord, String email, String avatar, int typeId, int isActive,
			String fullName, String phoneNumber) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.avatar = avatar;
		this.typeId = typeId;
		this.isActive = isActive;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
	}
	public String getFullJoinDate() {
		return joinDate.getDayOfMonth()+"/"+joinDate.getMonthValue()+"/"+joinDate.getYear(); 
	}
	public String getTypeAccount() {
		return TypeUser.TypeMapping.get(typeId);
	}
	

	public List<Movie> getMoviesPurchased() {
		return moviesPurchased;
	}

	public void setMoviesPurchased(List<Movie> moviesPurchased) {
		this.moviesPurchased = moviesPurchased;
	}

	public Account(LocalDateTime date) {
		this.joinDate = date;
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
	public String getIsActiveDescription() {
		return isActiveMapping.get(isActive);
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> listRole) {
		this.roles = listRole;
	}

	public int isAdmin() {
		for (Role role : roles) {
			if (role.getIdRole() == 4) {
				return 1;
			}
		}
		return 0;
	}

	public List<Movie> getMoviesFollow() {
		return moviesFollow;
	}

	public void setMoviesFollow(List<Movie> moviesFollow) {
		this.moviesFollow = moviesFollow;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Account [idUser=" + idUser + ", userName=" + userName + ", passWord=" + passWord + ", email=" + email
				+ ", avatar=" + avatar + ", typeId=" + typeId + ", isActive=" + isActive + ", roles=" + roles
				+ ", moviesFollow=" + moviesFollow + ", joinDate=" + joinDate + ", fullName=" + fullName
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	public int getmyRate(int idMovie) throws ClassNotFoundException, SQLException {
		Rate rate = new Rate();
		int rs = rate.getRate(userName, idMovie);
		return rs;
	}

	public static void main(String[] args) {
		Jdbi me = JDBiConnector.me();
		List<Account> products = me.withHandle(handle -> {
			return handle.createQuery("select * from accounts LIMIT 1 OFFSET 0").mapToBean(Account.class).stream()
					.collect(Collectors.toList());
		});
		System.out.println(products);

	}
}
