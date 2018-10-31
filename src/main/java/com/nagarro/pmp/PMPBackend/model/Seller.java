/**
 * 
 */
package com.nagarro.pmp.PMPBackend.model;

import java.sql.Timestamp;

/**
 * @author toshikagupta
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "seller")
@XmlRootElement
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SELLER_ID")
    int sellerId;
    @Column(name = "SELLER_NAME")
    String sellerName;
    @Column(name = "COMPANY_NAME")
    String companyName;
    @Column(name = "ADDRESS")
    String address;
    @Column(name = "EMAIL")
    String email;
    @Column(name = "GSTIN")
    String gstin;
    @Column(name = "PASSWORD")
    String password;
    @Column(name = "STATUS")
    String status;
    @Column(name = "REGISTRATION_TIME")
    Timestamp time;
    @Column(name="CONTACT_NUMBER")
    String contactNumber;

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(final int sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(final String sellerName) {
        this.sellerName = sellerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(final String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(final String gstin) {
        this.gstin = gstin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

}

