package br.com.falasehhrio.server.model;

import java.sql.ResultSet;
import java.util.List;

import br.com.falasehhrio.server.model.api.DBMock;
import br.com.falasehhrio.server.model.api.ModelDBView;
import br.com.falasehhrio.server.model.api.ModelException;
import br.com.falasehhrio.server.model.api.QueryDB;

public class ImageMock implements ModelDBView<Image> {

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
	public Image get(Object id) throws ModelException {
		for (Image u : DBMock.images) {
			if(u.getHashImg().equals(id)){
				return u;
			}
		}
		return null;
	}

	@Override
	public void save(Image m) throws ModelException {
		DBMock.images.add(m);
		
	}

	@Override
	public List<Image> list() throws ModelException {
		return DBMock.images;
	}

	@Override
	public void delete(Object id) throws ModelException {
		for (Image u : DBMock.images) {
			if(u.getHashImg().equals(id)){
				DBMock.images.remove(u);
				break;
			}
		}
		
	}

	@Override
	public boolean exist(Image m) throws ModelException {
		for (Image u : DBMock.images) {
			if(u.getHashImg().equals(m.getHashImg())){
				return true;
			}
		}
		return false;
	}

	@Override
	public Image prepare(ResultSet resultSet) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> prepareAll(ResultSet resultSet) throws ModelException {
		// TODO Auto-generated method stub
		return null;
	}

}
