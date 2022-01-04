package com.shopping.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

public class OrderModel {
	
	@Id
	private String orderID;
	private String orderDate;
	private String userID;
	private String amountPaid;
	private String modeOfPayment;
	private String orderStatus;
	private String quantity;
	
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public OrderModel(String string, String string2, String string3, String string4, String modeOfPayment,
			String orderStatus, String string5) {
		super();
		this.orderID = string;
		this.orderDate = string2;
		this.userID = string3;
		this.amountPaid = string4;
		this.modeOfPayment = modeOfPayment;
		this.orderStatus = orderStatus;
		this.quantity = string5;
	}
	
	

}