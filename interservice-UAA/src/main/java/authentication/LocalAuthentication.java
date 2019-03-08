package authentication;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author pedro.almeida
 *
 */
public class LocalAuthentication implements Authentication {

	

	@Override
	public User authenticate(String username, String password) {
		
		
		UserRepository repo=new UserRepositorioJPAImpl();

		return repo.matchByNamenAndPasswd(username, password);
	}

}
