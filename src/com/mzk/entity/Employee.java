package com.mzk.entity;

public class Employee {
	private int empId;
	private String empUser;
	private String empPassword;
	private String empName;
	private int empAge;
	private String empStatus;
	private int empLevel;
	private int empJobId;
	private int empTrainId;
	private int empDepartId;
	private String empPs;
	private int empInfo;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpUser() {
		return empUser;
	}
	public void setEmpUser(String empUser) {
		this.empUser = empUser;
	}
	public String getEmpPassword() {
		return empPassword;
	}
	public void setEmpPassword(String empPassword) {
		this.empPassword = empPassword;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpStatus() {
		return empStatus;
	}
	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}
	public int getEmpLevel() {
		return empLevel;
	}
	public void setEmpLevel(int empLevel) {
		this.empLevel = empLevel;
	}
	public int getEmpJobId() {
		return empJobId;
	}
	public void setEmpJobId(int empJobId) {
		this.empJobId = empJobId;
	}
	public int getEmpTrainId() {
		return empTrainId;
	}
	public void setEmpTrainId(int empTrainId) {
		this.empTrainId = empTrainId;
	}
	public int getEmpDepartId() {
		return empDepartId;
	}
	public void setEmpDepartId(int empDepartId) {
		this.empDepartId = empDepartId;
	}
	public String getEmpPs() {
		return empPs;
	}
	public void setEmpPs(String empPs) {
		this.empPs = empPs;
	}
	public int getEmpInfo() {
		return empInfo;
	}
	public void setEmpInfo(int empInfo) {
		this.empInfo = empInfo;
	}
	public Employee() {
		super();
	}
	public Employee(int empId, String empUser, String empPassword, String empName, int empAge, String empStatus,
			int empLevel, int empJobId, int empTrainId, int empDepartId, String empPs, int empInfo) {
		super();
		this.empId = empId;
		this.empUser = empUser;
		this.empPassword = empPassword;
		this.empName = empName;
		this.empAge = empAge;
		this.empStatus = empStatus;
		this.empLevel = empLevel;
		this.empJobId = empJobId;
		this.empTrainId = empTrainId;
		this.empDepartId = empDepartId;
		this.empPs = empPs;
		this.empInfo = empInfo;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empUser=" + empUser + ", empPassword=" + empPassword + ", empName="
				+ empName + ", empAge=" + empAge + ", empStatus=" + empStatus + ", empLevel=" + empLevel + ", empJobId="
				+ empJobId + ", empTrainId=" + empTrainId + ", empDepartId=" + empDepartId + ", empPs=" + empPs
				+ ", empInfo=" + empInfo + "]";
	}
	
	
}
