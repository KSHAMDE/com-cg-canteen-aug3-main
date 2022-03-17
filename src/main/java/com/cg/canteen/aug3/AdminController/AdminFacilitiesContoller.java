package com.cg.canteen.aug3.AdminController;

import java.util.List;

 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.canteen.aug3.AdminServices.CustomerServices;
import com.cg.canteen.aug3.AdminServices.StaffService;
import com.cg.canteen.aug3.AdminEntity.CanteenStaff;
import com.cg.canteen.aug3.AdminEntity.CustomerEntity;

 

@RestController
public class AdminFacilitiesContoller {
    
    @Autowired
    StaffService staffService;
    @Autowired
    CustomerServices customerService;
    
    private static final Logger LOG = LoggerFactory.getLogger(AdminFacilitiesContoller.class);
    
    
    @PostMapping("/addStaffByAdmin")
    public CanteenStaff addStaffByAdmin(@RequestBody CanteenStaff canteenStaff) {
            LOG.info("AddStaff");
        return staffService.addStaff(canteenStaff);
    }
    
//    @GetMapping("/getAllCustomer")
//    public List<CustomerEntity> getAllCustomer() {
//        LOG.info("getAllCustomer");
//        return customerService.getAllCustomer();
//    }
//    
}
 
