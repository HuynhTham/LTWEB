package model;

import java.util.ArrayList;
import java.util.Date;



public class CommentBlog {
	private int idBlog;
	private int id;
	private String mess;
	private int idUser;
	private Date dateCmt;
	private int isActive;
	private ArrayList<CommentReplyBlog> listReply;
	
	
	
	
	

	public CommentBlog(int idBlog, int id, String mess, int idUser, Date dateCmt, int isActive,
			ArrayList<CommentReplyBlog> listReply) {
		super();
		this.idBlog = idBlog;
		this.id = id;
		this.mess = mess;
		this.idUser = idUser;
		this.dateCmt = dateCmt;
		this.isActive = isActive;
		this.listReply = listReply;
	}


	

	public CommentBlog(int id,int isActive) {
		super();
		this.id = id;
		this.isActive = isActive;
	}




	public CommentBlog(int idBlog, int id, int isActive) {
		super();
		this.idBlog = idBlog;
		this.id = id;
		this.isActive = isActive;
	}











	public CommentBlog() {
		super();
	}
	
	
	
	
	
	
	
	
	
	
	
	public int getIdBlog() {
		return idBlog;
	}
	public void setIdBlog(int idBlog) {
		this.idBlog = idBlog;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Date getDateCmt() {
		return dateCmt;
	}
	public void setDateCmt(Date dateCmt) {
		this.dateCmt = dateCmt;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public ArrayList<CommentReplyBlog> getListReply() {
		return listReply;
	}
	public void setListReply(ArrayList<CommentReplyBlog> listReply) {
		this.listReply = listReply;
	}
	
	
	

	
}
