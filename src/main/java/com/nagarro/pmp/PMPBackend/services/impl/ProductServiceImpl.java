package com.nagarro.pmp.PMPBackend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.pmp.PMPBackend.dao.ProductDAO;
import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public void addProducts(ProductDTO productDTO) {
		 productDAO.addProducts(productDTO);
	}

	@Override
	public void editProducts(ProductDTO productDTO) {
		productDAO.editProducts(productDTO);
		
	}

}
