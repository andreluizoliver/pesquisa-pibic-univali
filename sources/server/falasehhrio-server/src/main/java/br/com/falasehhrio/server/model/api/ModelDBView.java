package br.com.falasehhrio.server.model.api;

import java.sql.ResultSet;
import java.util.List;

public interface ModelDBView<M> extends ModelDBGenericView{
	
	M get(Object id) throws ModelException;
	
	void save(M m) throws ModelException;
	
	List<M> list() throws ModelException;
	
	void delete(Object id) throws ModelException;
	
	boolean exist(M m) throws ModelException;
	
	M prepare(ResultSet resultSet) throws ModelException;
	
	List<M> prepareAll(ResultSet resultSet) throws ModelException;
	
}
