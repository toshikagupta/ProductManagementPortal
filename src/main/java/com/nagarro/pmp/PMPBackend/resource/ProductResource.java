package com.nagarro.pmp.PMPBackend.resource;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.dto.ProductDescDTO;
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
	 
	@GetMapping("/getallproducts")
	public List<ProductDTO> getAllProduct()
	{
		return productService.getAllProduct();
	}
	@GetMapping("/{id}")
	public ProductDTO getProductDetails(@PathVariable String id) {
		System.out.println(id);
		int intId= Integer.parseInt(id);
		return productService.getProductDetails(intId);
	}

}
