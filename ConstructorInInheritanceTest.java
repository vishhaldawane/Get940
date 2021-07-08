class GrandFather
{
	GrandFather(int land) {
		//super(); <-- to the Object class of JAVA
		System.out.println("GrandFather.....ctor : "+land);
	}
	void farming() {
		System.out.println("GrandFather knows farming...");
	}
}
class Father extends GrandFather
{
	//implicit super constructor GrandFather() is undefined
	//Must explicitly invoke another constructor
	Father(int land) {
		super(land); //default 1st line of all the ctors
		System.out.println("Father.....ctor: ");
	}
	Father(int land, float cash) {
		super(land); //default 1st line of all the ctors
		System.out.println("Father.....ctor: "+cash);
	}
	void banking() {
		System.out.println("Father is a cashier...banking...");
	}
}
class Child extends Father 
{
	Child(int land, float cash, float salary) {
		super(land,cash); //default 1st line here
		System.out.println("Child .....ctor..."+salary);
	}
	void coding() {
		System.out.println("Child is coding....");
	}
}

public class ConstructorInInheritanceTest {
	public static void main(String[] args) {
		GrandFather gf = new GrandFather(10);
		gf.farming();
		System.out.println("------");
		Father f = new Father(8);
		f.banking();
		System.out.println("------");
		Child c = new Child(5,75000.0f,25000);
		c.coding();
		//c.farming();
		//c.banking();
		
	}
}
