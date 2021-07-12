import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideTest {

	public static void main(String[] args) {  
		System.out.println("Begin of main");
		Scanner scan = new Scanner(System.in);  //ctrl + shift + M
	
		try
		{
			System.out.println("Enter value for x : ");
			int x=scan.nextInt();
			System.out.println("x : "+x);
		
			System.out.println("Enter value for y : ");
			int y=scan.nextInt();
			System.out.println("y : "+y);
		
			System.out.println("dividing...");
			float z = x/y; //explicit casting
			System.out.println("z : "+z);
		}
		catch(ArithmeticException e) {
			System.out.println("Problem: Cannot divide by zero...");
		}
		catch(InputMismatchException e) {
			System.out.println("Please supply proper number...");
		}
//browser -> google.com   google welcome page OR page not found OR internal server error, 
		/*
		if(y!=0) { //BL
			System.out.println("dividing...");
			float z = x/y; //explicit casting
			System.out.println("z : "+z);
		} 
		else { //EL
			System.out.println("Cannot divide by zero....");
		}
		*/
		
	
		//let there would be x having a value	in<-finite
		//y z a b c 
		
		//3.14 or 22/7
		
		System.out.println("End of main");

	}

}
