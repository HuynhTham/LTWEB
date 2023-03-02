package model;

import java.sql.SQLException;

import java.util.Date;
import java.util.List;



public class Movie {
	private int idMovie;
	private String nameMovie;
	private List<Genre> genre;
	private int currentEpisode;
	private int totalEpisode;
	private int views;
	private List<AvartarMovie> avatars;
	private List<CommentMovie> listComment;
	private List<ChapterMovie> listchapter;
	private String DescriptionVN;
	private String DescriptionEN;
	private int isActive;
	private List<RateMovie> listRate;
	private Date dayadd;
	private List<Producer> listProducer;
	private int typeID;
	
	
	public Movie(int idMovie, String nameMovie, int currentEpisode) {
		super();
		this.idMovie = idMovie;
		this.nameMovie = nameMovie;
		this.currentEpisode = currentEpisode;
	}

	public Movie(int idMovie, String nameMovie, List<Genre> genre, int currentEpisode, int totalEpisode, int views,
			List<AvartarMovie> avatars, List<CommentMovie> listComment, String descriptionVN, String descriptionEN,
			int isActive, List<RateMovie> listRate, Date dayadd, List<Producer> listProducer) {
		super();
		this.idMovie = idMovie;
		this.nameMovie = nameMovie;
		this.genre = genre;
		this.currentEpisode = currentEpisode;
		this.totalEpisode = totalEpisode;
		this.views = views;
		this.avatars = avatars;
		this.listComment = listComment;
		DescriptionVN = descriptionVN;
		DescriptionEN = descriptionEN;
		this.isActive = isActive;
		this.listRate = listRate;
		this.dayadd = dayadd;
		this.listProducer = listProducer;
	}

	public Movie(int idMovie, String nameMovie, List<Genre> genre, int views, List<AvartarMovie> avatars, int isActive,
			List<RateMovie> listRate) {
		super();
		this.idMovie = idMovie;
		this.nameMovie = nameMovie;
		this.genre = genre;
		this.views = views;
		this.avatars = avatars;
		this.isActive = isActive;
		this.listRate = listRate;
	}

	public Movie(int idMovie, String nameMovie, int currentEpisode, int totalEpisode, String descriptionVN,
			String descriptionEN, Date dayadd, int isActive) {
		super();
		this.idMovie = idMovie;
		this.nameMovie = nameMovie;
		this.currentEpisode = currentEpisode;
		this.totalEpisode = totalEpisode;
		DescriptionVN = descriptionVN;
		DescriptionEN = descriptionEN;
		this.isActive = isActive;
		this.dayadd = dayadd;
	}

	public Movie() {

	}

	public int getTypeID() {
		return typeID;
	}

	public void setTypeID(int typeID) {
		this.typeID = typeID;
	}

	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public String getNameMovie() {
		return nameMovie;
	}

	public void setNameMovie(String nameMovie) {
		this.nameMovie = nameMovie;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	public int getCurrentEpisode() {
		return currentEpisode;
	}

	public void setCurrentEpisode(int currentEpisode) {
		this.currentEpisode = currentEpisode;
	}

	public int getTotalEpisode() {
		return totalEpisode;
	}

	public void setTotalEpisode(int totalEpisode) {
		this.totalEpisode = totalEpisode;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<AvartarMovie> getAvatars() {
		return avatars;
	}

	public void setAvatars(List<AvartarMovie> avatars) {
		this.avatars = avatars;
	}

	public List<CommentMovie> getListComment() {
		return listComment;
	}

	public void setListComment(List<CommentMovie> listComment) {
		this.listComment = listComment;
	}

	public List<ChapterMovie> getListchapter() {
		return listchapter;
	}

	public void setListchapter(List<ChapterMovie> listchapter) {
		this.listchapter = listchapter;
	}

	public String getDescriptionVN() {
		return DescriptionVN;
	}

	public void setDescriptionVN(String descriptionVN) {
		DescriptionVN = descriptionVN;
	}

	public String getDescriptionEN() {
		return DescriptionEN;
	}

	public void setDescriptionEN(String descriptionEN) {
		DescriptionEN = descriptionEN;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public List<RateMovie> getListRate() {
		return listRate;
	}

	public void setListRate(List<RateMovie> listRate) {
		this.listRate = listRate;
	}

	public Date getDayadd() {
		return dayadd;
	}

	public void setDayadd(Date dayadd) {
		this.dayadd = dayadd;
	}

	public List<Producer> getListProducer() {
		return listProducer;
	}

	public void setListProducer(List<Producer> listProducer) {
		this.listProducer = listProducer;
	}

//	public double getAvgScore() throws ClassNotFoundException, SQLException {
//		Rate DBAO = new Rate();
//		ArrayList<Integer> listRate = DBAO.getListRate(idMovie);
//		model.RateMovie rate = new model.RateMovie(listRate);
//		double avgScore = rate.averageScore();
//
//		return (double) Math.ceil(avgScore * 10) / 10;
//	}
//
//	public int voteTotal() throws ClassNotFoundException, SQLException {
//		Rate DBAO = new Rate();
//		ArrayList<Integer> listRate = DBAO.getListRate(idMovie);
//		return listRate.size();
//	}

	public int getPerCent(double total) throws ClassNotFoundException, SQLException {

		return (int) ((views / total) * 100);

	}

}
