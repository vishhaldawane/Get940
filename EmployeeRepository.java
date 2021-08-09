package com.example.demo.layer3;


import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.layer2.Employee;
import com.example.demo.layer2.EmployeeNotFoundException;



//IF THIS INTERFACE DESIGNED BY THE TEAM LEADER ( WITH GROUP DISCUSSION )
@Repository
public interface EmployeeRepository {
	
	void insertEmployee(Employee ref);
	
	Employee selectEmployee(int employeeNumber) throws EmployeeNotFoundException;
	List<Employee> selectAllEmployees() ;
	
	List<Employee> selectEmployeeByJob(String job) throws EmployeeNotFoundException;
	List<Employee> selectEmployeeByHiredateRange(Date startDate, Date endDate) throws EmployeeNotFoundException;
	List<Employee> selectEmployeeBySalaryRange(float minSalary, float maxSalary) throws EmployeeNotFoundException;
	List<Employee> selectEmployeeByCommision() throws EmployeeNotFoundException;
	List<Employee> selectEmployeeByCommision(int value) throws EmployeeNotFoundException;
	List<Employee> selectEmployeeByDeptno(int deptno) throws EmployeeNotFoundException;

	void updateEmployee(Employee employee) throws EmployeeNotFoundException;
	void deleteEmployee(int  empno) throws EmployeeNotFoundException;
}















/*
 * 
 * single sequence of hibernate jpa
 * 
 * 	emp			customer		order		product
 * empno		custid			ordid		prodid
 * 121			400				700			9	
 * 122			5				7			10
 * 3			12				8
 * 11							13
 * 
 * 
 *  emp			customer		order		product
 * empno		custid			ordid		prodid
 * 1			1				1			1	
 * 2			2				2			2
 * 3							3
 * 
 */
