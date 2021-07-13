class SpeedLimitException extends RuntimeException //isA - unchecked
{
	SpeedLimitException(String str) {
		super(str);
	}
}
class RedSignalDisHonouredException extends RuntimeException //unchecked
{
	RedSignalDisHonouredException(String str) {
		super(str);
	}
}
class InsurancePaperException extends Exception //checked type
{
	InsurancePaperException (String str) {
		super(str);
	}
}

class Car
{
	void startCar() {
		//drive();
	}
//throws - method acquired a qualification to throw that type of exception (checked)  
	void drive() throws InsurancePaperException
	{
		double myMemory=Math.random()%10;
		if(myMemory>0.75) {
			System.out.println("Insurance papers are upto date...");
		}
		else {
			//literally throwing it 
			throw new InsurancePaperException("What is the status of the insurance paper? ...dont know...");
		}
		System.out.println("Drive started...");
		for(int i=1;i<=25;i++) {
			double value = Math.random()%10;
			System.out.println("Drive covered..."+i+"kms"+value);
			
			if(value>0.95) { //if the car speed is above 95
				SpeedLimitException spe = new SpeedLimitException("Car has crossed the speed limit...."+value);
				throw spe;
			}
			if(value >= 0.88 && value <= 0.90) {
				throw new RedSignalDisHonouredException("Oh No!! Red Signal got dishonoured...");
			}
			
			
			
		}
		System.out.println("Drive finished...");
	}
}
public class CustomExceptionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main started...");
		try
		{
				Car myCar = new Car();
				myCar.drive();
		}
		
//Unreachable catch block for RedSignalDisHonouredException. 
	//It is already handled by the catch block for Exception
		
		catch(RedSignalDisHonouredException e) {
			System.out.println("Handler1 : "+e.getMessage());
		}
		catch(SpeedLimitException e) {
			System.out.println("Handler2 : "+e.getMessage());
		}
		catch(InsurancePaperException e) {
			System.out.println("Hanlder3 : "+e.getMessage()); 
		}
		catch(RuntimeException e) {
			System.out.println("Handler4 : "+e.getMessage());
		}
		catch(Exception e) {
			System.out.println("Handler5 : "+e.getMessage());
		}
		System.out.println("Main over...");
	}

}
