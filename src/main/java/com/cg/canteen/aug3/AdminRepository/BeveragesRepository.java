package com.cg.canteen.aug3.AdminRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.canteen.aug3.AdminEntity.Beverages;


@Repository
public interface BeveragesRepository extends JpaRepository<Beverages, Integer>{
	
	
	public abstract List<Beverages> findBybName(String bName);
	public abstract List<Beverages> findBybPrice(double bPrice);
	public abstract List<Beverages> findBybPriceLessThan(double bPrice);
	public abstract List<Beverages> findBybPriceGreaterThan(double bPrice);
//	public abstract List<Beverages> findBybQuantity(int bQuantity);
	

}
