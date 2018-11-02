package com.nagarro.pmp.PMPBackend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nagarro.pmp.PMPBackend.dto.LoginDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;

@Repository
public interface SellerRegistrationDAO {

	SellerDTO createSeller(SellerDTO sellerDTO);

	String login(LoginDTO sellerLogin);

	int getSellerIdByEmail(String email);
	
	List<SellerDTO> getAllSellers();

	List<SellerDTO> approveSellers(int[] sellerName);

	void rejectSellers(int[] sellerIdList);

	SellerDTO displaysSellerById(int sellerId);


}