package model;

import java.util.Date;

public class CommentReplyMovie {
	private int id;
	private int idCmt;
	private int idUserCmt;
	private int idUserReply;
	private String mess;
	private Date dayCmt;
	private int sttCmt;
	private int isActive;
	
	
	
	
	
	
	public CommentReplyMovie(int id, int idUserCmt, int idUserReply, String mess, Date dayCmt, int sttCmt,
			int isActive) {
		super();
		this.id = id;
		this.idUserCmt = idUserCmt;
		this.idUserReply = idUserReply;
		this.mess = mess;
		this.dayCmt = dayCmt;
		this.sttCmt = sttCmt;
		this.isActive = isActive;
	}
	public CommentReplyMovie() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCmt() {
		return idCmt;
	}
	public void setIdCmt(int idCmt) {
		this.idCmt = idCmt;
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
	@Override
	public String toString() {
		return "CommentReplyMovie [id=" + id + ", idCmt=" + idCmt + ", idUserCmt=" + idUserCmt + ", idUserReply="
				+ idUserReply + ", mess=" + mess + ", dayCmt=" + dayCmt + ", sttCmt=" + sttCmt + ", isActive="
				+ isActive + "]";
	}
	
	
}
