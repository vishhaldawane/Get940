package com.dept;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.dept.Department;

public class DepartmentTest {
	
	DepartmentDAOImpl dao = new DepartmentDAOImpl(); //upto the factory
	
	    
	@Test
	public void showAllDeptsTest() {
		List<Department> allDepts = dao.selectAllDepartments();
        for(Department d : allDepts) {
        	 System.out.println("DEPTNO : "+d.getDepartmentNumber());
        	 System.out.println("DNAME  : "+d.getDepartmentName());
        	 System.out.println("DEPTLOC: "+d.getDepartmentLocation());
        	 System.out.println("----------------------------");
        }
	}
	
	@Test
	public void showSingleDeptTest() {
        Department dept = dao.selectDepartment(10);
        System.out.println("DEPTNO : "+dept.getDepartmentNumber());
	   	System.out.println("DNAME  : "+dept.getDepartmentName());
	   	System.out.println("DEPTLOC: "+dept.getDepartmentLocation());
	   	System.out.println("----------------------------");
	}
	
	@Test
	public void insertSingleDeptTest() {
		//ArrayList<Department> allDepts = dao.selectAllDepartments();
        Department dept = new Department();
        dept.setDepartmentName("QMS1");
        dept.setDepartmentLocation("CHENNAI1");
        dao.insertDepartment(dept);
	}
	@Test
	public void updateDeptTest() {
		//ArrayList<Department> allDepts = dao.selectAllDepartments();
        Department dept = new Department(70,"QQMMSS","BANGALORE");
        dao.updateDepartment(dept);
	}
	
	@Test
	public void deleteDeptTest() {
		//ArrayList<Department> allDepts = dao.selectAllDepartments();
        Department dept = new Department();
        dept.setDepartmentNumber(70);
        dao.deleteDepartment(dept);
	}
	
	@Test
	public void insertHod() {
		BaseDAO baseDao = new BaseDAO();
		HeadOfDepartment hod1 = new HeadOfDepartment();
		HeadOfDepartment hod2 = new HeadOfDepartment();
		HeadOfDepartment hod3 = new HeadOfDepartment();
		HeadOfDepartment hod4 = new HeadOfDepartment();
		
		hod1.setHodName("Robert");	hod1.setHodAddress("Pune");
		hod2.setHodName("Jane");	hod2.setHodAddress("Chennai");
		hod3.setHodName("Miller");	hod3.setHodAddress("Delhi");
		hod4.setHodName("Sam");		hod4.setHodAddress("Mumbai");
		
		baseDao.save(hod1);baseDao.save(hod2);
		baseDao.save(hod3);baseDao.save(hod4);
		
		
	}
	
	@Test
	public void createDepartmentAlongWithHOD() {
		
		Department dept = new Department(); //transient
		dept.setDepartmentName("ngTest"); //1
		dept.setDepartmentLocation("LTI"); //2nd
		
		HeadOfDepartment hod = new HeadOfDepartment(); //transient
		hod.setHodName("Dinesh");
		hod.setHodAddress("Mumbai");
		hod.setDept(dept); // hod is setting its dept
	
		dept.setHod(hod); //dept is setting its hod  //3rd
		
		BaseDAO baseDao = new BaseDAO();
		baseDao.save(dept); //storing only the dept
	
	}
	@Test
	public void findDepartment() {
		
		Department dept; 
		BaseDAO baseDao = new BaseDAO();
		dept = baseDao.find(Department.class, 24);
		System.out.println("dept "+dept);
		System.out.println("dept no       : "+dept.getDepartmentNumber());
		System.out.println("dept name     : "+dept.getDepartmentName());
		System.out.println("dept location : "+dept.getDepartmentLocation());
		HeadOfDepartment hod = dept.getHod();
		System.out.println("hod id        : "+hod.getHodId());
		System.out.println("hod name      : "+hod.getHodName());
		System.out.println("hod address   : "+hod.getHodAddress());
	}
	@Test
	public void findHod() {
		
		HeadOfDepartment hod; 
		BaseDAO baseDao = new BaseDAO();
		hod= baseDao.find(HeadOfDepartment.class, 25);
		System.out.println("hod id        : "+hod.getHodId());
		System.out.println("hod name      : "+hod.getHodName());
		System.out.println("hod address   : "+hod.getHodAddress());
		Department dept = hod.getDept();
		System.out.println("dept no       : "+dept.getDepartmentNumber());
		System.out.println("dept name     : "+dept.getDepartmentName());
		System.out.println("dept location : "+dept.getDepartmentLocation());
	}
	
	@Test
	void addEmployeesForANewDepartment() {
		BaseDAO baseDao = new BaseDAO();
	
		Department dept = new Department();
		dept.setDepartmentName("QMS");
		dept.setDepartmentLocation("Mumbai");
		
		Employee e1 = new Employee("KING","MANAGER",dept);
		Employee e2 = new Employee("JACK","MANAGER",dept);
		Employee e3 = new Employee("JILL","CLERK",dept);
		
		Set<Employee> empSet = new HashSet<Employee>();
		empSet.add(e1);
		empSet.add(e2);
		empSet.add(e3);
		
		dept.setEmployeeSet(empSet);
		baseDao.save(dept);
	}
}
