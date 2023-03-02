package model;

import java.util.HashMap;
import java.util.Map;

public class Role {
	private int idRole;
	private String description;
	public static int base_User = 1;
	public static int admin = 4;
	static Map<Integer, String> roleMapping = new HashMap<>();
	static {
		
		roleMapping.put(1, "base_User");
		roleMapping.put(4, "admin");
	}

	public Role(int idRole, String description) {
		super();
		this.idRole = idRole;
		this.description = description;
	}
	public Role() {
		
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
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", description=" + description + "]";
	}
	
}
