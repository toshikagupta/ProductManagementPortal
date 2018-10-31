package com.nagarro.pmp.PMPBackend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table(name = "pdf_manual")
public class PdfManual {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANUAL_ID")
    private int manualId;
    @Column(name = "MANUAL_URL")
    private String manualUrl;
    
    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUCT_ID")
    Product product;
    
   

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getManualId() {
		return manualId;
	}

	public void setManualId(int manualId) {
		this.manualId = manualId;
	}

	public String getManualUrl() {
		return manualUrl;
	}

	public void setManualUrl(String manualUrl) {
		this.manualUrl = manualUrl;
	}

	

}