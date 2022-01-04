package com.shopping.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admins")
public class Admin {
	
	
	@Id
	private String aId;
	private String aName;
	private String aEmail;
	private String aPassword;
	
	//non parameterised constructor
	public Admin() {
		
	}
	//parameterised constructor

	public Admin(String string, String aName, String aEmail, String aPassword) {
		super();
		this.aId = string;
		this.aName = aName;
		this.aEmail = aEmail;
		this.aPassword = aPassword;
	}

	//getters and setters
	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaEmail() {
		return aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}
	
	
	
}