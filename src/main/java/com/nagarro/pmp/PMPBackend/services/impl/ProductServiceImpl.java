package com.nagarro.pmp.PMPBackend.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.pmp.PMPBackend.dao.ProductDAO;
import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.dto.ProductDescDTO;
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
	public List<ProductDTO> getAllProduct() {
		
		return productDAO.getAllProduct();
	}

	@Override
	public List<ProductDTO> approveProducts(int[] productId) {
		return productDAO.approveProducts(productId);
		
	}

	@Override
	public void rejectProducts(int[] productId) {
		 productDAO.rejectProducts(productId);
		
	}

	@Override
	public ProductDTO getProductDetails(int id) {
		return productDAO.getProductDetails(id);
	}

	@Override
	public List<ProductDTO> getSearchResult(String searchText, String param) {
		return productDAO.getSearchResult(searchText,param);
	}
   
	

}
