package br.com.falasehhrio.server.model.api;

import java.sql.ResultSet;
import java.util.List;

public interface ModelDBGenericView{

	ResultSet executeQuery(QueryDB queryDB, List<Object> params) throws ModelException;

	ResultSet executeQuery(QueryDB queryDB) throws ModelException;

	void executeUpdate(QueryDB queryDB, List<Object> params) throws ModelException;
	
}
