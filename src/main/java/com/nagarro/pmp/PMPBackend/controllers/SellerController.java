package com.nagarro.pmp.PMPBackend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.services.SellerService;

@Controller
public class SellerController {
	
	@Autowired
	SellerService sellerService;
	
	@RequestMapping(value="/sellers/{id}", method=RequestMethod.GET )
	public String displaySeller(ModelMap model, @PathVariable("id") String sellerId)
	{
		int id=Integer.parseInt(sellerId);
		SellerDTO seller=sellerService.displaysSellerById(id);
		
		model.addAttribute("sellerdetail", seller);
		return "seller";
	}

}
