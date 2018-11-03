package com.nagarro.pmp.PMPBackend.model;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_details")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	int productId;

	@Column(name = "SELLER_ID")
	int sellerId;
	@Column(name = "PRODUCT_NAME")
	String productName;
	@Column(name = "SHORT_DESC")
	String shortDesc;
	@Column(name = "LONG_DESC")
	String longDesc;
	@Column(name = "MRP")
	float mrp;
	@Column(name = "SSP")
	float ssp;
	@Column(name = "YMP")
	float ymp;
	@Column(name = "PRIMARY_IMAGE")
	String primaryImage;
	@Column(name = "STATUS")
	String status;
	@Column(name = "COMMENTS")
	String comments;
	@Column(name="DIMENSIONS")
	String dimensions;
	@Column(name="REGISTRATION_TIME")
	Timestamp time;
	
	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	@OneToMany(mappedBy="product", cascade= {CascadeType.ALL})
	Set<SecondaryImages> secondaryImages=new HashSet<>();
	
	@ManyToMany(cascade= {CascadeType.ALL})
	@JoinTable(
			name="product_category",
			joinColumns= { @JoinColumn(name= "PRODUCT_ID",  nullable=false) },
			inverseJoinColumns= { @JoinColumn(name="CATEGORY_ID" , nullable=false)}
			)
	 Set<Categories> categories;
	
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(final int productId) {
		this.productId = productId;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(final int sellerId) {
		this.sellerId = sellerId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(final String productName) {
		this.productName = productName;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(final String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getLongDesc() {
		return longDesc;
	}

	public void setLongDesc(final String longDesc) {
		this.longDesc = longDesc;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(final float mrp) {
		this.mrp = mrp;
	}

	public float getSsp() {
		return ssp;
	}

	public void setSsp(final float ssp) {
		this.ssp = ssp;
	}

	public float getYmp() {
		return ymp;
	}

	public void setYmp(final float ymp) {
		this.ymp = ymp;
	}

	public String getPrimaryImage() {
		return primaryImage;
	}

	public void setPrimaryImage(final String primaryImage) {
		this.primaryImage = primaryImage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(final String comments) {
		this.comments = comments;
	}

	public Set<Categories> getCategories() {
		return categories;
	}

	public void setCategories(final Set<Categories> categories) {
		this.categories = categories;
	}

	public Set<SecondaryImages> getSecondaryImages() {
		return secondaryImages;
	}

	public void setSecondaryImages(Set<SecondaryImages> secondaryImages) {
		// this.secondaryImages.clear();
		this.secondaryImages=secondaryImages;
	}
}
