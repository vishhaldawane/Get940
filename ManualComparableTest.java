interface SalaryComparable
{
	int compareSalaryWith(Employee x);
}

class Employee implements SalaryComparable
{
	private int employeeNumber;
	private String employeeName;
	private String employeeJob;
	private String employeeDept;
	private String projectName;
	private float salary;
	
	public Employee(int employeeNumber, String employeeName, String employeeJob, String employeeDept,
			String projectName, float salary) {
		super();
		this.employeeNumber = employeeNumber;
		this.employeeName = employeeName;
		this.employeeJob = employeeJob;
		this.employeeDept = employeeDept;
		this.projectName = projectName;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", employeeName=" + employeeName + ", employeeJob="
				+ employeeJob + ", employeeDept=" + employeeDept + ", projectName=" + projectName + ", salary=" + salary
				+ "]";
	}
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public String getEmployeeJob() {
		return employeeJob;
	}
	public String getEmployeeDept() {
		return employeeDept;
	}
	public String getProjectName() {
		return projectName;
	}
	public float getSalary() {
		return salary;
	}
	void fun() {
		System.out.println("fun is invoked...by "+employeeName);
	}
	void discussWith() {
		System.out.println(employeeName+" discussing with "+employeeName);
	}
	
	//passing object as parameter / argument
	void discussWith(Employee ref) {
		System.out.println(employeeName+" discussing with "+ref.employeeName);
		if(salary< ref.salary) {
			System.out.println("Oh .."+ref.employeeName+" my salary is less than your salary");
		}
		else {
			System.out.println("Wow .."+ref.employeeName+" my salary is more than your salary");
		}
	}
	//passing multiple objects as arguments....
	void groupDiscussWith(Employee ref1, Employee ref2) {
		System.out.println(employeeName+" group discussing with "+ref1.employeeName+" and "+ref2.employeeName);
		
	}
	public int compareSalaryWith(Employee x) { //mandate from an interface
		int value=0;
		if(salary<x.salary)			value=-1;
		else if(salary>x.salary)	value=1;
			else					value=0;
		return value;
	}
}
public class ManualComparableTest {
	public static void main(String[] args) {
		Employee e1 = new Employee(112, "Jack", "Coder", "Coding", "Airline", 8000);
		Employee e2 = new Employee(102, "Jane", "Tester", "Testing", "Airline", 8000);
		if(e1.compareSalaryWith(e2) < 0) {
			System.out.println("e1 salary less than e2");
		}
		else if(e1.compareSalaryWith(e2) > 0) {
			System.out.println("e1 salary more than e2");
		}
		else {
			System.out.println("e1 salary same as e2");
		}
		
		
		
		Employee e3 = new Employee(100, "John", "Analyst", "Quality", "Banking", 6000);
		Employee e4 = new Employee(103, "Joby", "DBA", "Database", "Banking", 5600);
		Employee e5 = new Employee(111, "Jimy", "Coder", "Coding", "Airline", 5500);

		//e2.discussWith(e1);
		//e1.discussWith(e2);
		//e5.discussWith(e1);
		//e1.groupDiscussWith(e2,e3);
		//e1.groupDiscussWith(e4,e5); 
		//e5.groupDiscussWith(e3,e2);
		//comparing seniority
		/*if(e1.getEmployeeNumber() < e5.getEmployeeNumber()) {
			System.out.println(e1.getEmployeeName()+" is senior to "+e5.getEmployeeName());
		}
		else {
			System.out.println(e1.getEmployeeName()+" is junior to "+e5.getEmployeeName());
		}
		
		//compare salary now
		if(e1.getSalary() < e2.getSalary()) {
			System.out.println(e1.getEmployeeName()+" salary is less than "+e2.getEmployeeName());
		}
		else {
			System.out.println(e1.getEmployeeName()+" salary is more than "+e2.getEmployeeName());
		}
		*/
	}
}
