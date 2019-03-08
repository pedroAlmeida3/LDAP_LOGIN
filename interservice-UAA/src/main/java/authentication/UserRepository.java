package authentication;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * reads an entity given its ID
	 *
	 * @param id
	 * @return
	 */
	public User matchByNamenAndPasswd(String name, String password);

}
