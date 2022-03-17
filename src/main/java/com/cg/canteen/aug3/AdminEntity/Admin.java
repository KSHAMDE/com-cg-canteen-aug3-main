package com.cg.canteen.aug3.AdminEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Scope(scopeName = "prototype")
@Table(name="Admin")
public class Admin {
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @Column(name="aId")
    private int aId;
    
    @Column(name = "a_name", length = 20)
    private String aName;
    
    @Column(name="a_gender")
    private String aGender;
    
    @Column(name="aUsername")
    private String aUsername;
    
    @Column(name="aPassword")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String aPassword;

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaGender() {
		return aGender;
	}

	public void setaGender(String aGender) {
		this.aGender = aGender;
	}

	public String getaUsername() {
		return aUsername;
	}

	public void setaUsername(String aUsername) {
		this.aUsername = aUsername;
	}

	@JsonIgnore
	public String getaPassword() {
		return aPassword;
	}

	public void setaPassword(String aPassword) {
		this.aPassword = aPassword;
	}

	public Admin() {
		super();
	}

	public Admin(int aId, String aName, String aGender, String aUsername, String aPassword) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aGender = aGender;
		this.aUsername = aUsername;
		this.aPassword = aPassword;
	}

	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", aName=" + aName + ", aGender=" + aGender + ", aUsername=" + aUsername
				+ ", aPassword=" + aPassword + "]";
	}

    

}
