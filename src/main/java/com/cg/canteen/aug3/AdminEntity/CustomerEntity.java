package com.cg.canteen.aug3.AdminEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
//import static org.junit.Assert.assertEquals;
//import org.junit.*;

 

import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

 

//import java.util.regex.Pattern;

 


@Entity
@Scope(scopeName = "prototype")
@Table(name="Customer")
public class CustomerEntity {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="cId")
    private int cId;
    
    @Column(name = "c_name", length = 20)
    private String cName;
    
    @Column(name="c_gender")
    private String cGender;
    
    @Column(name = "c_phone", length = 10)
    @Pattern(regexp = "^[0-9]*", message = "Please Enter Valid Number")
    private String cPhone;
    
    @Column(name = "c_address")
    private String cAddress;
    
    @Column(name = "c_city")
    private String cCity;
    
    @Column(name="cUsername")
    private String cUsername;
    
    @Column(name="cPassword")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String cPassword;

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcGender() {
		return cGender;
	}

	public void setcGender(String cGender) {
		this.cGender = cGender;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public String getcAddress() {
		return cAddress;
	}

	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}

	public String getcCity() {
		return cCity;
	}

	public void setcCity(String cCity) {
		this.cCity = cCity;
	}

	public String getcUsername() {
		return cUsername;
	}

	public void setcUsername(String cUsername) {
		this.cUsername = cUsername;
	}
	
	@JsonIgnore
	public String getcPassword() {
		return cPassword;
	}
	
	
	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}

	public CustomerEntity(int cId, String cName, String cGender,
			@Pattern(regexp = "^[0-9]*", message = "Please Enter Valid Number") String cPhone, String cAddress,
			String cCity, String cUsername, String cPassword) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.cGender = cGender;
		this.cPhone = cPhone;
		this.cAddress = cAddress;
		this.cCity = cCity;
		this.cUsername = cUsername;
		this.cPassword = cPassword;
	}

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CustomerEntity [cId=" + cId + ", cName=" + cName + ", cGender=" + cGender + ", cPhone=" + cPhone
				+ ", cAddress=" + cAddress + ", cCity=" + cCity + ", cUsername=" + cUsername + ", cPassword="
				+ cPassword + "]";
	}

	
}