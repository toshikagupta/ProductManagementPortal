package com.nagarro.pmp.PMPBackend.dao;

import java.util.List;

import com.nagarro.pmp.PMPBackend.dto.CategoryDTO;
import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.dto.ProductDescDTO;

public interface ProductDAO {

	void addProducts(ProductDTO productDTO);

	void updateProduct(ProductDTO productDTO);

	ProductDTO getProductDetails(int code);

	List<ProductDTO> getAllProduct();

	List<ProductDTO> approveProducts(int[] productId);

	void rejectProducts(int[] productId);

	List<ProductDTO> getSearchResult(String searchText, String param);

	List<ProductDTO> filterProducts(String searchText, String fparam);

	int getProductCount();

	List<ProductDTO> getProductWithOffset(int i, int recordsPerPage);

	List<CategoryDTO> displayCategories();

}
