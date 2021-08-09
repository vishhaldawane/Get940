package com.example.demo.layer5;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.layer2.Employee;
import com.example.demo.layer2.EmployeeNotFoundException;
import com.example.demo.layer3.EmployeeRepositoryImpl;

@CrossOrigin(origins = "*")
@RestController // it is a specialized version of @Component - marker to receive web request
@RequestMapping("/emps")
public class EmployeeJPAController {
	
	@Autowired
	EmployeeRepositoryImpl empRepo;
	
	public EmployeeJPAController() {
		System.out.println("EmployeeJPAController() constructed...");	
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping(value="/getEmp/{eno}")
	public Employee getEmployee(@PathVariable int eno) {
		System.out.println("getEmployee()...method ");

		try {
			return empRepo.selectEmployee(eno); // FROM THE DB
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping 
	@ResponseBody
	@RequestMapping(value = "/getAllEmps")
	public List<Employee> getEmployees() {
		System.out.println("getEmployees() ");
		return empRepo.selectAllEmployees(); // FROM THE DB
	}
	
	
	

	/*
	@PostMapping
	@ResponseBody
	@RequestMapping(value="/addEmp/{eno}/{enm}/{esal}")
	public String addEmployee(@PathVariable int eno, @PathVariable String enm,@PathVariable double esal) {
		System.out.println("addEmployee(eno,enm,esal)...method ");

		Employee emp = new Employee(); // spring JPA - get the data from DB
		emp.setEmployeeNumber(eno);
		emp.setEmployeeName(enm);
		emp.setEmployeeSalary(esal);
		empList.add(emp);
		return "Employee Added Successfulyy";
	}
	
	@PostMapping
	@ResponseBody
	@RequestMapping(value="/addEmp1")
	public String addEmployee1(@RequestBody Employee emp) {
		System.out.println("addEmployee1(@RequestBody emp)...method ");

		/*Employee emp = new Employee(); // spring JPA - get the data from DB
		emp.setEmployeeNumber(eno);
		emp.setEmployeeName(enm);
		emp.setEmployeeSalary(esal);
		empList.add(emp);
		return "Employee Added Successfulyy";
	}
	
	@PutMapping
	@ResponseBody
	@RequestMapping(value="/modifyEmp/{eno}/{enm}/{esal}")
	public String modifyEmployee(@PathVariable int eno, @PathVariable String enm,@PathVariable double esal) {
		System.out.println("modifyEmployee()...method ");
		String message="Employee Not Found";
		Employee newEmp= new Employee(eno,enm,esal);
		boolean modified=false;
		for (Employee employee : empList) {
			if(employee.getEmployeeNumber() == newEmp.getEmployeeNumber()) {
				int idx =empList.indexOf(employee);
				empList.set(idx, newEmp);
				modified=true;
				break;
			}
		}
		if(modified)
			message  = "Employee Modified Successfully"; 
		return message;
	}
	*/
	
	
	@ResponseBody
	@DeleteMapping(value="/deleteEmp/{eno}")
	public String deleteEmployee(@PathVariable int eno) {
		System.out.println("deleteEmployee()...method ");
		String message="Employee Not Found";
		
		boolean deleted=false;
		try {
			empRepo.deleteEmployee(eno);//invoke the repo
			deleted= true;
			message = "Employee Deleted";
			System.out.println("Controller deleted :" );
		} catch (EmployeeNotFoundException e) {
			//e.printStackTrace();
		//	message = e.getMessage();
			
		}
		return message;
	}
	
	
	 //   /greet for the web user
	//  greetEmployee() -> java developer
	
}
//http://localhost:8080/employees/greet

