package br.com.falasehhrio.server.rest.api;

import br.com.falasehhrio.server.model.api.ModelDBView;

public class RestWServiceGeneric<M> implements RestWServiceGenericView {
	
	protected ModelDBView<M> db;
	
	public RestWServiceGeneric(ModelDBView<M> db) {
		super();
		this.db = db;
	}
	
	

}
