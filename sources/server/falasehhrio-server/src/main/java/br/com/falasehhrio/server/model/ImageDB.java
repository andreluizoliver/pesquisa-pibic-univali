package br.com.falasehhrio.server.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.falasehhrio.server.model.api.ModelDBGeneric;
import br.com.falasehhrio.server.model.api.ModelDBView;
import br.com.falasehhrio.server.model.api.ModelException;
import br.com.falasehhrio.server.model.api.QueryDB;

public class ImageDB extends ModelDBGeneric implements ModelDBView<Image> {
	
	public ImageDB() {
		super();
	}

	@Override
	public Image get(Object id) throws ModelException {
		params = new ArrayList<>();
		params.add(id);
		return prepare(executeQuery(QueryDB.IMAGE_SELECT, params));
	}

	@Override
	public void save(Image m) throws ModelException {
		boolean exist = this.exist(m);
		params = new ArrayList<>();
		if (m.getHashImg() == null || !exist) {
			params.addAll(m.toArrayWithoutId());
			executeUpdate(QueryDB.IMAGE_INSERT, params);
		} else {
			params.addAll(m.toArrayIdLast());
			executeUpdate(QueryDB.IMAGE_UPDATE, params);
		}
		
	}

	@Override
	public List<Image> list() throws ModelException {
		return prepareAll(executeQuery(QueryDB.IMAGE_SELECT_ALL));
	}

	@Override
	public void delete(Object id) throws ModelException {
		params = new ArrayList<>();
		params.add(id);
		executeUpdate(QueryDB.IMAGE_DELETE, params);
		
	}

	@Override
	public boolean exist(Image m) throws ModelException {
		try {
			params = new ArrayList<>();
			params.add(m.getHashImg());

			ResultSet rs = executeQuery(QueryDB.IMAGE_EXIST, params);
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
	public Image prepare(ResultSet rs) throws ModelException {
		try {
			if (rs.next()) {
				return new Image(new Occurrence(rs.getLong("id_occurrence")), rs.getString("hash"));
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		}
		return null;
	}

	@Override
	public List<Image> prepareAll(ResultSet rs) throws ModelException {
		List<Image> list = null;
		try {
			list = new ArrayList<>();
			while (rs.next()) {
				list.add(new Image(new Occurrence(rs.getLong("id_occurrence")), rs.getString("hash")));
			}
		} catch (SQLException e) {
			throw new ModelException(e);
		}
		return list;
	}

}
