package br.com.falasehhrio.server.mongodb.model;

import org.springframework.data.annotation.Id;

public class User{
	
	@Id
    private String id;
	
	private String email;
	private String password;
	private String openid;
	private boolean admin;
	private boolean authority;
	
	public User() {}
	
	public User(String id, String email, String password, String openid, boolean admin, boolean authority) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.openid = openid;
		this.admin = admin;
		this.authority = authority;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isAuthority() {
		return authority;
	}
	public void setAuthority(boolean authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", openid=" + openid + ", admin="
				+ admin + ", authority=" + authority + "]";
	}
	
}
