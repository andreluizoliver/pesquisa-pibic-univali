package br.com.falasehhrio.server.mongodb;

import java.io.IOException;
import java.util.ResourceBundle;

public class PropertiesApplication {

	public static String getProperty(String prop) throws IOException {
		ResourceBundle bundle = ResourceBundle.getBundle("falasehhrio");
		Object propOut = bundle.getString(prop);
		return propOut.toString();
	}
}
