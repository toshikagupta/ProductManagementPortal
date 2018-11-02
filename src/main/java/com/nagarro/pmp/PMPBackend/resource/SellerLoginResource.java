package com.nagarro.pmp.PMPBackend.resource;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.pmp.PMPBackend.dto.LoginDTO;
import com.nagarro.pmp.PMPBackend.dto.SellerDTO;
import com.nagarro.pmp.PMPBackend.services.SellerService;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
public class SellerLoginResource {
	
	@Autowired
		private SellerService sellerService;

		@PostMapping("/seller/register")
		public ResponseEntity createNewSeller(@RequestBody SellerDTO sellerDTO) {
			  return sellerService.createNewSeller(sellerDTO);

		}

		@PostMapping("/seller/login")
		public ResponseEntity loginSeller(@RequestBody LoginDTO sellerLoginDTO) {
			return sellerService.loginSeller(sellerLoginDTO);
		}
		
		@GetMapping("/allsellers")
		public List<SellerDTO> getAllSellers()
		{
			return sellerService.getAllSellers();
			
		}
		
		

	


}
