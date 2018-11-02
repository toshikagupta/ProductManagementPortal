package com.nagarro.pmp.PMPBackend.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.pmp.PMPBackend.dto.LoginDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;



public interface SellerService {

	ResponseEntity createNewSeller(SellerDTO sellerDTO);

	ResponseEntity loginSeller(LoginDTO sellerLoginDTO);

	List<SellerDTO> getAllSellers();

	List<SellerDTO> approveSellers(int[] sellerName);

	void rejectSellers(int[] sellerId);

	SellerDTO displaysSellerById(int sellerId);

}