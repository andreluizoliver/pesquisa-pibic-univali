package br.com.falasehhrio.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.falasehhrio.server.model.api.ModelDBGeneric;
import br.com.falasehhrio.server.model.api.ModelDBView;
import br.com.falasehhrio.server.model.api.ModelException;
import br.com.falasehhrio.server.model.api.QueryDB;

public class OccurrenceDB extends ModelDBGeneric implements ModelDBView<Occurrence> {

	
	public OccurrenceDB() {
		super();
	}

	@Override
	public Occurrence get(Object id) throws ModelException {
		params = new ArrayList<>();
		params.add(id);
		return prepare(executeQuery(QueryDB.OCCURRENCE_SELECT, params));
	}

	@Override
	public void save(Occurrence m) throws ModelException {
		boolean exist = this.exist(m);
		params = new ArrayList<>();
		if (m.getId() == null || !exist) {
			params.addAll(m.toArrayWithoutId());
			executeUpdate(QueryDB.OCCURRENCE_INSERT, params);
		} else {
			params.addAll(m.toArrayIdLast());
			executeUpdate(QueryDB.OCCURRENCE_UPDATE, params);
		}
		
	}

	@Override
	public List<Occurrence> list() throws ModelException {
		return prepareAll(executeQuery(QueryDB.OCCURRENCE_SELECT_ALL));
	}

	@Override
	public void delete(Object id) throws ModelException {
		params = new ArrayList<>();
		params.add(id);
		executeUpdate(QueryDB.OCCURRENCE_DELETE, params);
		
	}

	@Override
	public boolean exist(Occurrence m) throws ModelException {
		try {
			params = new ArrayList<>();
			params.add(m.getId());

			ResultSet rs = executeQuery(QueryDB.OCCURRENCE_EXIST, params);
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
	public Occurrence prepare(ResultSet rs) throws ModelException {
		try {
			if (rs.next()) {
				return new Occurrence(rs.getLong("id"), 
						rs.getString("desc_open"), 
						new User(rs.getInt("id_user_open")), 
						rs.getString("localization"), 
						rs.getString("desc_conclusion"), 
						new User(rs.getInt("id_user_conclusion")));
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		}
		return null;
	}

	@Override
	public List<Occurrence> prepareAll(ResultSet rs) throws ModelException {
		List<Occurrence> list = null;
		try {
			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Occurrence(rs.getLong("id"), 
						rs.getString("desc_open"), 
						new User(rs.getInt("id_user_open")), 
						rs.getString("localization"), 
						rs.getString("desc_conclusion"), 
						new User(rs.getInt("id_user_conclusion"))));
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		}
		return list;
	}
	
}
