package com.nagarro.pmp.PMPBackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.services.AdminService;

@Controller
public class FilterController {
	@Autowired
	AdminService adminService;
	
	List<ProductDTO> productList;
	
	List<SellerDTO> seller;
	@RequestMapping(value="/sellerId", method=RequestMethod.GET)
	public String filterById(ModelMap model)
	{
		seller = adminService.getSortedList("SellerId");
		model.addAttribute("seller",seller);
		return "home";
		
	}
	@RequestMapping(value="/regTime", method=RequestMethod.GET)
	public String filterByTime(ModelMap model)
	{
		seller = adminService.getSortedList("Registration time");
		model.addAttribute("seller",seller);
		return "home";
	}
	@RequestMapping(value="/mrp" , method=RequestMethod.GET)
	public String filterProductsByMrp(ModelMap model)
	{
		productList=adminService.filterProduct("MRP");
		model.addAttribute("product", productList);
		return "producthome";
	}
	@RequestMapping(value="/ssp" , method=RequestMethod.GET)
	public String filterProductsBySsp(ModelMap model)
	{
		productList=adminService.filterProduct("SSP");
		model.addAttribute("product", productList);
		return "producthome";
	}
	@RequestMapping(value="/ymp" , method=RequestMethod.GET)
	public String filterProductsByYmp(ModelMap model)
	{
		productList=adminService.filterProduct("YMP");
		model.addAttribute("product", productList);
		return "producthome";
	}
	@RequestMapping(value="/time" , method=RequestMethod.GET)
	public String filterProductsByTime(ModelMap model)
	{
		productList=adminService.filterProduct("TIME");
		model.addAttribute("product", productList);
		return "producthome";
	}
	

}
