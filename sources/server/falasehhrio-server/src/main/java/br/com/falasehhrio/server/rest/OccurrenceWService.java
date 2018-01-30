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

import br.com.falasehhrio.server.model.Occurrence;
import br.com.falasehhrio.server.model.OccurrenceMock;
import br.com.falasehhrio.server.model.api.ModelException;
import br.com.falasehhrio.server.rest.api.RestWServiceGeneric;

@RestController
@RequestMapping("/occurrence")
public class OccurrenceWService extends RestWServiceGeneric<Occurrence>{
	
	private static final Logger log = LoggerFactory.getLogger(OccurrenceWService.class);
	
	public OccurrenceWService() {
		super(new OccurrenceMock());
	}
	
	@RequestMapping("/get")
	public ResponseEntity<Occurrence> get(@RequestParam(value = "id") Long id) {
		try {
			log.info("init");
			Occurrence obj = db.get(id);
			if (obj != null){
				return new ResponseEntity<Occurrence>(obj, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (ModelException e) {
			log.error("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Occurrence m) {
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
	public ResponseEntity<List<Occurrence>> list() {
		try {
			log.info("init");
			List<Occurrence> list = db.list();
			if(list != null && list.size()>0){
				return new ResponseEntity<List<Occurrence>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Occurrence>>(HttpStatus.NOT_FOUND);
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
	public ResponseEntity<Boolean> exist(@RequestParam(value = "id") Long id) {
		try {
			log.info("init");
			return new ResponseEntity<>(db.exist(new Occurrence(id)), HttpStatus.OK);
		} catch (ModelException e) {
			log.error("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
