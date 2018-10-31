package com.nagarro.pmp.PMPBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "secondary_image")
public class SecondaryImages {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SIMAGE_ID")
	int simageId;

	@Column(name = "SIMAGE_URL")
	String simageUrl;
	
	@ManyToOne
	@JoinColumn(name="PRODUCT_ID", nullable=false)
	Product product;
	
	public int getSimageId() {
		return simageId;
	}
	
	public void setSimageId(int simageId) {
		this.simageId = simageId;
	}
	public String getSimageUrl() {
		return simageUrl;
	}
	public void setSimageUrl(String simageUrl) {
		this.simageUrl = simageUrl;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	

}
