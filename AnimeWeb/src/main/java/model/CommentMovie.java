package model;

import java.text.ParseException;

import java.util.Date;
import java.util.List;

public class CommentMovie {
	private int id;
	private int userId;
	private String mess;
	private int idMovie;
	private Date timeComment;
	private int isActive;
	private List<CommentReplyMovie> listReplyComment;

	public CommentMovie(int id, int userId, String mess, Date timeComment, int isActive) {
		super();
		this.id = id;
		this.userId = userId;
		this.mess = mess;
		this.timeComment = timeComment;
		this.isActive = isActive;
	}

	public CommentMovie(int id, int isActive) {
		super();
		this.id = id;
		this.isActive = isActive;
	}

	public CommentMovie(int id, int userId, String mess, int idMovie, Date timeComment,List<CommentReplyMovie> listReplyComment, int isActive) {
		super();
		this.id = id;
		this.userId = userId;
		this.mess = mess;
		this.idMovie = idMovie;
		this.timeComment = timeComment;
		this.isActive = isActive;
		this.listReplyComment = listReplyComment;
	}

	public CommentMovie() {
		super();
	}

	public String getDifferentTime() throws ParseException {
		Date now = new Date();
		long timeDiff = (now.getTime()- getTimeComment().getTime()) / (60 * 1000);

		String year = (timeDiff / (1000 * 60 * 60 * 24) / 30 / 12) + "";
		String month = (timeDiff / (1000 * 60 * 60 * 24) / 30) + "";
		String day = (timeDiff / (1000 * 60 * 60 * 24)) + "";
		String hour = (timeDiff / (1000 * 60 * 60)) + "";
		String minutes = (timeDiff / (1000 * 60)) + "";
		String seconds = (timeDiff / (1000)) + "";
		if (Long.valueOf(year) > 0) {
			return year + " năm";
		}
		if (Long.valueOf(month) > 0) {
			return month + " tháng trước";
		}
		if (Long.valueOf(day) > 0) {
			return day + " ngày trước";
		}
		if (Long.valueOf(hour) > 0) {
			return hour + " giờ trước";
		}
		if (Long.valueOf(minutes) > 0) {
			return minutes + " phút trước";
		}
		if (Long.valueOf(seconds) > 0) {
			return seconds + " giây trước";
		}
		return "Vừa mới đây";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getComment() {
		return mess;
	}

	public void setComment(String comment) {
		this.mess = comment;
	}

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public Date getTimeComment() {
		return timeComment;
	}

	public void setTimeComment(Date timeComment) {
		this.timeComment = timeComment;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	

	public List<CommentReplyMovie> getListReplyComment() {
		return listReplyComment;
	}

	public void setListReplyComment(List<CommentReplyMovie> listReplyComment) {
		this.listReplyComment = listReplyComment;
	}

	public static void main(String[] args) throws ParseException {

	}

}
