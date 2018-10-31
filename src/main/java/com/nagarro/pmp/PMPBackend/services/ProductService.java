package com.nagarro.pmp.PMPBackend.services;

import com.nagarro.pmp.PMPBackend.dto.ProductDTO;

public interface ProductService {

	void addProducts(ProductDTO productDTO);

	void editProducts(ProductDTO productDTO);

}
