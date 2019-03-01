package authentication;

/**
 * 
 * @author pedro.almeida
 *
 */
public interface Authentication {

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public User authenticate(String username, String password);

}
