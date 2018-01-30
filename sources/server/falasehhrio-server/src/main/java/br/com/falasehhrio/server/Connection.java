package br.com.falasehhrio.server;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

	public static java.sql.Connection dbConnection = null;

	public static java.sql.Connection getConnection() throws IOException, ClassNotFoundException, SQLException {

		String DB_URL = PropertiesApplication.getProperty("dataSource.url");
		String DB_DRIVER = PropertiesApplication.getProperty("dataSource.driverClassName");
		String DB_USER = PropertiesApplication.getProperty("dataSource.username");
		String DB_PASSWORD = PropertiesApplication.getProperty("dataSource.password");
		String DB_SCHEMA = PropertiesApplication.getProperty("dataSource.schema");

		if (dbConnection != null) {
			return dbConnection;
		} else {
			Class.forName(DB_DRIVER);
			dbConnection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			dbConnection.setSchema(DB_SCHEMA);
			return dbConnection;
		}

	}

}
