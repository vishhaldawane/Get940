package com.dept;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="dept")
public class Department { //1. POJO
		//Employee
	@Id		
	@GeneratedValue //generate the unique values 
	@PrimaryKeyJoinColumn //number
	//Specifies a primary key column that is used as a foreign key to join to another table. 
	private int departmentNumber;
				
	@Column(name="DNAME", length=10) //varchar2
	private String departmentName;
	
	@Column(name="LOC", length=10) //varchar2
	private String departmentLocation;

	@OneToOne(cascade = CascadeType.ALL /*, fetch=FetchType.LAZY*/)
	private HeadOfDepartment hod; //enclosed object
	
	@OneToMany (cascade = CascadeType.ALL)
	private Set<Employee> employeeSet;
	
		
	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}
	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}
	
	public HeadOfDepartment getHod() {
		return hod;
	}
	public void setHod(HeadOfDepartment hod) {
		this.hod = hod;
	}
	public Department() {
		super();
		System.out.println("Department() ctor...");
	}
	public Department(int departmentNumber, String departmentName, String departmentLocation) {
		super();
		this.departmentNumber = departmentNumber;
		this.departmentName = departmentName;
		this.departmentLocation = departmentLocation;
	}
	public int getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentLocation() {
		return departmentLocation;
	}
	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	
	
	
	
	
}
