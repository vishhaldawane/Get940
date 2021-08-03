package com.dept;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*
 * DEPT
 * DEPARTMENTNUMBER LOC        DNAME       HOD_HODID
---------------- ---------- ---------- ----------
              24 Delhi      Test               25 -> HeadOfDepartment
              26 LTI        ngTest             27 -> HeadOfDepartment
              
 * EMP12
 * empno	ename	job			deptno
 * 7839		KING	MANAGER		24 -> Department Object
 * 4567		JACK	MANAGER		24 -> Department Object
 * 7484		JILL	CLERK		24 -> Department Object
 * 
 * 4657		JANE	SALESMAN	26 -> Department Object
 * 8349		JULIE	SALESMAN	26 -> Department Object
 * 7474		JOBY	CLERK		26 -> Department Object
 */
@Entity
@Table(name="emp12")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name="empno")
	private int employeeNumber;
	
	@Column(name="name",length=20)
	private String employeeName;
	
	@Column(name="job", length=20)
	private String employeeJob;
	
	@ManyToOne
	@JoinColumn(name="DEPT_NO") //foreign key column
	private Department dept;

	public Employee( String employeeName, String employeeJob, Department dept) {
		super();
		
		this.employeeName = employeeName;
		this.employeeJob = employeeJob;
		this.dept = dept;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeJob() {
		return employeeJob;
	}

	public void setEmployeeJob(String employeeJob) {
		this.employeeJob = employeeJob;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
	
}
