package authentication;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author pedro.almeida
 *
 */
@Entity
public class User {
	
	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@Embedded
	private Password password;
	
	@ManyToMany(mappedBy = "users")
	private List<Role> roles;
	
	public User() {

	}

	public User(String name, Password password) {
		this.name = name;
		this.password = password;
		this.roles = new ArrayList<Role>();
	}

	public String getName() {
		return this.name;
	}

	public Password getPassword() {
		return this.password;
	}

	public List<Role> getGroups() {
		return this.roles;
	}
	
	public String toString() {
		return "User: " + this.name + "\nGroups: " + this.roles;
	}

}
