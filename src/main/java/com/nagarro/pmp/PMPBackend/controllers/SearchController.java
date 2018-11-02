package com.nagarro.pmp.PMPBackend.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.services.AdminService;

@Controller
public class SearchController {
	@Autowired
	AdminService adminService;
	
	List<SellerDTO> seller;
	
	/*@RequestMapping(value="/searchseller", method=RequestMethod.POST)
	public String filterById(HttpServletRequest request,ModelMap model)
	{
		String param = request.getParameter("searchs");
		String searchText = request.getParameter("searchText");
		if(param.equals("status")) {
			seller = adminService.filterStatus(searchText);
			model.addAttribute("seller", seller);
			return "home";
		}
		else {
			seller = adminService.getSearchResult(searchText, param);
			model.addAttribute("seller", seller);
			return "home";
		}
		
		
		
	}*/
	@RequestMapping(value="/searchseller", method=RequestMethod.POST)
	public String filterProductById(HttpServletRequest request,ModelMap model)
	{
		String param = request.getParameter("searchs");
		String searchText = request.getParameter("searchText");
		if(param.equals("status")) {
			seller = adminService.filterStatus(searchText);
			model.addAttribute("seller", seller);
			return "home";
		}
		else {
			seller = adminService.getSearchResult(searchText, param);
			model.addAttribute("seller", seller);
			return "home";
		}
		
		
		
	}
}
