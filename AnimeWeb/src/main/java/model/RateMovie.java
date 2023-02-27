package model;

import java.util.Date;

public class RateMovie {
	private int idMovie;
	private int idUserVote;
	private double score;
	private Date timeVote;
	public RateMovie(int idMovie, int idUserVote, double score, Date timeVote) {
		super();
		this.idMovie = idMovie;
		this.idUserVote = idUserVote;
		this.score = score;
		this.timeVote = timeVote;
	}
	public RateMovie() {
		super();
	}
	public RateMovie(int idMovie, double score) {
		super();
		this.idMovie = idMovie;
		this.score = score;
	}
	public int getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}
	public int getIdUserVote() {
		return idUserVote;
	}
	public void setIdUserVote(int idUserVote) {
		this.idUserVote = idUserVote;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Date getTimeVote() {
		return timeVote;
	}
	public void setTimeVote(Date timeVote) {
		this.timeVote = timeVote;
	}
	
}
