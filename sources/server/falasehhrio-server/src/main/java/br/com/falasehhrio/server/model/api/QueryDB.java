package br.com.falasehhrio.server.model.api;

public enum QueryDB {
	
	USER_INSERT("INSERT INTO falasehhrio.user (email,password,openid,admin,authority) VALUES (?,?,?,?,?)"),
	USER_UPDATE("UPDATE falasehhrio.user SET email = ?, password = ?, openid = ?, admin = ?, authority = ? WHERE id = ?"),
	USER_SELECT_ALL("SELECT * FROM falasehhrio.user"),
	USER_SELECT("SELECT * FROM falasehhrio.user WHERE id = ?"),
	USER_DELETE("DELETE FROM falasehhrio.user WHERE id = ?"),
	USER_EXIST("SELECT COUNT(*) FROM falasehhrio.user WHERE id = ?"),
	
	OCCURRENCE_INSERT("INSERT INTO falasehhrio.occurrence (email,password,openid,admin,authority) VALUES (?,?,?,?,?)"),
	OCCURRENCE_UPDATE("UPDATE falasehhrio.occurrence SET email = ?, password = ?, openid = ?, admin = ?, authority = ? WHERE id = ?"),
	OCCURRENCE_SELECT_ALL("SELECT * FROM falasehhrio.occurrence"),
	OCCURRENCE_SELECT("SELECT * FROM falasehhrio.occurrence WHERE id = ?"),
	OCCURRENCE_DELETE("DELETE FROM falasehhrio.occurrence WHERE id = ?"),
	OCCURRENCE_EXIST("SELECT COUNT(*) FROM falasehhrio.occurrence WHERE id = ?"),
	
	IMAGE_INSERT("INSERT INTO falasehhrio.image (email,password,openid,admin,authority) VALUES (?,?,?,?,?)"),
	IMAGE_UPDATE("UPDATE falasehhrio.image SET email = ?, password = ?, openid = ?, admin = ?, authority = ? WHERE id = ?"),
	IMAGE_SELECT_ALL("SELECT * FROM falasehhrio.image"),
	IMAGE_SELECT("SELECT * FROM falasehhrio.image WHERE id = ?"),
	IMAGE_DELETE("DELETE FROM falasehhrio.image WHERE id = ?"),
	IMAGE_EXIST("SELECT COUNT(*) FROM falasehhrio.image WHERE id = ?"),
	;
	
	public String sql;

	private QueryDB(String sql) {
		this.sql = sql;
	}
	
	

}
