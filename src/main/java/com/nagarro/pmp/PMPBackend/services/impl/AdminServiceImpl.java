package com.nagarro.pmp.PMPBackend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.pmp.PMPBackend.dao.AdminDAO;
import com.nagarro.pmp.PMPBackend.dto.LoginDTO;
import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.services.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	
	
	
	@Autowired
	AdminDAO adminRepo;

	
	/* (non-Javadoc)
	 * @see com.nagarro.pmp.PMPBackend.services.impl.AdminService#login(com.nagarro.pmp.PMPBackend.dto.LoginDTO)
	 */
	@Override
	public LoginDTO validateCredentials(LoginDTO admin) {
		return adminRepo.validateCredentials(admin);
	}

	
	/* (non-Javadoc)
	 * @see com.nagarro.pmp.PMPBackend.services.impl.AdminService#getSortedList(java.lang.String)
	 */
	@Override
	public List<SellerDTO> getSortedList(String sortparam) {
		return adminRepo.sortList(sortparam);
	}
    
	
	/* (non-Javadoc)
	 * @see com.nagarro.pmp.PMPBackend.services.impl.AdminService#getSearchResult(java.lang.String, java.lang.String)
	 */
	@Override
	public List<SellerDTO> getSearchResult(String searchparam, String classifier) {
		return adminRepo.getSearchResult(searchparam, classifier);
	}

	/* (non-Javadoc)
	 * @see com.nagarro.pmp.PMPBackend.services.impl.AdminService#filterStatus(java.lang.String)
	 */
	@Override
	public List<SellerDTO> filterStatus(String status) {
		return adminRepo.filterbyStatus(status);
	}


	@Override
	public List<ProductDTO> filterProduct(String string) {
		return adminRepo.sortProductList(string);
	}

}
