package com.cg.canteen.aug3.AdminRepository;

 

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.canteen.aug3.AdminEntity.CanteenStaff;

 

public interface CanteenStaffRepository extends JpaRepository<CanteenStaff, Integer>{
	
    public abstract List<CanteenStaff> findBystaffName(String sName);
    public abstract List<CanteenStaff> findBystaffCity(String sName);
    public abstract List<CanteenStaff> findBystaffGender(String sName);
    public abstract Optional<CanteenStaff> getByStaffUsername(String sUsername);
    
    public abstract boolean existsBystaffUsername(String staffUsername);
    
}
