package com.mywork.pp.order.system.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Pramod Patwa
 * Enum will be used to defined item measure unit.
 */
public enum UnitType {

	@JsonProperty("litre")
	LITRE("litre"),

	@JsonProperty("kg")
	KG("kg");

	private String name;

	private UnitType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
