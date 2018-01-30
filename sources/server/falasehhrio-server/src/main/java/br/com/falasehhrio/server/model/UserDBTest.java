package br.com.falasehhrio.server.model;

import java.util.List;

import br.com.falasehhrio.server.Util;
import br.com.falasehhrio.server.model.api.ModelException;
import junit.framework.TestCase;

public class UserDBTest extends TestCase {
	
	private UserDB db;
	private User obj;

	public void testGet() throws ModelException {
		this.db = new UserDB();
		this.obj = this.db.get(2L);
		System.out.println(obj.toString());
	}

	public void testSave() throws ModelException {
		this.db = new UserDB();
		this.obj = new User(0, "emassssilsss@hotmail.com", "jkhkjhjkhj", Util.generateHashMD5("jkhkjhjkhj"), true, false);
//		this.db.save(this.obj);
		
		this.obj = this.db.get(10L);
		this.obj.setEmail("email@mudou.com.br");
		this.db.save(this.obj);
	}

	public void testList() throws ModelException {
		this.db = new UserDB();
		List<User> list = this.db.list();
		for (User user : list) {
			System.out.println(user.toString());
		}
	}

	public void testDelete() throws ModelException {
		this.db = new UserDB();
		this.db.delete(2L);
		this.db.delete(3L);
		this.db.delete(6L);
		this.db.delete(8L);
	}

}
