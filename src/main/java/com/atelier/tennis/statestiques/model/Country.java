package com.atelier.tennis.statestiques.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
	 private String picture;
	  private String code;
	  
	  
	public Country(String picture, String code) {
		super();
		this.picture = picture;
		this.code = code;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	   public Country() {
	    }
}
