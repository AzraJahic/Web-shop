package com.product.model;

import java.io.Serializable;

public class ClientMessage implements Serializable{
	private String clientName;
	private String clientLastName;
	private String clientPhoneNumber;
	private String clientEmail;
	private String clientMsg;
	
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientLastName() {
		return clientLastName;
	}
	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}
	
	public String getClientPhoneNumber() {
		return clientPhoneNumber;
	}
	public void setClientPhoneNumber(String clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}
	public String getClientMsg() {
		return clientMsg;
	}
	public void setClientMsg(String clientMsg) {
		this.clientMsg = clientMsg;
	}

}
