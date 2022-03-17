package com.cg.canteen.aug3.AdminServices;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.canteen.aug3.AdminEntity.Admin;
import com.cg.canteen.aug3.AdminException.AdminNotFoundException;
import com.cg.canteen.aug3.AdminRepository.AdminLoginRepository;

@Service
public class AdminLoginService {
	@Autowired
	AdminLoginRepository adminLoginRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(AdminLoginService.class);
	
	public Admin getAdminById(int aId) {
		LOG.info("getAdminById" + aId);
		Optional<Admin> optAdmin = adminLoginRepository.findById(aId);
		if (optAdmin.isEmpty()) {
			LOG.error("Admin not found.");
			throw new AdminNotFoundException();
		} else
			return optAdmin.get();
	}
	
	public Admin addAdmin(Admin admin) {
		
		LOG.info("addAdmin");
		return adminLoginRepository.save(admin);
		
	}
	
	public Admin updateAdmin(Admin admin) {
        LOG.info("updateAdmin");
        return adminLoginRepository.save(admin);
    }
		
	public Admin loginAdmin(String aUsername, String aPassword) {
		Admin admin;
		
			Optional<Admin> optAdmin =adminLoginRepository.getByaUsername(aUsername);
			if(optAdmin.get().getaUsername().equals(aUsername) &&  optAdmin.get().getaPassword().equals(aPassword)) 
			{
				
				int aId=optAdmin.get().getaId();
				admin= adminLoginRepository.findById(aId).get();
				LOG.info("Admin login is  successfull");
				return admin;
			}
			else {
				return null;
			}
			
	}
	
	public List<Admin> getAdminWithName(String aName) {
        LOG.info("getAdminWithName" + aName);
        List<Admin> aList = adminLoginRepository.findByaName(aName);
        if (aList.size() == 0) {
            LOG.error("Admin not found.");
            throw new AdminNotFoundException();
        } else
            return aList;
    } 
	
	public List<Admin> getAdminWithGender(String aGender) {
        LOG.info("getAdminWithGender" + aGender);
        List<Admin> aList = adminLoginRepository.findByaGender(aGender);
        if (aList.size() == 0) {
            LOG.error("Admin not found.");
            throw new AdminNotFoundException();
        } else
            return aList;
    } 
}

