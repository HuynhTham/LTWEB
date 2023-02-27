package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommentReplyBlog {
	private int idBlog;
	private int idcmt;
	private int idUserCmt;
	private int idUserReply;
	private String mess;
	private Date dayCmt;
	private int sttCmt;
	private int isActive;




	public CommentReplyBlog(int idBlog, int idcmt, int idUserCmt, int idUserReply, String mess, Date dayCmt,
			int sttCmt) {
		super();
		this.idBlog = idBlog;
		this.idcmt = idcmt;
		this.idUserCmt = idUserCmt;
		this.idUserReply = idUserReply;
		this.mess = mess;
		this.dayCmt = dayCmt;
		this.sttCmt = sttCmt;
	}



	public CommentReplyBlog() {
		super();
	}



	public CommentReplyBlog(int idBlog, int idcmt, int idUserCmt, int idUserReply, String mess, Date dayCmt, int sttCmt,
			int isActive) {
		super();
		this.idBlog = idBlog;
		this.idcmt = idcmt;
		this.idUserCmt = idUserCmt;
		this.idUserReply = idUserReply;
		this.mess = mess;
		this.dayCmt = dayCmt;
		this.sttCmt = sttCmt;
		this.isActive = isActive;
	}



	public int getIdBlog() {
		return idBlog;
	}



	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}



	public int getIdcmt() {
		return idcmt;
	}



	public void setIdcmt(int idcmt) {
		this.idcmt = idcmt;
	}



	public int getIdUserCmt() {
		return idUserCmt;
	}



	public void setIdUserCmt(int idUserCmt) {
		this.idUserCmt = idUserCmt;
	}



	public int getIdUserReply() {
		return idUserReply;
	}



	public void setIdUserReply(int idUserReply) {
		this.idUserReply = idUserReply;
	}



	public String getMess() {
		return mess;
	}



	public void setMess(String mess) {
		this.mess = mess;
	}



	public Date getDayCmt() {
		return dayCmt;
	}



	public void setDayCmt(Date dayCmt) {
		this.dayCmt = dayCmt;
	}



	public int getSttCmt() {
		return sttCmt;
	}



	public void setSttCmt(int sttCmt) {
		this.sttCmt = sttCmt;
	}



	public int getIsActive() {
		return isActive;
	}



	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String fm = format.format(date);
		System.out.println(fm);
	}

}
