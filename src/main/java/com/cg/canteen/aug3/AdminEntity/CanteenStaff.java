package com.cg.canteen.aug3.AdminEntity;

 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
 

@Entity
@Table(name="Staff")
public class CanteenStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="staff_id")
    private int staffId;
    
    @Column(name="staff_name")
    private String staffName;
    
    @Column(name="staff_gender")
    private String staffGender;
    
    @Column(name="staff_phoneNo")
    @NotNull
    private long staffPhone;
    
    @Column(name="staff_address")
    private String staffAddress;
    
    @Column(name="staff_city")
    private String staffCity;
    
    
    @Column(name="staff_Uname")
    @NotNull
//    @NotBlank(message="Please enter your userName")
//    @Pattern(regexp = "^[a-zA-Z]+$", message = "Please Enter Valid Name")
    private String staffUsername;
    

    @Column(name="staff_pwd",length = 50)
    @NotBlank(message="Please enter your password")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String staffPassword;


	public int getStaffId() {
		return staffId;
	}


	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}


	public String getStaffName() {
		return staffName;
	}


	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}


	public String getStaffGender() {
		return staffGender;
	}


	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}


	public long getStaffPhone() {
		return staffPhone;
	}


	public void setStaffPhone(long staffPhone) {
		this.staffPhone = staffPhone;
	}


	public String getStaffAddress() {
		return staffAddress;
	}


	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}


	public String getStaffCity() {
		return staffCity;
	}


	public void setStaffCity(String staffCity) {
		this.staffCity = staffCity;
	}


	public String getStaffUsername() {
		return staffUsername;
	}


	public void setStaffUsername(String staffUsername) {
		this.staffUsername = staffUsername;
	}


	public String getStaffPassword() {
		return staffPassword;
	}


	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}


	public CanteenStaff(int staffId, String staffName, String staffGender, @NotNull long staffPhone,
			String staffAddress, String staffCity,
			@NotNull @NotBlank(message = "Please enter your userName") @Pattern(regexp = "^[a-zA-Z]+$", message = "Please Enter Valid Name") String staffUsername,
			@NotNull @NotBlank(message = "Please enter your password") String staffPassword) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffGender = staffGender;
		this.staffPhone = staffPhone;
		this.staffAddress = staffAddress;
		this.staffCity = staffCity;
		this.staffUsername = staffUsername;
		this.staffPassword = staffPassword;
	}


	public CanteenStaff() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "CanteenStaff [staffId=" + staffId + ", staffName=" + staffName + ", staffGender=" + staffGender
				+ ", staffPhone=" + staffPhone + ", staffAddress=" + staffAddress + ", staffCity=" + staffCity
				+ ", staffUsername=" + staffUsername + ", staffPassword=" + staffPassword + "]";
	}
    
    
    
}
 