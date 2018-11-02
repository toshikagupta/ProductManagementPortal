package com.nagarro.pmp.PMPBackend.services;

import java.util.List;

import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.dto.ProductDescDTO;

public interface ProductService {

	void addProducts(ProductDTO productDTO);

List<ProductDTO> getAllProduct();

List<ProductDTO> approveProducts(int[] productId);

void rejectProducts(int[] productId);
ProductDTO getProductDetails(int id);

List<ProductDTO> getSearchResult(String searchText, String param);

	

}
