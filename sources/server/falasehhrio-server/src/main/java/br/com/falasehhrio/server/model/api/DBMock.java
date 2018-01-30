package br.com.falasehhrio.server.model.api;

import java.util.ArrayList;
import java.util.List;

import br.com.falasehhrio.server.Util;
import br.com.falasehhrio.server.model.Image;
import br.com.falasehhrio.server.model.Occurrence;
import br.com.falasehhrio.server.model.User;

public class DBMock {
	
	public static List<User> users;
	public static List<Image> images;
	public static List<Occurrence> occurrences;
	
	public DBMock() {
		super();
		
		users = new ArrayList<>();
		users.add(new User(users.size()+1, "admin@gmail.com", "12345678", Util.generateHashMD5("admin"), true, true));
		users.add(new User(users.size()+1, "usernormal@gmail.com", "12345678", Util.generateHashMD5("admin"), false, true));
		
		occurrences = new ArrayList<>();
		occurrences.add(new Occurrence(occurrences.size()+1L, "Infração", users.get(0), "São José - SC", null, null));
		occurrences.add(new Occurrence(occurrences.size()+1L, "Roubo", users.get(0), "Criciuma - SC", "Problema solucionado com uma conversa.", users.get(1)));
		occurrences.add(new Occurrence(occurrences.size()+1L, "Assalto", users.get(1), "São Paulo - SP", null, null));
		
		images = new ArrayList<>();
		images.add(new Image(occurrences.get(0), Util.generateHashMD5("image11")));
		images.add(new Image(occurrences.get(0), Util.generateHashMD5("image12")));
		images.add(new Image(occurrences.get(0), Util.generateHashMD5("image13")));
		
		images.add(new Image(occurrences.get(1), Util.generateHashMD5("image21")));
		images.add(new Image(occurrences.get(1), Util.generateHashMD5("image22")));
		images.add(new Image(occurrences.get(1), Util.generateHashMD5("image23")));
		
		images.add(new Image(occurrences.get(2), Util.generateHashMD5("image31")));
		images.add(new Image(occurrences.get(2), Util.generateHashMD5("image32")));
		images.add(new Image(occurrences.get(2), Util.generateHashMD5("image33")));
	}

}
