package br.com.falasehhrio.server.rest.api;

import java.util.List;

public interface RestWService<R> {
	
	R get(Long id);
	
	void save(R m);
	
	List<R> list();
	
	void delete(Object id);
	
	boolean exist(R m);
	
}
