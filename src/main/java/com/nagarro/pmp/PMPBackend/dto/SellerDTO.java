package com.nagarro.pmp.PMPBackend.dto;
import java.sql.Timestamp;

public class SellerDTO {
	    int sellerId;
	    String sellerName;
	    String companyName;
	    String address;
	    String email;
	    String gstin;
	    String password;
	    String status;
	    Timestamp time;
	    String contactNumber;

	    public int getSellerId() {
			return sellerId;
		}
		public void setSellerId(int sellerId) {
			this.sellerId = sellerId;
		}
		public String getSellerName() {
			return sellerName;
		}
		public void setSellerName(String sellerName) {
			this.sellerName = sellerName;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGstin() {
			return gstin;
		}
		public void setGstin(String gstin) {
			this.gstin = gstin;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Timestamp getTime() {
			return time;
		}
		public void setTime(Timestamp time) {
			this.time = time;
		}
		public String getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}
		
}
