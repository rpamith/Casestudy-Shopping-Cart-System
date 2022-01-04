package com.shopping.models;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class Product {
	
	@Id
	private int pId;
	private String pName;
	private String pType;
	private String pCategory;
	private String pPrice;
	private String pDescription;
	private Binary pImg;
	
	public Product(int pId, String pName, String pType, String pCategory, String pPrice, String pDescription,
			Binary pImg) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pType = pType;
		this.pCategory = pCategory;
		this.pPrice = pPrice;
		this.pDescription = pDescription;
		this.pImg = pImg;
	}

	public Product() {
		
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpPrice() {
		return pPrice;
	}

	public void setpPrice(String pPrice) {
		this.pPrice = pPrice;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public Binary getpImg() {
		return pImg;
	}

	public void setpImg(Binary pImg) {
		this.pImg = pImg;
	}
	
	
}
