package com.nagarro.pmp.PMPBackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.pmp.PMPBackend.dto.LoginDTO;
import com.nagarro.pmp.PMPBackend.services.AdminService;

@Controller
@SessionAttributes("id")
public class AdminLoginController {
	
	@Autowired
	AdminService adminService;
	

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        return "adminlogin";
    }
	
	
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public String adminLogin(ModelMap model, @RequestParam int id, @RequestParam String password)
	{
		LoginDTO adminLoginDTO=new LoginDTO();
		adminLoginDTO.setId(id);
		adminLoginDTO.setPassword(password);
		LoginDTO res=adminService.validateCredentials(adminLoginDTO);
		if(res!=null)
		{
			 model.put("id", id);
		        model.put("password", password);

		        return "home";
		}
		else
		{
			model.put("errorMessage", "Invalid Credentials");
            return "adminlogin";
		}
	}

}
