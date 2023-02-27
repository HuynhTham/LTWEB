package model;

public class AvartarMovie {
	private int id;
	private String name;
	public AvartarMovie(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public AvartarMovie() {
		super();
	}
	@Override
	public String toString() {
		return "AvartarMovie [id=" + id + ", name=" + name + "]";
	}
	
}
