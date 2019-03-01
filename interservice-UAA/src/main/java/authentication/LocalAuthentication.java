package authentication;

/**
 * 
 * @author pedro.almeida
 *
 */
public class LocalAuthentication implements Authentication {

	@Override
	public User authenticate(String username, String password) {
		User u= new User("nao estas no ldap","gfd");
		
		return u;
	}

}
