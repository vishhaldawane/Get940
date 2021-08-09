package com.example.demo.layer3;


import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Employee;
import com.example.demo.layer2.EmployeeNotFoundException;

@Repository
public class EmployeeRepositoryImpl extends BaseRepository implements EmployeeRepository {

	public EmployeeRepositoryImpl() {
		System.out.println("EmployeeRepositoryImpl() constructed...");
	}
	
	@Transactional
	public void insertEmployee(Employee ref) {
		EntityManager entityManager = getEntityManager();
		entityManager.persist(ref); //based on PK
		System.out.println("employee inserted..."+ref);
	}

	@Transactional
	public Employee selectEmployee(int employeeNumber) throws EmployeeNotFoundException {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Employee.class, employeeNumber);//based on PK
	}

	@Transactional
	public List<Employee> selectAllEmployees() {
		EntityManager entityManager = getEntityManager();
		//EntityTransaction tx = entityManager.getTransaction();
		//tx.begin();
		Query query = entityManager.createQuery(" from Employee");
		List<Employee> empList = query.getResultList();
		System.out.println("emplist "+empList.size());
		for (Employee employee : empList) {
			System.out.println("empname "+employee.getEmployeeName());
		}
		//tx.commit();
		return empList;
	}
	
	@Transactional
	public List<Employee> selectEmployeeByJob(String job) throws EmployeeNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from Employee e where e.job = :vjob");
		query.setParameter("vjob", job);
		List<Employee> empListAsPerJob = query.getResultList();
		return empListAsPerJob;
	}

	@Transactional
	public List<Employee> selectEmployeeByHiredateRange(Date startDate, Date endDate) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectEmployeeBySalaryRange(float minSalary, float maxSalary)
			throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectEmployeeByCommision() throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectEmployeeByCommision(int value) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> selectEmployeeByDeptno(int deptno) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub

	}

	@Transactional
	public void deleteEmployee(int empno) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub
		EntityManager entityManager = getEntityManager();
		Employee foundEmp = entityManager.find(Employee.class, empno); //find it 
		if(foundEmp!=null)
			entityManager.remove(foundEmp); // based on PK
		else
			throw new EmployeeNotFoundException("Employee Not Found : "+empno);
		System.out.println("EntityManager: employee removed.. ");

	}

}
