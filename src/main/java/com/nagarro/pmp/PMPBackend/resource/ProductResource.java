package com.nagarro.pmp.PMPBackend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.services.ProductService;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping(value="/product")
public class ProductResource {
	@Autowired
	ProductService productService;
	
	@PostMapping("/add")
	public void addProducts(@RequestBody ProductDTO productDTO)
	{	productService.addProducts(productDTO);
		
	}
	
	@PutMapping("/edit")
	public void editProducts(@RequestBody ProductDTO productDTO)
	{
		productService.editProducts(productDTO);
	}

}
