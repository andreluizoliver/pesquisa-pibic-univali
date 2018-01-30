package br.com.falasehhrio.server.model;

import java.util.ArrayList;
import java.util.List;

import br.com.falasehhrio.server.model.api.Model;

public class Occurrence implements Model {
	
	private Long id;
	private String descOpen;
	private User userOpen;
	private String localization;
	private String descConclusion;
	private User userConclusion;
	
	public Occurrence() {
		super();
	}
	
	public Occurrence(Long id) {
		super();
		this.id = id;
	}

	public Occurrence(Long id, String descOpen, User userOpen, String localization, String descConclusion,
			User userConclusion) {
		super();
		this.id = id;
		this.descOpen = descOpen;
		this.userOpen = userOpen;
		this.localization = localization;
		this.descConclusion = descConclusion;
		this.userConclusion = userConclusion;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescOpen() {
		return descOpen;
	}
	public void setDescOpen(String descOpen) {
		this.descOpen = descOpen;
	}
	public User getUserOpen() {
		return userOpen;
	}
	public void setUserOpen(User userOpen) {
		this.userOpen = userOpen;
	}
	public String getLocalization() {
		return localization;
	}
	public void setLocalization(String localization) {
		this.localization = localization;
	}
	public String getDescConclusion() {
		return descConclusion;
	}
	public void setDescConclusion(String descConclusion) {
		this.descConclusion = descConclusion;
	}
	public User getUserConclusion() {
		return userConclusion;
	}
	public void setUserConclusion(User userConclusion) {
		this.userConclusion = userConclusion;
	}
	
	@Override
	public String toString() {
		return "Occurrence {\"id\":\"" + id + "\", descOpen\":\"" + descOpen + "\", userOpen\":\"" + userOpen.toString()
				+ "\", localization\":\"" + localization + "\", descConclusion\":\"" + descConclusion
				+ "\", userConclusion\":\"" + userConclusion + "}";
	}

	@Override
	public List<Object> toArray() {
		List<Object> list = new ArrayList<>();
		list.add(id);
		list.add(descOpen);
		list.add(userOpen.getId());
		list.add(localization);
		list.add(descConclusion);
		list.add(userConclusion.getId());
		return list;
	}

	@Override
	public List<Object> toArrayWithoutId() {
		List<Object> list = new ArrayList<>();
		list.add(descOpen);
		list.add(userOpen.getId());
		list.add(localization);
		list.add(descConclusion);
		list.add(userConclusion.getId());
		return list;
	}

	@Override
	public List<Object> toArrayIdLast() {
		List<Object> list = new ArrayList<>();
		list.add(descOpen);
		list.add(userOpen.getId());
		list.add(localization);
		list.add(descConclusion);
		list.add(userConclusion.getId());
		list.add(id);
		return list;
	}
	
}
