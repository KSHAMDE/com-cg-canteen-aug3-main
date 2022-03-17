package com.cg.canteen.aug3.AdminEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Beverages")
public class Beverages {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	@Column(name = "b_id")
	private int bId;
	
	@Column(name = "b_name")
	private String bName;

	@Column(name = "b_price")
	private double bPrice;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public double getbPrice() {
		return bPrice;
	}

	public void setbPrice(double bPrice) {
		this.bPrice = bPrice;
	}

	public Beverages() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Beverages(int bId, String bName, double bPrice) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bPrice = bPrice;
	}

	@Override
	public String toString() {
		return "Beverages [bId=" + bId + ", bName=" + bName + ", bPrice=" + bPrice + "]";
	}
	
	
	
}