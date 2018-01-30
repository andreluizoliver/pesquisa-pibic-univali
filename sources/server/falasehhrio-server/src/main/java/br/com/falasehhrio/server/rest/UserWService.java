package br.com.falasehhrio.server.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.falasehhrio.server.model.User;
import br.com.falasehhrio.server.model.UserMock;
import br.com.falasehhrio.server.model.api.ModelException;
import br.com.falasehhrio.server.rest.api.RestWServiceGeneric;

@RestController
@RequestMapping("/user")
public class UserWService extends RestWServiceGeneric<User>{
	
	private static final Logger log = LoggerFactory.getLogger(UserWService.class);
	
	public UserWService() {
		super(new UserMock());
	}
	
	@RequestMapping("/get")
	public ResponseEntity<User> get(@RequestParam(value = "id") int id) {
		try {
			log.info("init");
			User obj = db.get(id);
			if (obj != null){
				log.info(obj.toString());
				return new ResponseEntity<User>(obj, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (ModelException e) {
			log.error("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody User m) {
		try {
			log.info("init");
			db.save(m);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ModelException e) {
			log.error("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/list")
	public ResponseEntity<List<User>> list() {
		try {
			log.info("init");
			List<User> list = db.list();
			if(list != null && list.size()>0){
				return new ResponseEntity<List<User>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
			}
		} catch (ModelException e) {
			log.error("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/delete")
	public ResponseEntity<Void> delete(@RequestParam(value = "id") Long id) {
		try {
			log.info("init");
			db.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ModelException e) {
			log.error("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@RequestMapping("/exist")
	public ResponseEntity<Boolean> exist(@RequestParam(value = "id") int id) {
		try {
			log.info("init");
			return new ResponseEntity<>(db.exist(new User(id)), HttpStatus.OK);
		} catch (ModelException e) {
			log.error("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
