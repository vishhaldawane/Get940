package com.lti.Banking;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );	
       /* Kitchen k1 =  Kitchen.getKitchen();
        Kitchen k2 =  Kitchen.getKitchen();
        System.out.println("k1 "+k1);
        System.out.println("k2 "+k2);*/
        
        
       
        
    }
}
//2. pojo DAO interface
interface DepartmentDAO // offering basic CRUD service
{
	void insertDepartment(Department dept);
	Department selectDepartment(int deptno);
	ArrayList<Department> selectAllDepartments();
	void updateDepartment(Department dept);
	void deleteDepartment(Department dept);	
}
//3. pojo dao interface implementation class
class DepartmentDAOImpl implements DepartmentDAO
{

	ArrayList<Department> deptList = new ArrayList<Department>();
	
	DepartmentDAOImpl() {
		//as an initial storage
		deptList.add(new Department(10,"IT","NY"));
		deptList.add(new Department(20,"PURCHASE","ND"));
		deptList.add(new Department(30,"SALES","NM"));
		deptList.add(new Department(40,"OPERATIONS","NP"));
		
		//session factory builder
		//meta data 
		//session factory, session
		
	}
	public void insertDepartment(Department dept) {
		// TODO Auto-generated method stub
		deptList.add(dept); //session.save
	}

	public Department selectDepartment(int deptno) {
		// TODO Auto-generated method stub
		for(Department d : deptList) {
			if(d.getDepartmentNumber() == deptno) {
				return d;
			}
		}
		return null;	
		//session.get
	}

	public ArrayList<Department> selectAllDepartments() {
		// TODO Auto-generated method stub
		return deptList; //session.createQuery
	}

	public void updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		for(Department d : deptList) {
			if(d.getDepartmentNumber() == dept.getDepartmentNumber()) {
				int idx = deptList.indexOf(d);
				deptList.set(idx, dept);
			}
		}
		//session.saveOrUpdate()
	}

	public void deleteDepartment(Department dept) {
		// TODO Auto-generated method stub
		for(Department d : deptList) {
			if(d.getDepartmentNumber() == dept.getDepartmentNumber()) {
				int idx = deptList.indexOf(d);
				deptList.remove(idx);
				break;
			}
		}
		deptList.remove(dept); //session.remove()
	}
	
}
class Department //1. pojo
{
	private int departmentNumber;
	private String departmentName;
	private String departmentLocation;
	
	
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
	@Override
	public String toString() {
		return "Department [departmentNumber=" + departmentNumber + ", departmentName=" + departmentName
				+ ", departmentLocation=" + departmentLocation + "]";
	}
	
	
}
class Kitchen
{
	private static Kitchen ref = null; //one copy of this
	
	private Kitchen() {
		System.out.println("Kitchen ctor");
	}
	public static Kitchen getKitchen() {
		if(ref==null)
			ref = new Kitchen(); // ctor is available here
	
		return ref;
	}
}
/*session factory
 
dept - Department
emp - Employee
customer - Customer
ord - Order
item - Item
product - Product
price - Price

session.save, session.get, session.update, session.delete
session.createQuery - C-R-RA-U-D

Singleton design pattern - pan card of a user
coffee vending machine in an office/
Sun in the Solar system
Kitchen in a home
Prime Minister - for a country

DAO design pattern - 23 patterns - gang of four
	
		"data access" <- object
			
			- it hides the low level data access code
			
				- pojo
				- dao interface
				- dao implementation of the dao interface
				- test
			
			

*/