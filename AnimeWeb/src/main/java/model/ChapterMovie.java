package model;

public class ChapterMovie {
	private int idMovie;
	private int index;
	private int timeEndOpening;
	public ChapterMovie(int idMovie, int index, int timeEndOpening) {
		super();
		this.idMovie = idMovie;
		this.index = index;
		this.timeEndOpening = timeEndOpening;
	}
	public ChapterMovie() {
		super();
	}
	@Override
	public String toString() {
		return "ChapterMovie [idMovie=" + idMovie + ", index=" + index + ", timeEndOpening=" + timeEndOpening + "]";
	}
	
	

}
