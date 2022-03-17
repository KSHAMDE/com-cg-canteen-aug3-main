package com.cg.canteen.aug3.AdminController;

 

import java.util.List;

 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.canteen.aug3.AdminEntity.CanteenStaff;
import com.cg.canteen.aug3.AdminServices.StaffService;

 

@RestController
public class StaffController {
    
    @Autowired
    StaffService staffService;
    
    private static final Logger LOG = LoggerFactory.getLogger(StaffService.class);
    
    
    @GetMapping("/getStaffById/{sId}")
	public ResponseEntity<CanteenStaff> getCustomerById(@PathVariable int sId){
		LOG.info("Get Staff By ID");
		CanteenStaff canteenStaff=staffService.getStaffById(sId);
		return new ResponseEntity<CanteenStaff>(canteenStaff,HttpStatus.OK);
		
	}
    
    @GetMapping("/getAllStaff")
    public List<CanteenStaff> getAllStaff() {
        LOG.info("getAllStaff");
        return staffService.getAllStaff();
    }
    
    @PostMapping("/addStaff")
    public CanteenStaff addStaff(@RequestBody CanteenStaff canteenStaff) {
            LOG.info("AddStaff");
        return staffService.addStaff(canteenStaff);
    }

 


    @PutMapping("/updateStaff")
    public String updateStaff(@RequestBody CanteenStaff canteenStaff) {
        LOG.info("updateStaff");
        staffService.updateStaff(canteenStaff);
        return "Staff Updated Sucessfully";
    }

 
    @DeleteMapping("/deleteStaff/{staffId}")
    public String deleteStaff(@PathVariable int staffId) {
        LOG.info("deleteStaff");
        return staffService.deleteStaff(staffId);
    }
    
    @GetMapping("/getStaffWithName/{staffName}")
    public ResponseEntity<List<CanteenStaff>> getStaffWithName(@PathVariable String staffName) {
        LOG.info("getStaffWithName");
        List<CanteenStaff> cnkList = staffService.getStaffWithName(staffName);
        return new ResponseEntity<>(cnkList, HttpStatus.OK);
    }
    @GetMapping("/getStaffWithGender/{staffGender}")
    public ResponseEntity<List<CanteenStaff>> getStaffWithGender(@PathVariable String staffGender) {
        LOG.info("getStaffWithGender");
        List<CanteenStaff> cnkList = staffService.getStaffWithGender(staffGender);
        return new ResponseEntity<>(cnkList, HttpStatus.OK);
    }
    @GetMapping("/getStaffWithCity/{staffCity}")
    public ResponseEntity<List<CanteenStaff>> getStaffWithCity(@PathVariable String staffCity) {
        LOG.info("getStaffWithCity");
        List<CanteenStaff> cnkList = staffService.getStaffWithCity(staffCity);
        return new ResponseEntity<>(cnkList, HttpStatus.OK);
    }
    
    
    @PostMapping("/loginStaff")
    public ResponseEntity<CanteenStaff> loginStaff(@RequestBody CanteenStaff canteenStaff) {
        LOG.info("Staff_Login");
        CanteenStaff result = staffService.loginStaff(canteenStaff.getStaffUsername(), canteenStaff.getStaffPassword());
        ResponseEntity<CanteenStaff> response = new ResponseEntity<>(result, HttpStatus.OK);
        return response;
    }
}
 