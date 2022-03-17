package com.cg.canteen.aug3.AdminRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.canteen.aug3.AdminEntity.CustomerEntity;


@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity,Integer>{
	
	public abstract List<CustomerEntity> findBycName(String cName);
	public abstract Optional<CustomerEntity> getBycUsername(String cUsername);
	public abstract List<CustomerEntity> findBycCity(String cCity);
	public abstract List<CustomerEntity> findBycGender(String cGender);
	
}
