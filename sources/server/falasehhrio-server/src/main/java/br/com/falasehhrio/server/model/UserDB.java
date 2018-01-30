package br.com.falasehhrio.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.falasehhrio.server.model.api.ModelDBGeneric;
import br.com.falasehhrio.server.model.api.ModelDBView;
import br.com.falasehhrio.server.model.api.ModelException;
import br.com.falasehhrio.server.model.api.QueryDB;

public class UserDB extends ModelDBGeneric implements ModelDBView<User> {

	public UserDB() {
		super();
	}

	@Override
	public User get(Object id) throws ModelException {
		params = new ArrayList<>();
		params.add(id);
		return prepare(executeQuery(QueryDB.USER_SELECT, params));
	}

	@Override
	public void save(User m) throws ModelException {
		boolean exist = this.exist(m);
		params = new ArrayList<>();
		if (m.getId() == 0 || !exist) {
			params.addAll(m.toArrayWithoutId());
			executeUpdate(QueryDB.USER_INSERT, params);
		} else {
			params.addAll(m.toArrayIdLast());
			executeUpdate(QueryDB.USER_UPDATE, params);
		}

	}

	@Override
	public List<User> list() throws ModelException {
		return prepareAll(executeQuery(QueryDB.USER_SELECT_ALL));
	}

	@Override
	public void delete(Object id) throws ModelException {
		params = new ArrayList<>();
		params.add(id);
		executeUpdate(QueryDB.USER_DELETE, params);
	}

	@Override
	public boolean exist(User m) throws ModelException {
		try {
			params = new ArrayList<>();
			params.add(m.getId());

			ResultSet rs = executeQuery(QueryDB.USER_EXIST, params);
			if (rs.next() && rs.getInt(1) > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		}
	}

	@Override
	public User prepare(ResultSet rs) throws ModelException {
		try {
			if (rs.next()) {
				return new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("openid"), rs.getBoolean("admin"), rs.getBoolean("authority"));
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		}
		return null;
	}
	
	@Override
	public List<User> prepareAll(ResultSet rs) throws ModelException {
		List<User> list = null;
		try {
			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("openid"), rs.getBoolean("admin"), rs.getBoolean("authority")));
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		}
		return list;
	}

	public User get(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
