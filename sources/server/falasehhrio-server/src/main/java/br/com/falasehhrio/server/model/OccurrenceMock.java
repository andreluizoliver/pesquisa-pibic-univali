package br.com.falasehhrio.server.model;

import java.sql.ResultSet;
import java.util.List;

import br.com.falasehhrio.server.model.api.DBMock;
import br.com.falasehhrio.server.model.api.ModelDBView;
import br.com.falasehhrio.server.model.api.ModelException;
import br.com.falasehhrio.server.model.api.QueryDB;

public class OccurrenceMock implements ModelDBView<Occurrence> {

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
	public Occurrence get(Object id) throws ModelException {
		for (Occurrence u : DBMock.occurrences) {
			if(u.getId().equals(id)){
				return u;
			}
		}
		return null;
	}

	@Override
	public void save(Occurrence m) throws ModelException {
		if(m.getId() == null || m.getId() == 0L){
			m.setId(DBMock.occurrences.size()+1L);
			DBMock.occurrences.add(m);
			return;
		}
		for (int i = 0; i < DBMock.occurrences.size(); i++) {
			if(DBMock.occurrences.get(i).getId() == m.getId()){
				DBMock.occurrences.set(i, m);
				return;
			}
		}
		DBMock.occurrences.add(m);
		DBMock.occurrences.add(m);
		
	}

	@Override
	public List<Occurrence> list() throws ModelException {
		return DBMock.occurrences;
	}

	@Override
	public void delete(Object id) throws ModelException {
		for (Occurrence u : DBMock.occurrences) {
			if(u.getId().equals(id)){
				DBMock.occurrences.remove(u);
				break;
			}
		}
		
	}

	@Override
	public boolean exist(Occurrence m) throws ModelException {
		for (Occurrence u : DBMock.occurrences) {
			if(u.getId().equals(m.getId())){
				return true;
			}
		}
		return false;
	}

	@Override
	public Occurrence prepare(ResultSet resultSet) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Occurrence> prepareAll(ResultSet resultSet) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

}
