class Person
{
	private char gender;
	private int age;
	private String name;
	
	//mutator
	void setPerson(char g, int a, String n) {
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
			if( (ch>='A' && ch<='Z') || (ch>='a' && ch<='z') )
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
	}
	//accessor
	void showPerson() {
		System.out.println("Gender : "+gender);
		System.out.println("Age    : "+age);
		System.out.println("Name   : "+name);
		System.out.println("--------------");
		
	}
}

public class AbstractionTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setPerson('M', 30, "Peter");
		p1.showPerson();
		
		Person p2 = new Person();
		p2.setPerson('F',20,"Julia");
		p2.showPerson();
	
		System.out.println("Changing gender...");

		//The field Person.gender is not visible
		/*p1.gender = p2.gender;
		p2.name = p1.name;
		p2.name="#@$#@$";
		
		p2.age=340;
		p1.age=330;*/
		
		
	
		
		
	}
}
