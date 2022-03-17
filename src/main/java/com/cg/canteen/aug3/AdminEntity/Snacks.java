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
@Table(name="Snacks")

public class Snacks {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "s_id")
	private int sId;
	
	@Column(name = "s_name",nullable=false,unique=true)
	private String sName;
	
//	@Column(name = "s_qty")
//	private int sQty;
//	
	@Column(name = "s_price",nullable=false)
	private double sPrice;
	
	
//	@ManyToOne // ManyToOneAssociation
//	@JoinColumn(name = "cart_id")
//	private CartEntity foodcart;


	public int getsId() {
		return sId;
	}


	public void setsId(int sId) {
		this.sId = sId;
	}


	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public double getsPrice() {
		return sPrice;
	}


	public void setsPrice(double sPrice) {
		this.sPrice = sPrice;
	}


	public Snacks() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Snacks(int sId, String sName, double sPrice) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sPrice = sPrice;
	}


	@Override
	public String toString() {
		return "Snacks [sId=" + sId + ", sName=" + sName + ", sPrice=" + sPrice + "]";
	}

	
}