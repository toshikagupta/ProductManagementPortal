/**
 * 
 */
package com.nagarro.pmp.PMPBackend.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.pmp.PMPBackend.dto.LoginDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.services.AdminService;

/**
 * @author toshikagupta
 *
 */
@CrossOrigin(origins = "http://localhost:4200") 
@RestController
public class AdminResource {

	@Autowired
	AdminService adminService;

	@PostMapping("/admin/login")
	public LoginDTO login(@RequestBody LoginDTO admin) {
		return adminService.validateCredentials(admin);
	}

	@GetMapping("/sort")
	public List<SellerDTO> getSortedList( String sortparam) {
		return adminService.getSortedList(sortparam);
	}
    
	@GetMapping("/search")
	public List<SellerDTO> getSearchResult(String searchparam, String classifier) {
		return adminService.getSearchResult(searchparam, classifier);
	}

	public List<SellerDTO> filterStatus(String status) {
		return adminService.filterStatus(status);
	}

}
