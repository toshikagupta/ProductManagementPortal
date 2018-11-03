package com.nagarro.pmp.PMPBackend.controllers;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String displaySelle(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{	
		
		int totalCount=sellerService.getTotalSellerCount();	
		int page = 1;
        int recordsPerPage = 2;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
       System.out.println("totalRecord "+totalCount);
      List<SellerDTO> list=  sellerService.getSellerWithOffset((page-1)*recordsPerPage, recordsPerPage);
       
        //int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(totalCount * 1.0 / recordsPerPage);
       // request.setAttribute("employeeList", list);
        model.addAttribute("seller",list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
       //RequestDispatcher view = request.getRequestDispatcher("home.jsp");
       // view.forward(request, response);
		
		
		
		
		
		return "home";
		
		
	}
	
	@RequestMapping(value="/viewpage", method=RequestMethod.GET)
	public String nextPage(@RequestParam("page") String pageNumber,ModelMap model, HttpServletRequest request, HttpServletResponse response)
  {
	
		

		int totalCount=sellerService.getTotalSellerCount();
		//model.addAttribute("totalCount", totalCount);
		
		
		
		
		int page = Integer.parseInt(pageNumber);
        int recordsPerPage = 2;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
       System.out.println("totalRecord "+totalCount);
      List<SellerDTO> list=  sellerService.getSellerWithOffset((page-1)*recordsPerPage, recordsPerPage);
       
        //int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(totalCount * 1.0 / recordsPerPage);
       // request.setAttribute("employeeList", list);
        model.addAttribute("seller",list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
       //RequestDispatcher view = request.getRequestDispatcher("home.jsp");
       // view.forward(request, response);
		
		
		
		
		
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
	public String displayProduc(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	{	
		product=productService.getAllProduct();
		
		
		int totalCount=productService.getTotalProductCount();	
		int page = 1;
        int recordsPerPage = 2;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
       System.out.println("totalRecord "+totalCount);
      List<ProductDTO> list=  productService.getProductWithOffset((page-1)*recordsPerPage, recordsPerPage);
       
        //int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(totalCount * 1.0 / recordsPerPage);
       // request.setAttribute("employeeList", list);
        model.addAttribute("product",list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
       
		return "producthome";
		
	}
	@RequestMapping(value="/productdetails", method = RequestMethod.POST)
	public String displayProduct(ModelMap model)
	{	
		 product=productService.getAllProduct();
		 model.addAttribute("product",product);
		return "producthome";
		
	}

	@RequestMapping(value="/viewproductpage", method=RequestMethod.GET)
	public String nextProductPage(@RequestParam("page") String pageNumber,ModelMap model, HttpServletRequest request, HttpServletResponse response)
  {
	
		

		int totalCount=productService.getTotalProductCount();
		//model.addAttribute("totalCount", totalCount);
		
		
		
		
		int page = Integer.parseInt(pageNumber);
        int recordsPerPage = 2;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
       System.out.println("totalRecord "+totalCount);
      List<ProductDTO> list=  productService.getProductWithOffset((page-1)*recordsPerPage, recordsPerPage);
       
        //int noOfRecords = dao.getNoOfRecords();
        int noOfPages = (int) Math.ceil(totalCount * 1.0 / recordsPerPage);
       // request.setAttribute("employeeList", list);
        model.addAttribute("product",list);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
      
		return "producthome";
}
	
	
}
