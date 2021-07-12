import java.util.*;

class MyEmployee //this class is same as of our emp table of oracle dbms
{
	private int employeeNumber; //empno
	private String employeeName; //ename
	private float employeeSalary; //sal,  job,hiredate,deptno,mgr,comm are missing
	
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
	public float getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
}
public class InputTest {
	public static void main(String[] args) {
		
		MyEmployee empObj1 = new MyEmployee(); //may be a child of Student, Person
		
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter emp number      : ");
		empObj1.setEmployeeNumber(scan.nextInt()); //7839 <=
		String str = scan.nextLine();
		
		//Scanner scanString = new Scanner(System.in);
		System.out.print("\nEnter employee name   : ");
		empObj1.setEmployeeName(scan.next()); //
		
		//Scanner scanFloat = new Scanner(System.in);
		System.out.print("\nEnter employee salary : ");
		empObj1.setEmployeeSalary(scan.nextFloat()); //new york
		
		System.out.println("Employee number entered is : "+empObj1.getEmployeeNumber());
		System.out.println("Employee name entered is   : "+empObj1.getEmployeeName());
		System.out.println("Employee salary entered is : "+empObj1.getEmployeeSalary());
		
		
	}
}
