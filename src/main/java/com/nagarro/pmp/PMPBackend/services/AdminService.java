package com.nagarro.pmp.PMPBackend.services;

import java.util.List;

import com.nagarro.pmp.PMPBackend.dto.LoginDTO;
import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;

public interface AdminService {

	LoginDTO validateCredentials(LoginDTO admin);

	List<SellerDTO> getSortedList(String sortparam);

	List<SellerDTO> getSearchResult(String searchparam, String classifier);

	List<SellerDTO> filterStatus(String status);

	List<ProductDTO> filterProduct(String string);

}