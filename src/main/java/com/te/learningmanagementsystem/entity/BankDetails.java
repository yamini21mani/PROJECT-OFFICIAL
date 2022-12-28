package com.te.learningmanagementsystem.entity;

import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Component
@Table
public class BankDetails {
	@Id
//	@NotNull
	private long accountNo;
//	@NotNull
	private String bankName;
//	@NotNull
	private String accountType;
//	@NotNull
	private String ifscCode;
//	@NotNull
	private String branch;
//	@NotNull
	private String state;
//	@OneToOne(cascade = CascadeType.ALL)
//	private Primary_Info primary_Info;
	
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
