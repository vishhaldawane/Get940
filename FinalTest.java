
//light is linear  - thoughts - non-linear 

class Star
{
	private final static double SPEED_OF_LIGHT=18600.519f;
	
}
class Circle
{
	private final static float PI=3.14f; //SHARABLE CONSTANT - universal constant
	private float radius;
	
	public Circle(float radius) {
		super();
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [PI=" + PI + ", radius=" + radius + "]";
	}

}
class MyCar //assuming these cars belong to the same ShowRoom
{
	private static String showRoomName ="Arihant Cars Ltd.";
	private final String numberPlate;  //immutable
	private final String modelName; //immutable
	private int numberOfKmsDriven; //mutable
	
	MyCar(String numberPlate, String modelName, int numberOfKmsDriven) {
		super();
		this.numberPlate = numberPlate;
		this.modelName = modelName;
		this.numberOfKmsDriven = numberOfKmsDriven;
	}
	@Override
	public String toString() {
		return "MyCar [numberPlate=" + numberPlate + ", modelName=" + modelName + ", numberOfKmsDriven="
				+ numberOfKmsDriven + "]";
	}
	public void drive(int kms) {
		System.out.println("Driving....");
		numberOfKmsDriven = numberOfKmsDriven + kms;
	}
	public void changeNumberPlate(String newNumberPlate) {
		System.out.println("Changing the number plate...");
//The final field MyCar.numberPlate cannot be assigned		
		//this.numberPlate = newNumberPlate;
	}
}

public class FinalTest {
	public static void main(String[] args) {
		
		Circle c1 = new Circle(10.2f);
		Circle c2 = new Circle(30.2f);
		Circle c3 = new Circle(40.2f);
		System.out.println("c1 "+c1);
		System.out.println("c2 "+c2);
		System.out.println("c3 "+c3);
		
		MyCar myCar1 = new MyCar("MH-01-AU-2300","Maruti Swift",5);
		MyCar myCar2 = new MyCar("TN-02-GU-3202","Honda City",3);
		MyCar myCar3 = new MyCar("DL-03-EU-5621","Toyota Innova",15);
		
		System.out.println("myCar1 "+myCar1);
		System.out.println("myCar2 "+myCar2);
		System.out.println("myCar3 "+myCar3);
		myCar1.drive(40);
		myCar2.drive(30);
		myCar3.drive(100);
		System.out.println("myCar1 "+myCar1);
		System.out.println("myCar2 "+myCar2);
		System.out.println("myCar3 "+myCar3);
		myCar3.changeNumberPlate("GJ-01-1234");

		System.out.println("myCar1 "+myCar1);
		System.out.println("myCar2 "+myCar2);
		System.out.println("myCar3 "+myCar3);
	}
}
