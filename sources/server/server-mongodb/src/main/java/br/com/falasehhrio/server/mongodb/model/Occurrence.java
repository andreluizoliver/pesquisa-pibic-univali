package br.com.falasehhrio.server.mongodb.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Occurrence {
	
	@Id
	private String id;
	
	private String descOpen;
	private String idUserOpen;
	private String localization;
	private String descConclusion;
	private String idUserConclusion;
	private List<String> images;
	
	public Occurrence() { }	
	
	public Occurrence(String id, String descOpen, String idUserOpen, String localization, String descConclusion,
			String idUserConclusion, List<String> images) {
		super();
		this.id = id;
		this.descOpen = descOpen;
		this.idUserOpen = idUserOpen;
		this.localization = localization;
		this.descConclusion = descConclusion;
		this.idUserConclusion = idUserConclusion;
		this.images = images;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescOpen() {
		return descOpen;
	}

	public void setDescOpen(String descOpen) {
		this.descOpen = descOpen;
	}

	public String getIdUserOpen() {
		return idUserOpen;
	}

	public void setIdUserOpen(String idUserOpen) {
		this.idUserOpen = idUserOpen;
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

	public String getIdUserConclusion() {
		return idUserConclusion;
	}

	public void setIdUserConclusion(String idUserConclusion) {
		this.idUserConclusion = idUserConclusion;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Occurrence [id=" + id + ", descOpen=" + descOpen + ", idUserOpen=" + idUserOpen + ", localization="
				+ localization + ", descConclusion=" + descConclusion + ", idUserConclusion=" + idUserConclusion
				+ ", images=" + images + "]";
	}
	
}
