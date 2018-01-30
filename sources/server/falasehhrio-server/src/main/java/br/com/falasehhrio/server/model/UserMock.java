package br.com.falasehhrio.server.model;

import java.sql.ResultSet;
import java.util.List;

import br.com.falasehhrio.server.model.api.DBMock;
import br.com.falasehhrio.server.model.api.ModelDBView;
import br.com.falasehhrio.server.model.api.ModelException;
import br.com.falasehhrio.server.model.api.QueryDB;

public class UserMock implements ModelDBView<User> {

	@Override
	public ResultSet executeQuery(QueryDB queryDB, List<Object> params) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSet executeQuery(QueryDB queryDB) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executeUpdate(QueryDB queryDB, List<Object> params) throws ModelException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(Object obj) throws ModelException {
		if(obj instanceof Integer){
			for (User u : DBMock.users) {
				if(u.getId() == ((int) obj)){
					return u;
				}
			}
		} else if (obj instanceof User){
			for (User u : DBMock.users) {
				if(u.equalsForLogin((User)obj)){
					return u;
				}
			}
		}
		return null;
	}

	@Override
	public void save(User m) throws ModelException {
		if(m.getId() == 0){
			m.setId(DBMock.users.size()+1);
			DBMock.users.add(m);
			return;
		}
		for (int i = 0; i < DBMock.users.size(); i++) {
			if(DBMock.users.get(i).getId() == m.getId()){
				DBMock.users.set(i, m);
				return;
			}
		}
		DBMock.users.add(m);		
	}

	@Override
	public List<User> list() throws ModelException {
		return DBMock.users;
	}

	@Override
	public void delete(Object id) throws ModelException {
		for (User u : DBMock.users) {
			if(u.getId() == (int) id){
				DBMock.users.remove(u);
				break;
			}
		}
		
	}

	@Override
	public boolean exist(User m) throws ModelException {
		for (User u : DBMock.users) {
			if(u.equals(m)){
				return true;
			}
		}
		return false;
	}

	@Override
	public User prepare(ResultSet resultSet) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> prepareAll(ResultSet resultSet) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

}
