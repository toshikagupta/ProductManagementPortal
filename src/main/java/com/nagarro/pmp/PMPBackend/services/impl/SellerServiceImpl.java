package com.nagarro.pmp.PMPBackend.services.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nagarro.pmp.PMPBackend.dao.SellerRegistrationDAO;
import com.nagarro.pmp.PMPBackend.dto.LoginDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.services.SellerService;

@Service
public class SellerServiceImpl implements SellerService {
	
	@Autowired
	private SellerRegistrationDAO sellerRegistrationDAO;
	
	/* (non-Javadoc)
	 * @see com.nagarro.pmp.PMPBackend.services.impl.SellerService#createNewSeller(com.nagarro.pmp.PMPBackend.dto.SellerDTO)
	 */
	@Override
	public ResponseEntity createNewSeller(SellerDTO sellerDTO) {
		sellerRegistrationDAO.createSeller(sellerDTO);
		final int id = sellerRegistrationDAO.getSellerIdByEmail(sellerDTO.getEmail());

		
		return ResponseEntity.status(201).body(id);

	}

		
	/* (non-Javadoc)
	 * @see com.nagarro.pmp.PMPBackend.services.impl.SellerService#loginSeller(com.nagarro.pmp.PMPBackend.dto.LoginDTO)
	 */
	@Override
	public ResponseEntity loginSeller(LoginDTO sellerLoginDTO) {
		final String status = sellerRegistrationDAO.login(sellerLoginDTO);
		return ResponseEntity.status(201).body(status);
	}


	@Override
	public List<SellerDTO> getAllSellers() {
		return sellerRegistrationDAO.getAllSellers();
	}


	@Override
	public List<SellerDTO> approveSellers(int[] sellerName) {
		return sellerRegistrationDAO.approveSellers(sellerName);
		
	}


	@Override
	public void rejectSellers(int[] sellerId) {
		sellerRegistrationDAO.rejectSellers(sellerId);
		
	}


	@Override
	public SellerDTO displaySellerById(int sellerId) {
		return sellerRegistrationDAO.displaysSellerById(sellerId);
	}


	@Override
	public int getTotalSellerCount() {
		return sellerRegistrationDAO.getTotalSellerCount();
	}


	@Override
	public List<SellerDTO> getSellerWithOffset(int i, int recordsPerPage) {
		
		return sellerRegistrationDAO.getSellerWithOffset(i,recordsPerPage);
	}
}
