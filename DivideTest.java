import java.util.InputMismatchException;
import java.util.Scanner;

public class DivideTest {
//DATA members may not be initialized
	public static void main(String[] args) {  
		System.out.println("Begin of main");
//The local variable str may not have been initialized
		try
		{
				//internally its a character array char *str="...";
			String str="Larsen and Tubro Infotech Limited"; //mandatory to initialize
			System.out.println("str : "+str.toUpperCase());
			System.out.println("str : "+str.toLowerCase());
			System.out.println("Length : "+str.length());
			System.out.println("character at 17 "+str.charAt(-17));
		}
		catch(NullPointerException e)
		{
			 System.out.println("Problem1 : "+e); //name of the exception + message associated with it
			//System.out.println(e.getMessage()); //only the message
			//e.printStackTrace();
		}
		catch(StringIndexOutOfBoundsException e) {
			System.out.println("Problem2 : "+e);
		}
		
		try
		{
			int score[]= {10,20,30};
			System.out.println("0 value "+score[0]);
			System.out.println("1 value "+score[1]);
			System.out.println("2 value "+score[2]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Problem : "+e.getMessage());
		}
		
		int x=0;
		try
		{
			Scanner scan = new Scanner(System.in);  //ctrl + shift + M
			System.out.println("Enter value for x : ");
			x=scan.nextInt();
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
		boolean isFileAopen=false;
		boolean isFileBopen=false;
		boolean isFileCopen=false;
		
		try
		{
			
			System.out.println("Is fileA open? "+isFileAopen);
			System.out.println("Is fileB open? "+isFileBopen);
			System.out.println("Is fileC open? "+isFileCopen);
			
			System.out.println("Lets open fileA");
			isFileAopen=true;
			System.out.println("Lets open fileB");
			isFileBopen=true;
			System.out.println("Lets open fileC");
			isFileCopen=true;
			
			System.out.println("Is fileA open? "+isFileAopen);
			System.out.println("Is fileB open? "+isFileBopen);
			System.out.println("Is fileC open? "+isFileCopen);
			
			
			System.out.println("Doing some operation with File A");
			
			if(x==10)
				throw new RuntimeException("some problem with File A while procesing...");
			
			System.out.println("Doing some operation with File B");
			
			if(x==20)
				throw new RuntimeException("some problem with File B while procesing...");
			
			if(x==30)
				throw new RuntimeException("some problem with File C while procesing...");
			
			System.out.println("Doing some operation with File C");
			
			System.out.println("Lets close the files");
			isFileAopen=false;
			isFileBopen=false;
			isFileCopen=false;
			
			System.out.println("Closing all files...");
			System.out.println("Is fileA open? "+isFileAopen);
			System.out.println("Is fileB open? "+isFileBopen);
			System.out.println("Is fileC open? "+isFileCopen);
			System.out.println("Closing successful...");
		}
		catch(RuntimeException e) {
			System.out.println("problem : "+e.getMessage());
		}
		finally {
			if(isFileAopen==true) {
				isFileAopen=false;
				System.out.println("file A is closed..by finally..");
			}
			if(isFileBopen==true) {
				isFileBopen=false;
				System.out.println("file B is closed..by finally..");
			}
			if(isFileCopen==true) {
				isFileCopen=false;
				System.out.println("file C is closed..by finally..");				
			}
			System.out.println("Finally : executes regardless of the exception...");
		}
		System.out.println("End of main");

	}

}
