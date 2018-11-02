package com.nagarro.pmp.PMPBackend.dto;

import java.util.List;

import com.nagarro.pmp.PMPBackend.model.Categories;



public class ProductDTO {

	int productId;
	int sellerId;
	String productName;
	String shortDesc;
	String longDesc;
	float mrp;
	float ssp;
	float ymp;
	String primaryImage;
	String status;
	String comments;
	String dimensions;
	List<String> categories;
	List<String> imagesUrl;
	String pdfUrl;
	

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public float getMrp() {
		return mrp;
	}
	public void setMrp(float mrp) {
		this.mrp = mrp;
	}
	public float getSsp() {
		return ssp;
	}
	public void setSsp(float ssp) {
		this.ssp = ssp;
	}
	public float getYmp() {
		return ymp;
	}
	public void setYmp(float ymp) {
		this.ymp = ymp;
	}
	public String getPrimaryImage() {
		return primaryImage;
	}
	public void setPrimaryImage(String primaryImage) {
		this.primaryImage = primaryImage;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public List<String> getImagesUrl() {
		return imagesUrl;
	}
	public void setImagesUrl(List<String> imagesUrl) {
		this.imagesUrl = imagesUrl;
	}
	public String getPdfUrl() {
		return pdfUrl;
	}
	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}
	public String getDimensions() {
		return dimensions;
	}
	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
	
	
}
