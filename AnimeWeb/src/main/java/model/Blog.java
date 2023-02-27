package model;

import java.util.Date;
import java.util.List;

import controller.commentBlog;

public class Blog {
	private int id;
	private String title;
	private String folder;
	private Date datePost;
	private String avt;
	private Date dayDebut;
	private List<commentBlog> listComment;
	
	
	
	
	
	public Blog(int id, String title, String folder, Date datePost, String avt, Date dayDebut,
			List<commentBlog> listComment) {
		super();
		this.id = id;
		this.title = title;
		this.folder = folder;
		this.datePost = datePost;
		this.avt = avt;
		this.dayDebut = dayDebut;
		this.listComment = listComment;
	}


	public Blog(int id, String title, String avt, Date dayDebut) {
		super();
		this.id = id;
		this.title = title;
		this.avt = avt;
		this.dayDebut = dayDebut;
	}


	public Blog() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public Date getDatePost() {
		return datePost;
	}
	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}
	public String getAvt() {
		return avt;
	}
	public void setAvt(String avt) {
		this.avt = avt;
	}
	public Date getDayDebut() {
		return dayDebut;
	}
	public void setDayDebut(Date dayDebut) {
		this.dayDebut = dayDebut;
	}
	public List<commentBlog> getListComment() {
		return listComment;
	}
	public void setListComment(List<commentBlog> listComment) {
		this.listComment = listComment;
	}
	

	

	
//	public int getTotalComment() {
//		int rs=listCmt.size();
//		for(CommentBlog bc : listCmt) {
//			rs+=bc.getList().size();
//		}
//		
//		return rs;
//	}
	
	

	

}
