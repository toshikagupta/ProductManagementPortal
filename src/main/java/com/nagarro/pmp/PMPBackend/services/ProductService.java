package com.nagarro.pmp.PMPBackend.services;

import java.util.List;

import com.nagarro.pmp.PMPBackend.dto.CategoryDTO;
import com.nagarro.pmp.PMPBackend.dto.ProductDTO;

public interface ProductService {

	void addProducts(ProductDTO productDTO);

List<ProductDTO> getAllProduct();

List<ProductDTO> approveProducts(int[] productId);

void rejectProducts(int[] productId);
ProductDTO getProductDetails(int id);

List<ProductDTO> getSearchResult(String searchText, String param);

List<ProductDTO> filterProducts(String searchText, String fparam);

ProductDTO displayProductById(int id);

int getTotalProductCount();

List<ProductDTO> getProductWithOffset(int i, int recordsPerPage);

	List<CategoryDTO> displayCategories();

	

}
