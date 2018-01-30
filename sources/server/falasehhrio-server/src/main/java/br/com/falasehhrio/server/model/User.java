package br.com.falasehhrio.server.model;

import java.util.ArrayList;
import java.util.List;

import br.com.falasehhrio.server.model.api.Model;

public class User implements Model {
	
	private int id;
	private String email;
	private String password;
	private String openid;
	private boolean admin;
	private boolean authority;
	
	public User() {
		super();
	}
	
	public User(int id) {
		super();
		this.id = id;
	}
	
	public User(String email, String password, String openid, boolean admin, boolean authority) {
		super();
		this.email = email;
		this.password = password;
		this.openid = openid;
		this.admin = admin;
		this.authority = authority;
	}

	public User(int id, String email, String password, String openid, boolean admin, boolean authority) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.openid = openid;
		this.admin = admin;
		this.authority = authority;
	}
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public boolean getAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean getAuthority() {
		return authority;
	}
	public void setAuthority(boolean authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "User {\"id\":\"" + id + "\", email\":\"" + email + "\", password\":\"" + password + "\", openid\":\""
				+ openid + "\", admin\":\"" + admin + "\", authority\":\"" + authority + "}";
	}

	@Override
	public List<Object> toArray() {
		List<Object> list = new ArrayList<>();
		list.add(this.email);
		list.add(this.password);
		list.add(this.openid);
		list.add(this.admin);
		list.add(this.authority);
		return list;
	}

	@Override
	public List<Object> toArrayWithoutId() {
		List<Object> list = new ArrayList<>();
		list.add(this.email);
		list.add(this.password);
		list.add(this.openid);
		list.add(this.admin);
		list.add(this.authority);
		return list;
	}

	@Override
	public List<Object> toArrayIdLast() {
		List<Object> list = new ArrayList<>();
		list.add(this.email);
		list.add(this.password);
		list.add(this.openid);
		list.add(this.admin);
		list.add(this.authority);
		list.add(this.id);
		return list;
	}

	public boolean equalsForLogin(User obj) {
		if(email.equals(obj.getEmail()) && password.equals(obj.getPassword())){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
