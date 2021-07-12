class Kite
{
	//it can be preloaded - it would be created only once
	private static int kiteCount; // does not belong to an object of a Kite
//	|		|		|
// access qualifier dataType
//specifier
	public static int getKiteCount() { //does not belong to an object of a class Kite
//Cannot make a static reference to the non-static field kiteLength		
		//kiteLength=100;
		return kiteCount;
	}
	public static void setKiteCount(int kiteCount) {
		//Cannot use this in a static context
		Kite.kiteCount = kiteCount;
	}
	private String kiteColor;
	private String kiteOwner;
	private int kiteLength;
	private boolean flying; //false
	
	public Kite(String kiteColor, String kiteOwner, int kiteLength) {
		super();
		System.out.println("Kite(...) constructor ....");
		this.kiteColor = kiteColor;
		this.kiteOwner = kiteOwner;
		this.kiteLength = kiteLength;
		fly(true); //constructor and fly is wired now 
	}
	private void fly(boolean flyingStatus) {
		flying = flyingStatus;
		++kiteCount; //pre increment
	}
	public void kiteIsDown() { // A NON STATIC FUNCTION
		--kiteCount; // REFER STATIC
		flying = false; // REFER NON-STATIC
		System.out.println(kiteOwner+"'s "+kiteColor+" color kite is down now");
	}
	
	@Override
	public String toString() {
		return "Kite [kiteColor=" + kiteColor + ", kiteOwner=" + kiteOwner + ", kiteLength=" + kiteLength + ", flying="
				+ flying + "]";
	}
}
//int Kite::kiteCount=10 ;// in C++
//out of 69 i found - 
public class KiteTest {
	static int x; //static is permitted on data member, not on local x 
	
	public void fun() {
		int x=10; //local variable - NOT A DATA MEMBER OF A CLASS
		System.out.println("fun(): x "+x);
	}
	public static void brotherOfMain() {
		int x=10; //local variable - NOT A DATA MEMBER OF A CLASS
		System.out.println("brotherOfmain(): x "+x);
	}
	public static void main(String[] args) {
//Illegal modifier for parameter x; only final is permitted
		//KiteTest.brotherOfMain(); //direct call from one static function to other static function
		/*static*/ int x=10; //local variable - NOT A DATA MEMBER OF A CLASS
		
		System.out.println("main(): x "+x);
		brotherOfMain(); //direct call from one static function to other static function
		KiteTest.brotherOfMain(); //call via ClassName  from one static function to other static function
		
		KiteTest kt = new KiteTest();
		kt.fun();
		
		//The field Kite.kiteCount is not visible
		Kite.setKiteCount(10);
		System.out.println("Total kites :  "+Kite.getKiteCount());
		Kite k1 = new Kite("Red","Rita",50); //physical object 
		Kite k2 = new Kite("Yellow","Julie",40); //physical object
		Kite k3 = new Kite("Green","Ritesh",30); //physical object
		System.out.println("Total kites :  "+Kite.getKiteCount());
		Kite k4 = new Kite("Black","Rakesh",20); //physical object
		System.out.println("Total kites :  "+Kite.getKiteCount());
		
		System.out.println("k1 "+k1);
		System.out.println("k2 "+k2);
		System.out.println("k3 "+k3);
		System.out.println("k4 "+k4);
		
		k1.kiteIsDown();//business method
		k1=null; // telling java that no more interest in k1
		k3.kiteIsDown(); //business method
		k3=null;
		
		System.out.println("Total kites :  "+Kite.getKiteCount());
		
		System.out.println("k1 "+k1);
		System.out.println("k2 "+k2);
		System.out.println("k3 "+k3);
		System.out.println("k4 "+k4);
	
	}
}

