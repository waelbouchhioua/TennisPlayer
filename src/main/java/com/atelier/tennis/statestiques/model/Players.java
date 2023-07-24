package com.atelier.tennis.statestiques.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;




@JsonIgnoreProperties(ignoreUnknown = true)
public class Players {
	
 private Long id;	
@JsonProperty("firstname")
 private String firstName;
@JsonProperty("lastname")
 private String lastName;
@JsonProperty("shortname")
 private String shortName;
 private String sex;
 
 public Long getId() {
	return id;
}

public Players(Long id, String firstName, String lastName, String shortName, String sex, Country country,
		String picture, PlayerData data) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.shortName = shortName;
	this.sex = sex;
	this.country = country;
	this.picture = picture;
	this.data = data;
}

public void setId(Long id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getShortName() {
	return shortName;
}

public void setShortName(String shortName) {
	this.shortName = shortName;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public Country getCountry() {
	return country;
}

public void setCountry(Country country) {
	this.country = country;
}

public String getPicture() {
	return picture;
}

public void setPicture(String picture) {
	this.picture = picture;
}

public PlayerData getData() {
	return data;
}

public void setData(PlayerData data) {
	this.data = data;
}

private Country  country;
 private String picture;

 private PlayerData data;
 public Players() {
 }

}
