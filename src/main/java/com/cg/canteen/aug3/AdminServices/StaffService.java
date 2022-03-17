package com.cg.canteen.aug3.AdminServices;
import java.util.List;
import java.util.Optional;

 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.cg.canteen.aug3.AdminEntity.CanteenStaff;
import com.cg.canteen.aug3.AdminException.InvalidUserNameOrPasswordException;
import com.cg.canteen.aug3.AdminException.NotEmptyPasswordException;
import com.cg.canteen.aug3.AdminException.StaffAlreadyExistsException;
import com.cg.canteen.aug3.AdminException.StaffNotFoundException;
import com.cg.canteen.aug3.AdminException.UsernameAlreadyExistsException;
import com.cg.canteen.aug3.AdminRepository.CanteenStaffRepository;

 

 

 

@Service
public class StaffService {
    
    @Autowired
    CanteenStaffRepository canteenStaffRepository;
    
    private static final Logger LOG = LoggerFactory.getLogger(StaffService.class);
    
    public CanteenStaff getStaffById(int staffId) {
        LOG.info("getStaffById" + staffId);
        Optional<CanteenStaff> optStaff = canteenStaffRepository.findById(staffId);
        if (optStaff.isEmpty()) {
            LOG.error("Staff not found.");
            throw new StaffNotFoundException();
        } else
            return optStaff.get();
    }
    
    public  boolean existsBystaffUsername(String staffUsername) {
        boolean exists=canteenStaffRepository.existsBystaffUsername(staffUsername);
        if(exists) {
            return true;
        }
        else {
            return false;
        }
        
    }
    public CanteenStaff addStaff(CanteenStaff canteenStaff) {
        
        int id=canteenStaff.getStaffId();
        boolean exists=canteenStaffRepository.existsById(id);
        if(exists) {
            LOG.error("Staff Already exists");
            throw new StaffAlreadyExistsException();
        }
        String staffUsername=canteenStaff.getStaffUsername();
        exists=canteenStaffRepository.existsBystaffUsername(staffUsername);
        if(exists) {
            
            LOG.error("UserName Already exists");
            throw new UsernameAlreadyExistsException();
        }
        if(canteenStaff.getStaffPassword().isEmpty()) {
            LOG.error("UserPassword Should Not be Empty");
            throw new NotEmptyPasswordException();
            
        }

 

        LOG.info("addStaff");
        return canteenStaffRepository.save(canteenStaff); 
    }

 

 

 

    public void updateStaff(CanteenStaff canteenStaff) {
        LOG.info("updateStaff");
        
        if(canteenStaff.getStaffPassword().isEmpty()) {
            LOG.error("UserPassword Should Not be Empty");
            throw new NotEmptyPasswordException();
            
        }
        
        canteenStaffRepository.save(canteenStaff);
    }

 

 

 

    public String deleteStaff(int staffId) {
        boolean exists=canteenStaffRepository.existsById(staffId);
        if(exists) {
            LOG.info("deleteStaff");
            canteenStaffRepository.deleteById(staffId);
        }
        else {
            LOG.error("Staff not found.");
            throw new StaffNotFoundException();
        }
        return "Staff id deleted sucessfully";
    }

 

    public String deleteAllStaff() {
        LOG.info("deleteAllStaff");
        canteenStaffRepository.deleteAll();
        return "All Staff get deleted sucessfully";
    }

 

    public List<CanteenStaff> getAllStaff() {
        LOG.info("getAllStaff ");
        
        List<CanteenStaff> cnkList = canteenStaffRepository.findAll();
        if(cnkList.size() == 0) {
            LOG.error("No Staff Present");
            throw new StaffNotFoundException();
        }else {
            return cnkList;
        }
    }
    
    public List<CanteenStaff> getStaffWithName(String staffName) {
        LOG.info("getStaffWithName" + staffName);
        List<CanteenStaff> cnkList = canteenStaffRepository.findBystaffName(staffName);
        if (cnkList.size() == 0) {
            LOG.error("Staff Name not found.");
            throw new StaffNotFoundException();
        } else
            return cnkList;
    } 
    
    public List<CanteenStaff> getStaffWithCity(String staffCity) {
        LOG.info("getStaffWithCity" + staffCity);
        List<CanteenStaff> cnkList = canteenStaffRepository.findBystaffCity(staffCity);
        if (cnkList.size() == 0) {
            LOG.error("Staff City not found.");
            throw new StaffNotFoundException();
        } else
            return cnkList;
    } 
    
    public List<CanteenStaff> getStaffWithGender(String staffGender) {
        LOG.info("getStaffWithGender" + staffGender);
        List<CanteenStaff> cnkList = canteenStaffRepository.findBystaffGender(staffGender);
        if (cnkList.size() == 0) {
            LOG.error("Staff Gender not found.");
            throw new StaffNotFoundException();
        } else
            return cnkList;
    } 
    
    
    public CanteenStaff loginStaff(String sUsername, String sPassword) {
        CanteenStaff canteenStaff;
       
            Optional<CanteenStaff> optStaff = canteenStaffRepository.getByStaffUsername(sUsername);
            if(optStaff.get().getStaffUsername().equals(sUsername) &&  optStaff.get().getStaffPassword().equals(sPassword))
            {
               
                int sId=optStaff.get().getStaffId();
                canteenStaff= canteenStaffRepository.findById(sId).get();
                LOG.info("Staff login is  successfull");
                return canteenStaff;
            }
            else {
                throw new InvalidUserNameOrPasswordException();
            }
           
    }
    
}