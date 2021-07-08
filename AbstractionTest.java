import java.time.LocalDate;


public class AbstractionTest {
	public static void main(String[] args) {
	
		Student.setCollegeName("SRM College"); //shared data member
		Employee.setCompanyName("LTI");
		Employee e1 = new Employee('F', 21 ,"Julia",103,89.0f,89.0f,70.0f,95.0f,86.0f,85.0f,2222,"Java Developer",25000);
		e1.pan.setPanNumber("JULPE1234T");
		e1.pan.setPanHolderName("Julia Dsouza");
		e1.pan.setFatherName("Peter Dsouza");
		e1.pan.setDateOfBirth(LocalDate.of(2000, 12, 25));
		e1.pan.setIssuedBy("Govt. Of India");
		e1.showEmployee();
		
		Employee e2 = new Employee('M', 22 ,"King",104,79.0f,87.0f,77.0f,92.0f,86.0f,85.0f,2233,"Tester",27000);
		e2.pan.setPanNumber("KIER6734w");
		e2.pan.setPanHolderName("King Dmello");
		e2.pan.setFatherName("Martin Dmello");
		e2.pan.setDateOfBirth(LocalDate.of(2000, 07, 06));
		e2.pan.setIssuedBy("Govt. Of India");
		e2.showEmployee();
		
		Employee e3 = new Employee('M', 23 ,"Smith",105,79.0f,87.0f,70.0f,97.0f,86.0f,85.0f,2244,"Quality Associate",35000);
		e3.pan.setPanNumber("SMIPO1234Q");
		e3.pan.setPanHolderName("Smith Dcunha");
		e3.pan.setFatherName("Adam Dcunha");
		e3.pan.setDateOfBirth(LocalDate.of(2001, 01, 10));
		e3.pan.setIssuedBy("Govt. Of India");
		e3.showEmployee();
		
		if(e1 instanceof Person) {
			System.out.println("Yes e1 is a Person");
		}
		
		if(e1 instanceof Student) {
			System.out.println("Yes e1 is a Student too");
		}
		
		if(e1 instanceof Employee) {
			System.out.println("Ofcourse, e1 is an Employee");
		}
		
		
	/*	Student.setCollegeName("SRM College"); //shared data member 
		
		Student s1 = new Student('F', 21,"Julie",101,99.0f,99.0f,90.0f,90.0f,86.0f,85.0f);
		s1.showStudent();
		
		Student s2 = new Student('F', 20, "Robert",102,89.0f,89.0f,80.0f,90.0f,76.0f,75.0f);
		s2.showStudent();

		
		Student s3 = new Student('F', 22 ,"Sonia",103,89.0f,89.0f,70.0f,95.0f,86.0f,85.0f);
		s3.showStudent();

		*/
		
	//	Kite k1 = new Kite("Red","Akash",50);
//		k1.showKite();
	}
}
class Kite
{
	String color;
	String owner;
	int length;
	
//local c o l assigned to global color,owner and length
	Kite(String color, String owner, int length) { 
		this.color=color;//The assignment to variable color has no effect
		this.owner=owner;
		this.length=length;
	}
	void showKite() {
		System.out.println("Kite color  : "+color);
		System.out.println("Kite owner  : "+owner);
		System.out.println("Kite length : "+length);
	}
}

class Flight{
	/*here implict ctor present*/
}

class Ticket
{
	Ticket() {
		
	} //explicit,whose signature
				//is same as of the implicit
}

class PanCard
{
	private String panNumber;
	private LocalDate dateOfBirth;
	private String panHolderName;
	private String fatherName;
	private String issuedBy;
	
	public PanCard() {
		
	}
	
	public PanCard(String panNumber, LocalDate dateOfBirth, String panHolderName, String fatherName, String issuedBy) {
		super();
		this.panNumber = panNumber;
		this.dateOfBirth = dateOfBirth;
		this.panHolderName = panHolderName;
		this.fatherName = fatherName;
		this.issuedBy = issuedBy;
	}
	
	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPanHolderName() {
		return panHolderName;
	}

	public void setPanHolderName(String panHolderName) {
		this.panHolderName = panHolderName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	void showPanCard() {
		
		System.out.println("PAN Number     : "+panNumber);
		System.out.println("Date of Birth  : "+dateOfBirth);
		System.out.println("PanHolder Name : "+panHolderName);
		System.out.println("Father's Name  : "+fatherName);
		System.out.println("Issued By      : "+issuedBy);
		System.out.println("===================================");
	}
	
}
class Person
{
	private char gender;
	private int age;
	private String name;
	PanCard pan = new PanCard(); //"JULPD4532A",LocalDate.of(2001, 12, 25),"Julia Dsouza","Peter Dsouza","Govt.Of India");
	
	Person() {
		System.out.println("Person ctor...");
	}
	
	//mutator
	/*void set*/
	Person(char g, int a, String n) {
		System.out.println("Person(...) ctor...");
		if(g=='M' || g=='F' || g=='T')
			gender=g;
		else {
			System.out.println("Invalid Gender");
		}
		if(a >=1 && a<=120)
			age=a;
		else {
			System.out.println("Invalid age");
		}
		//n=Juli$%a
		boolean validCharacterFound=false;
		for(int i=0;i<n.length();i++) {
			char ch = n.charAt(i);
			if( ch==32 || (ch>='A' && ch<='Z') || (ch>='a' && ch<='z') )
				validCharacterFound=true;
			else {
				validCharacterFound=false;
				break;
			}
		}
		if(validCharacterFound==true)
			name=n;
		else {
			System.out.println("Invalid name");
		}
		//showPerson();
	}
	//accessor
	void showPerson() {
		System.out.println("Gender : "+gender);
		System.out.println("Age    : "+age);
		System.out.println("Name   : "+name);
		System.out.println("--------------");
		pan.showPanCard();
	}
}
class A
{
	// default ctor is here
}
class B extends A
{
	//default ctor is here + it invokes its super class ctor too
}
//Implicit super constructor Person() is undefined 
//for default constructor. Must define an explicit constructor
class Student extends Person
{
	private int rollNumber;
	
	private float phy;	private float chem;
	private float maths;	private float eng1;
	private float eng2;		private float eng3;
	private float total;	private float perc;
	private char grade;

	private static String collegeName;
	
	static void setCollegeName(String cn) {
		System.out.println("Setting collegeName...");
		collegeName = cn;
	}
	
	Student(char g, int a, String n, int rollNumber, float phy, float chem, float maths, float eng1,
			float eng2, float eng3) {
		super(g, a, n); //invoke nearest super class ctor
		System.out.println("Student(....) ctor...");
		this.rollNumber = rollNumber;
		
		this.phy = phy;
		this.chem = chem;
		this.maths = maths;
		this.eng1 = eng1;
		this.eng2 = eng2;
		this.eng3 = eng3;
	}
	void showStudent() {
		super.showPerson(); //print gender,age and name
		System.out.println("RollNo : "+rollNumber);
		System.out.println("College: "+collegeName);
	//	System.out.println("College: "+collegeName.hashCode());
		System.out.println("--------------------");
		System.out.println("Phy    : "+phy);
		System.out.println("Chem   : "+chem);
		System.out.println("Maths  : "+maths);
		System.out.println("Eng1   : "+eng1);
		System.out.println("Eng2   : "+eng2);
		System.out.println("Eng3   : "+eng3);
		calculateGrade();
		System.out.println("--------------------");
		System.out.println("Total  : "+total);
		System.out.println("Per    : "+perc);
		System.out.println("Grade  : "+grade);
		System.out.println("====================");
	}
	private void calculateTotal() {
		total = phy+chem+maths+eng1+eng2+eng3;
	}
	private void calculatePercentage() {
		calculateTotal();
		perc = total/6;
	}
	private void calculateGrade() {
		calculatePercentage();
		if(perc>=90 && perc<=100)
			grade='A';
		else if(perc>=75 && perc<90)
			grade='B';
		else if(perc>=60 && perc<75)
			grade='C';
		else if(perc>=45 && perc<60)
			grade='D';
		else if(perc>=35 && perc<45)
			grade='E';
		else if(perc<35)
			grade='F';
	}
	
}

class Employee extends Student 
{
	private int employeeNumber;
	private String desg;
	private float basic;	private float pf;	private float net;
	private static String companyName;
	
	static void setCompanyName(String cn) {
		System.out.println("Setting companyName...");
		companyName = cn;
	}
	
	public Employee(char g, int a, String n, int rollNumber, float phy, float chem, float maths, float eng1, float eng2,
			float eng3, int employeeNumber, String desg, float basic) {
		super(g, a, n, rollNumber, phy, chem, maths, eng1, eng2, eng3);
		System.out.println("Employee(....) ctor...");
		this.employeeNumber = employeeNumber;
		this.desg = desg;
		this.basic = basic;
	}

	void showEmployee() {
		super.showStudent(); //print gender,age and name
		System.out.println("EmpNo  : "+employeeNumber);
		System.out.println("Company: "+companyName);
		System.out.println("Desg   : "+desg);
		System.out.println("--------------------");
		calculateNet();
		System.out.println("Basic  : "+basic);
		System.out.println("PF     : "+pf);
		System.out.println("Net    : "+net);
		System.out.println("====================");
	}
	private void calculateNet() {
		calculatePf(); 
		net = basic - pf;
	}
	private void calculatePf() {
		pf = basic * 10/100;
	}
	
}