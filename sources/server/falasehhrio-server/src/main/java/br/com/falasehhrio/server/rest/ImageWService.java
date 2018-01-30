package br.com.falasehhrio.server.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.falasehhrio.server.model.Image;
import br.com.falasehhrio.server.model.ImageMock;
import br.com.falasehhrio.server.model.api.ModelException;
import br.com.falasehhrio.server.rest.api.RestWServiceGeneric;

@RestController
@RequestMapping("/image")
public class ImageWService extends RestWServiceGeneric<Image>{
	
	private static final Logger log = LoggerFactory.getLogger(ImageWService.class);
	
	public ImageWService() {
		super(new ImageMock());
	}
	
	@RequestMapping("/get")
	public ResponseEntity<Image> get(@RequestParam(value = "hash") String hash) {
		try {
			log.info("init");
			Image obj = db.get(hash);
			if (obj != null){
				return new ResponseEntity<Image>(obj, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (ModelException e) {
			log.error("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ResponseEntity<Void> save(@ModelAttribute("m") Image m) {
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
	public ResponseEntity<List<Image>> list() {
		try {
			log.info("init");
			List<Image> list = db.list();
			if(list != null && list.size()>0){
				return new ResponseEntity<List<Image>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Image>>(HttpStatus.NOT_FOUND);
			}
		} catch (ModelException e) {
			log.error("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/delete")
	public ResponseEntity<Void> delete(@RequestParam(value = "hash") String hash) {
		try {
			log.info("init");
			db.delete(hash);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (ModelException e) {
			log.error("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@RequestMapping("/exist")
	public ResponseEntity<Boolean> exist(@RequestParam(value = "hash") String hash) {
		try {
			log.info("init");
			return new ResponseEntity<>(db.exist(new Image(hash)), HttpStatus.OK);
		} catch (ModelException e) {
			log.error("Error: " + e.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

