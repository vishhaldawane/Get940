class Kite
{
	void flyKite() {
		
	}
	void kiteFight() {
		
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

class Person
{
	private char gender;
	private int age;
	private String name;
	
	Person() {
		System.out.println("Person ctor...");
	}
	
	//mutator
	/*void set*/
	Person(char g, int a, String n) {
		System.out.println("Person(char,int,String) ctor...");
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
	
	Student(char g, int a, String n, int rollNumber, float phy, float chem, float maths, float eng1,
			float eng2, float eng3) {
		super(g, a, n); //invoke nearest super class ctor
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
public class AbstractionTest {
	public static void main(String[] args) {
		Student s1 = new Student('M', 30, "Julie",101,99.0f,99.0f,90.0f,90.0f,86.0f,85.0f);
		s1.showStudent();
		
		
	}
}
