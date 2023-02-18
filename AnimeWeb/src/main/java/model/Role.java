package model;

public class Role {
	private int idRole;
	private String description;
	public Role(int idRole, String description) {
		super();
		this.idRole = idRole;
		this.description = description;
	}
	public int getIdRole() {
		return idRole;
	}
	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
