package com.nagarro.pmp.PMPBackend.model;

import javax.persistence.Column;
import javax.persistence.Id;

public class SellerLogin {
	
	@Id
	@Column(name = "SELLER_ID")
	int sellerId;
	@Column(name = "Password")
	String password;

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(final int sellerId) {
		this.sellerId = sellerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

}
