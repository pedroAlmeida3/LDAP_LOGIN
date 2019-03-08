package authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials = "true")
public class UAAController {

	@Autowired
	private AuthenticationService authenticationService;

	/**
	 * 
	 * @param user the user that is trying to access
	 * @return the user if it is successfull or a bad request if not
	 */
	@GetMapping("/login")
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public Object getUserInfo(@RequestBody User user) {
		
		User usr = authenticationService.getUserInfo(user.getName(), user.getPassword().getPassword());

		if (usr == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		else
			return usr;

	}
}