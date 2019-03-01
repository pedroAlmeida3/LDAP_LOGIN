package authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 
 * @author pedro.almeida
 *
 */
@Service
public class AuthenticationService {

	boolean ldapEnabled;

	Authentication authentication;
	
	/**
	 * 
	 * @param ldapEnabled check if the authentication is via LDAP or Local
	 * @param ldapConfig all LDAP configurations if needed
	 */
	public AuthenticationService(@Value("${ldap.enabled}") boolean ldapEnabled,
			@Autowired LdapConfigurations ldapConfig) {

		if (ldapEnabled) {
			authentication = new LDAPAuthentication(ldapConfig);
		} else {
			authentication = new LocalAuthentication();
		}
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return the user that is trying to authenticate
	 */
	public User getUserInfo(String username, String password) {

		return authentication.authenticate(username, password);

	}

}
