class Kite
{
	//it can be preloaded - it would be created only once
	private static int kiteCount; // does not belong to an object of a Kite
//	|		|		|
// access qualifier dataType
//specifier
	public static int getKiteCount() { //does not belong to an object of a class Kite
		return kiteCount;
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
	public void kiteIsDown() {
		--kiteCount;
		flying = false;
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

	public static void main(String[] args) {
		//The field Kite.kiteCount is not visible
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

