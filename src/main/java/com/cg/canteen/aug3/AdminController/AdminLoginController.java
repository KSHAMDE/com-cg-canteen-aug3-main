package com.cg.canteen.aug3.AdminController;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cg.canteen.aug3.AdminEntity.Admin;
import com.cg.canteen.aug3.AdminServices.AdminLoginService;

@RestController
public class AdminLoginController {
	
	@Autowired
	AdminLoginService  adminLoginService;
	
	private static final Logger LOG = LoggerFactory.getLogger(AdminLoginController.class);
	 final ModelAndView model = new ModelAndView();
	 

		@GetMapping("/getAdminById/{aId}")
		public ResponseEntity<Admin> getAdminById(@PathVariable int aId){
			LOG.info("Get Admin By ID");
			Admin admin=adminLoginService.getAdminById(aId);
			return new ResponseEntity<Admin>(admin,HttpStatus.OK);
			
		}
		
		@PostMapping("/addAdmin")
		public Admin addAdmin(@RequestBody Admin  admin ) {
				LOG.info("addAdmin");
			return adminLoginService.addAdmin(admin);
		}
		
		@PutMapping("/updateAdmin")
	    public Admin updateAdmin(@RequestBody Admin admin) {
	        LOG.info("updateAdmin");
	        return adminLoginService.updateAdmin(admin);
	    }
		
		 @GetMapping("/getAdminWithName/{aName}")
		    public ResponseEntity<List<Admin>> getAdminWithName(@PathVariable String aName) {
		        LOG.info("getAdminWithName");
		        List<Admin> aList = adminLoginService.getAdminWithName(aName);
		        return new ResponseEntity<>(aList, HttpStatus.OK);
		    }
		 
		 @GetMapping("/getAdminWithGender/{aGender}")
		    public ResponseEntity<List<Admin>> getAdminWithGender(@PathVariable String aGender) {
		        LOG.info("getStaffWithGender");
		        List<Admin> aList = adminLoginService.getAdminWithGender(aGender);
		        return new ResponseEntity<>(aList, HttpStatus.OK);
		    }
		 
		 @PostMapping("/loginAdmin")
			public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
		    	LOG.info("Admin_Login");
				Admin result = adminLoginService.loginAdmin(admin.getaUsername(), admin.getaPassword());
				ResponseEntity<Admin> response = new ResponseEntity<>(result, HttpStatus.OK);
				return response;
			}
}

