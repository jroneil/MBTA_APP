package com.oneil.model;

public class Data {
	private String type;
	private String id;
	private Attributes attributes;
	private RelationShips relationShips;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Attributes getAttributes() {
		return attributes;
	}
	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
	public RelationShips getRelationShips() {
		return relationShips;
	}
	public void setRelationShips(RelationShips relationShips) {
		this.relationShips = relationShips;
	}

}
