package com.nagarro.pmp.PMPBackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.services.ProductService;
import com.nagarro.pmp.PMPBackend.services.SellerService;

@Controller
public class HomeController {
	@Autowired
	SellerService sellerService;
	@Autowired
	ProductService productService;
	List<SellerDTO> seller;
	List<ProductDTO> product;
	@RequestMapping(value="/sellerdetails", method = RequestMethod.GET)
	public String displaySelle(ModelMap model)
	{	
		seller=sellerService.getAllSellers();
		 model.addAttribute("seller",seller);
		return "home";
		
		
	}
	@RequestMapping(value="/sellerdetails", method = RequestMethod.POST)
	public String displaySeller(ModelMap model)
	{	
		 seller=sellerService.getAllSellers();
		 model.addAttribute("seller",seller);
		return "home";
		
	}
	@RequestMapping(value="/productdetails", method = RequestMethod.GET)
	public String displayProduc(ModelMap model)
	{	
		product=productService.getAllProduct();
		 model.addAttribute("product",product);
		return "producthome";
		
	}
	@RequestMapping(value="/productdetails", method = RequestMethod.POST)
	public String displayProduct(ModelMap model)
	{	
		 product=productService.getAllProduct();
		 model.addAttribute("product",product);
		return "producthome";
		
	}
}
