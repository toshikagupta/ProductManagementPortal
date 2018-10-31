package com.nagarro.pmp.PMPBackend.dao;

import com.nagarro.pmp.PMPBackend.dto.ProductDTO;

public interface ProductDAO {

	void addProducts(ProductDTO productDTO);

	void editProducts(ProductDTO productDTO);

	void updateProduct(ProductDTO productDTO);

	ProductDTO getAllProducts(int code);

}
