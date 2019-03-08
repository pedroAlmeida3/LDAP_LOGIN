package authentication;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Embeddable
public class Password {
	
	private String password;
	
	public Password(String password) {
		
		this.password = password;
		
	}

	public Password() {

	}

	public String getPassword() {
		return this.password;
	}

}
