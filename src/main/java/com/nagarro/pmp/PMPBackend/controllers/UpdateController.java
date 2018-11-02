package com.nagarro.pmp.PMPBackend.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.services.ProductService;
import com.nagarro.pmp.PMPBackend.services.SellerService;

@Controller
public class UpdateController {
	
  
	@Autowired
	SellerService sellerService;
	
	@Autowired
	ProductService productService;
	
	List<SellerDTO> seller;
	List<ProductDTO> product;
	
	@RequestMapping(value="/approve", method = RequestMethod.POST)
	public String approveSellers(ModelMap model,HttpServletRequest request)
	{	
		String[] sellerIdString = request.getParameterValues("selectSeller");
	
		int[] sellerId=new int[sellerIdString.length];
		for(int i=0;i<sellerIdString.length;i++)
			sellerId[i]=Integer.parseInt(sellerIdString[i]);
		seller = sellerService.approveSellers(sellerId);
		 model.addAttribute("seller",seller);
		return "home";
		
	}
	@RequestMapping(value="/reject", method = RequestMethod.POST)
	public String rejectSellers(ModelMap model,HttpServletRequest request)
	{	
		String[] sellerIdString = request.getParameterValues("selectSeller");
	
		int[] sellerId=new int[sellerIdString.length];
		for(int i=0;i<sellerIdString.length;i++)
			sellerId[i]=Integer.parseInt(sellerIdString[i]);
		sellerService.rejectSellers(sellerId);
		return "redirect:/sellerdetails";
		
	}
	@RequestMapping(value="/approveproducts", method = RequestMethod.POST)
	public String approveProducts(ModelMap model,HttpServletRequest request)
	{	
		String[] productIdString = request.getParameterValues("selectProduct");
	
		int[] productId=new int[productIdString.length];
		for(int i=0;i<productIdString.length;i++)
			productId[i]=Integer.parseInt(productIdString[i]);
		product = productService.approveProducts(productId);
		 model.addAttribute("product",product);
		return "producthome";
		
	}
	@RequestMapping(value="/rejectproducts", method = RequestMethod.POST)
	public String rejectProductss(ModelMap model,HttpServletRequest request)
	{	
		String[] productIdString = request.getParameterValues("selectProduct");
	
		int[] productId=new int[productIdString.length];
		for(int i=0;i<productIdString.length;i++)
			productId[i]=Integer.parseInt(productIdString[i]);
		productService.rejectProducts(productId);
		return "redirect:/productdetails";
		
	}
	


}
