package com.cg.canteen.aug3.AdminRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.canteen.aug3.AdminEntity.Snacks;

@Repository
public interface SnacksRepository extends JpaRepository<Snacks, Integer>{
	
	public abstract List<Snacks> findBysName(String sName);
	public abstract List<Snacks> findBysPrice(double sPrice);
	public abstract List<Snacks> findBysPriceLessThan(double sPrice);
	public abstract List<Snacks> findBysPriceGreaterThan(double sPrice);
//	public abstract List<Snacks> findBysQty(int sQty);
//	public abstract Snacks addCartsQty();
//	public abstract Snacks removeCartsQty();
	
}
