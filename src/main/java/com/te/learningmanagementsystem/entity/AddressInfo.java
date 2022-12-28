package com.te.learningmanagementsystem.entity;



import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Component
@Entity
@Table
public class AddressInfo {
	@Id
	private Integer sNo;
  // @NotNull
 //   private Integer employeeAddressId;
	@NotNull
	private String street;
	@NotNull
	private String city;
	@NotNull
	private String state;
	//@NotBlank(message="pincode shouldn't be blank")
	private Integer pincode;
	@NotNull
	private String doorNo;
	@NotNull
	private String locality;
	@NotNull
	private String addressType;
	@NotNull
	private String landMark;
	
// @ManyToOne(cascade = CascadeType.ALL)
//	private Primary_Info primary_Info;

	public Integer getsNo() {
		return sNo;
	}

	public void setsNo(Integer sNo) {
		this.sNo = sNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
//
//	public Integer getEmployeeAddressId() {
//		return employeeAddressId;
//	}
//
//	public void setEmployeeAddressId(Integer employeeAddressId) {
//		this.employeeAddressId = employeeAddressId;
//	}

}
