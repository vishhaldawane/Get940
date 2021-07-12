class Chess //developer is Hrutvik <-- busy with all math calcs 
{
	final void moveBishop() { // Camel
		System.out.println("The BlackColor Bishop is moving diagonal..bi-directional");
	}
	final void moveKnite() { // this is the final version of the method, no further filtering over it, no refinement, no one can hide it 
		System.out.println("The BlackColor Knite is moving in L Shape (2.5) anywhere...doing math calculations to find if checkmate or not");
	}
}
//final version of the class, no more children 
final class GraphicalChess extends Chess //<==Pradnya busy with GUI coding.. she want the math code from Hrutvik
{
	//overriding is the responsibility of the child class developer
	//overriding should honor the contract of the super class code
	
	//super class developer has no control over it
	
	void moveGUIKnite() { // overriding...for GUI coding - is she hiding the math logic?...YES
		super.moveKnite(); //this logic is for L shape maths
		System.out.println("+ The BlackColor Knite is graphically moving in any Shape (anysteps) ..");
	}
	void moveGUIBishop() {//Cannot override the final method from Chess
		super.moveBishop();
		System.out.println("Moving bishop anywhere");
	}
}
//The type ManMadeChess cannot subclass the final class GraphicalChess
class ManMadeChess extends GraphicalChess
{
	
}
//child knows java(C), banking(F) + farming(GF)

public class FinalClassTest {
	public static void main(String[] args) {
	//	Chess c = new GraphicalChess();
	//	c.moveGUIKnite();
		
		GraphicalChess gc = new GraphicalChess();
		gc.moveKnite(); //super constract
		gc.moveGUIKnite(); //explcit contract (out of contract coding here)
		
	}
}

/*
 * Doctor
 * |
 * Doctor or Surgeon 
 * |
 * Surgeon or HeartSurgeon 
 * 
	Universe is expanding....
	
	is last 20 years vs last 2000 years 
*/
