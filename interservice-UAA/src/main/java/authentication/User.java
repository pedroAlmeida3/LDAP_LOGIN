package authentication;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author pedro.almeida
 *
 */
public class User {

	private String name;

	private String password;

	private List<String> groups;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
		this.groups = new ArrayList<String>();
	}

	public User() {

	}

	public String getName() {
		return this.name;
	}

	public String getPassword() {
		return this.password;
	}

	public List<String> getGroups() {
		return this.groups;
	}
	
	public String toString() {
		return "User: " + this.name + "\nGroups: " + this.groups;
	}

}
