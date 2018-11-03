package com.nagarro.pmp.PMPBackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.pmp.PMPBackend.dto.CategoryDTO;
import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.services.ProductService;
import com.nagarro.pmp.PMPBackend.services.SellerService;

@Controller
public class DisplayController {
	
	@Autowired
	SellerService sellerService;
	@Autowired
    ProductService productService;
	
	@RequestMapping(value="/sellers/{id}", method=RequestMethod.GET )
	public String displaySeller(ModelMap model, @PathVariable("id") String sellerId)
	{
		int id=Integer.parseInt(sellerId);
		SellerDTO seller=sellerService.displaySellerById(id);
		
		model.addAttribute("sellerdetail", seller);
		return "sellerdetails";
	}
	@RequestMapping(value="/products/{id}", method=RequestMethod.GET )
	public String displayProduct(ModelMap model, @PathVariable("id") String productId)
	{
		int id=Integer.parseInt(productId);
		ProductDTO product=productService.displayProductById(id);
		
		model.addAttribute("productdetail", product);
		model.addAttribute("secondaryimages",product.getImagesUrl());
		return "productdetails";
	}
	@RequestMapping(value="/displayCategory", method=RequestMethod.GET)
	public String displayAllCategories(ModelMap model)
	{
		List<CategoryDTO> categoryList=productService.displayCategories();
		model.addAttribute("categories",categoryList);
		return "categories";
	}

}
