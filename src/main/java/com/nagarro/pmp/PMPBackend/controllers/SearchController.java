package com.nagarro.pmp.PMPBackend.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.pmp.PMPBackend.dto.ProductDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.services.AdminService;
import com.nagarro.pmp.PMPBackend.services.ProductService;

@Controller
public class SearchController {
	@Autowired
	AdminService adminService;
	@Autowired
	ProductService productService;

	List<ProductDTO> product;
	List<SellerDTO> seller;

	@RequestMapping(value = "/searchseller", method = RequestMethod.POST)
	public String searchById(HttpServletRequest request, ModelMap model) {
		String param = request.getParameter("searchs");
		String searchText = request.getParameter("searchText");
		if (param.equals("status")) {
			seller = adminService.filterStatus(searchText);
		} else {
			seller = adminService.getSearchResult(searchText, param);
		}
		model.addAttribute("seller", seller);
		return "home";
	}

	@RequestMapping(value = "/searchproduct", method = RequestMethod.POST)
	public String searchProductById(HttpServletRequest request, ModelMap model) {
		String sparam = null;
		sparam = request.getParameter("searchp");
		String fparam = null;
		fparam = request.getParameter("searchpf");
		String searchText = request.getParameter("searchText");
        if(sparam != null) {
		product = productService.getSearchResult(searchText, sparam);
        }
        else {
        	product = productService.filterProducts(searchText, fparam);
        }
		model.addAttribute("product", product);
		return "producthome";

	}

}
