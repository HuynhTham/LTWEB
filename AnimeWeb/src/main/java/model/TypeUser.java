package model;

import java.util.HashMap;
import java.util.Map;

public class TypeUser {

	public static int Base_User = 1;
	public static int Google_User = 2;
	public static int Facebook_User = 3;
	static Map<Integer, String> TypeMapping = new HashMap<>();
	static {

		TypeMapping.put(1, "Base User");
		TypeMapping.put(2, "Google User");
		TypeMapping.put(3, "Facebook User");

	}

}
