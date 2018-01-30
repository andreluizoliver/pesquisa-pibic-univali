package br.com.falasehhrio.server.model;

import java.util.ArrayList;
import java.util.List;

import br.com.falasehhrio.server.model.api.Model;

public class Image implements Model{
	
	private Occurrence occurrence;
	private String hashImg;
	
	public Image(String hashImg) {
		super();
		this.hashImg = hashImg;
	}
	
	public Image(Occurrence occurrence, String hashImg) {
		super();
		this.occurrence = occurrence;
		this.hashImg = hashImg;
	}
	public Image() {
		super();
	}
	public Occurrence getOccurrence() {
		return occurrence;
	}
	public void setOccurrence(Occurrence occurrence) {
		this.occurrence = occurrence;
	}
	public String getHashImg() {
		return hashImg;
	}
	public void setHashImg(String hashImg) {
		this.hashImg = hashImg;
	}
	
	@Override
	public String toString() {
		return "Image {\"occurrence\":\"" + occurrence + "\", hashImg\":\"" + hashImg + "}";
	}
	@Override
	public List<Object> toArray() {
		List<Object> list = new ArrayList<>();
		list.add(occurrence.getId());
		list.add(hashImg);
		return list;
	}
	@Override
	public List<Object> toArrayWithoutId() {
		List<Object> list = new ArrayList<>();
		list.add(occurrence.getId());
		list.add(hashImg);
		return list;
	}
	@Override
	public List<Object> toArrayIdLast() {
		List<Object> list = new ArrayList<>();
		list.add(occurrence.getId());
		list.add(hashImg);
		return list;
	}
}
