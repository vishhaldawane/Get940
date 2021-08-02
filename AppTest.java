package com.lti.Banking;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
    
{
	 DepartmentDAOImpl dao = new DepartmentDAOImpl();
     
	@Test
	public void showAllDeptsTest() {
		ArrayList<Department> allDepts = dao.selectAllDepartments();
        for(Department d : allDepts) {
        	 System.out.println("d : "+d);
        }
	}
	
	@Test
	public void showSingleDeptTest() {
		//ArrayList<Department> allDepts = dao.selectAllDepartments();
        Department dept = dao.selectDepartment(10);
        System.out.println("dept is "+dept);
	}
	
	@Test
	public void insertSingleDeptTest() {
		//ArrayList<Department> allDepts = dao.selectAllDepartments();
        Department dept = new Department(50,"Test","NW");
        dao.insertDepartment(dept);
        //System.out.println("dept is "+dept);
        ArrayList<Department> allDepts = dao.selectAllDepartments();
        for(Department d : allDepts) {
        	 System.out.println("d : "+d);
        }
	}
	@Test
	public void updateDeptTest() {
		//ArrayList<Department> allDepts = dao.selectAllDepartments();
        Department dept = new Department(10,"INFO","NEW YORK");
        dao.updateDepartment(dept);
        //System.out.println("dept is "+dept);
        ArrayList<Department> allDepts = dao.selectAllDepartments();
        for(Department d : allDepts) {
        	 System.out.println("d : "+d);
        }
	}
	
	@Test
	public void deleteDeptTest() {
		//ArrayList<Department> allDepts = dao.selectAllDepartments();
        Department dept = new Department(10,"IT","NY");
        dao.deleteDepartment(dept);
        //System.out.println("dept is "+dept);
        ArrayList<Department> allDepts = dao.selectAllDepartments();
        for(Department d : allDepts) {
        	 System.out.println("d : "+d);
        }
	}
	
}
