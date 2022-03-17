package com.cg.canteen.aug3.AdminRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.canteen.aug3.AdminEntity.Admin;

public interface AdminLoginRepository extends JpaRepository<Admin,Integer> {

	public abstract List<Admin> findByaName(String aName);
	public abstract Optional<Admin> getByaUsername(String aUsername);
	public abstract List<Admin> findByaGender(String aGender);
}
