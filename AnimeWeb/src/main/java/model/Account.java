package model;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import database.Rate;
import database.movie;

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
	private Date joinDate;
	private String fullName;
	private String phoneNumber;
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
	public Account(int idUser, String userName, String passWord, String email, String avatar, int typeId,
			int isActive,String fullName) {
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
	public Account(int idUser, String userName, String passWord, String email, String avatar, int typeId,
			int isActive,String fullName,String phoneNumber) {
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

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
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
				+ ", avatar=" + avatar + ", typeId=" + typeId + ", isActive=" + isActive + ", roles=" + roles + "]";
	}

	public int getmyRate(int idMovie) throws ClassNotFoundException, SQLException {
		Rate rate = new Rate();
		int rs = rate.getRate(userName, idMovie);
		return rs;
	}

	public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
//	        final String fromEmail = "20130305@st.hcmuaf.edu.vn";
//	        // Mat khai email cua ban
//	        final String password = "Linh@27092002";
//	        // dia chi email nguoi nhan
//	        final String toEmail = "goblinslayer27092002@gmail.com";
//	        final String subject = "Java Example Test";
//	        final String body = "Hello Admin";
//	        Properties props = new Properties();
//	        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
//	        props.put("mail.smtp.port", "587"); //TLS Port
//	        props.put("mail.smtp.auth", "true"); //enable authentication
//	        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
//	        Authenticator auth = new Authenticator() {
//	            protected PasswordAuthentication getPasswordAuthentication() {
//	                return new PasswordAuthentication(fromEmail, password);
//	            }
//	        };
//	        Session session = Session.getInstance(props, auth);
//	        MimeMessage msg = new MimeMessage(session);
//	        //set message headers
//	        msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
//	        msg.addHeader("format", "flowed");
//	        msg.addHeader("Content-Transfer-Encoding", "8bit");
//	        msg.setFrom(new InternetAddress(fromEmail, "NoReply-JD"));
//	        msg.setReplyTo(InternetAddress.parse(fromEmail, false));
//	        msg.setSubject(subject, "UTF-8");
//	        msg.setText(body, "UTF-8");
//	        msg.setSentDate(new Date());
//	        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
//	        Transport.send(msg);
//	        System.out.println("Gui mail thanh cong");
//	    }
//			Properties props = new Properties();
//			props.put("mail.smtp.auth", "true");
//			props.put("mail.smtp.starttls.enable", "true");
//			props.put("mail.smtp.host", "smtp.gmail.com");
//			props.put("mail.smtp.port", "587");
//
//			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//			    protected PasswordAuthentication getPasswordAuthentication() {
//			        return new PasswordAuthentication("20130305@st.hcmuaf.edu.vn", "Linh@27092002");
//			    }
//			});
//			Message message = new MimeMessage(session);
//			try {
//				message.setFrom(new InternetAddress("20130305@st.hcmuaf.edu.vn","Web phim"));
//				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("goblinslayer27092002@gmail.com"));
//				message.setSubject("Kích hoạt tài khoản");
//				message.setText("This is a test email from my Java web application");
//				Transport.send(message);
//			} catch (MessagingException e) {
//			e.printStackTrace();
//			}
	
	}
}
