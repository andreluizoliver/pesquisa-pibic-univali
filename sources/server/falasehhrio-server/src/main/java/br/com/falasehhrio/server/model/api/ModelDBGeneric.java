package br.com.falasehhrio.server.model.api;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.falasehhrio.server.Connection;

public class ModelDBGeneric implements ModelDBGenericView {

	protected PreparedStatement preparedStatement;
	
	protected List<Object> params;

	public ModelDBGeneric() {
		super();
	}
	
	@Override
	public ResultSet executeQuery(QueryDB queryDB, List<Object> params) throws ModelException {

		try {
			prepareParams(queryDB, params);
			return preparedStatement.executeQuery();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			throw new ModelException(e);
		}

	}
	
	public ResultSet executeQuery(QueryDB queryDB) throws ModelException {
		return this.executeQuery(queryDB, new ArrayList<>());
	}

	public void executeUpdate(QueryDB queryDB, List<Object> params) throws ModelException {
		try {
			prepareParams(queryDB, params);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			throw new ModelException(e);
		}
	}

	private void prepareParams(QueryDB queryDB, List<Object> params)
			throws ClassNotFoundException, SQLException, IOException {

		preparedStatement = Connection.getConnection().prepareStatement(queryDB.sql);

		for (int i = 0; i < params.size(); i++) {
			if (params.get(i) instanceof Long) {
				preparedStatement.setLong(i+1, (Long) params.get(i));
			} else if (params.get(i) instanceof String) {
				preparedStatement.setString(i+1, (String) params.get(i));
			} else if (params.get(i) instanceof Boolean) {
				preparedStatement.setBoolean(i+1, (Boolean) params.get(i));
			} else {
				preparedStatement.setObject(i+1, (Boolean) params.get(i));
			}
		}
	}
}
