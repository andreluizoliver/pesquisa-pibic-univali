package br.com.falasehhrio.server.model.api;

import java.util.List;

public interface Model {
	
	List<Object> toArray();
	
	List<Object> toArrayWithoutId();
	
	List<Object> toArrayIdLast();

}
