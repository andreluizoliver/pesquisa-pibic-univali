package br.com.falasehhrio.server.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.falasehhrio.server.model.User;
import br.com.falasehhrio.server.model.UserMock;
import br.com.falasehhrio.server.model.api.ModelException;
import br.com.falasehhrio.server.rest.api.RestWServiceGeneric;

@RestController
public class LoginWService extends RestWServiceGeneric<User> {

	private static final Logger log = LoggerFactory.getLogger(LoginWService.class);

	public LoginWService() {
		super(new UserMock());
	}

	@RequestMapping("/login")
	public ResponseEntity<User> get(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password) {
		try {
			log.info("init");
			User obj = db.get(new User(email, password));
			if (obj != null) {
				return new ResponseEntity<User>(obj, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (ModelException e) {
			log.error("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
