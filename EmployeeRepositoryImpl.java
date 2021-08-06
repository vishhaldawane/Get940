package com.example.demo.layer3;


import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.layer2.Employee;
import com.example.demo.layer2.EmployeeNotFoundException;



@Repository
public class EmployeeRepositoryImpl extends BaseRepository implements EmployeeRepository {

	//@Transactional
	public void insertEmployee(Employee ref) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(ref);
		tx.commit();
		System.out.println("employee inserted..."+ref);
	}

	@Override
	public Employee selectEmployee(int employeeNumber) throws EmployeeNotFoundException {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Employee.class, employeeNumber);
	}

	@Override
	public List<Employee> selectEmployeeByJob(String job) throws EmployeeNotFoundException {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select e from Employee e where e.job = :vjob");
		query.setParameter("vjob", job);
		List<Employee> empListAsPerJob = query.getResultList();
		return empListAsPerJob;
	}

	@Override
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

	@Override
	public void deleteEmployee(Employee employee) throws EmployeeNotFoundException {
		// TODO Auto-generated method stub

	}

}
