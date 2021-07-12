// 8.45 reporting  16:30wind up sat sun holiday

//pure abstract 
interface Instrument // strict version of an abstract class
{
	void use(); //by default public and abstract
	
}

abstract class MusicalInstrument implements Instrument// 
{
	abstract void playMusic(); //to mandate some contract on the child
	
}
//abstract child of abstract parent
abstract class StringBasedMusicalInstrument extends MusicalInstrument
{
	abstract void tuneStrings(); // super class contract is forwarded here
	
	void fun() { //non-abstract 
		System.out.println("fun of strings......");
	}
	void moreFun() {
		System.out.println("moreFun of strings......");
	}
}
//concrete class of an abstract hierarchy

//The type Guitar must implement the inherited abstract method 
//MusicalInstrument.playMusic()

//The type Guitar must implement the inherited abstract method 
//StringBasedMusicalInstrument.tuneString()

//The type Guitar must implement the inherited abstract method 
//Instrument.use()
class Guitar extends StringBasedMusicalInstrument
{
	void playMusic() { //MANDATORY : implemented method from grand parent
		System.out.println("Playing guitar....");
	}
	void tuneStrings() { //MANDATORY : implemented method from parent
		System.out.println("Tuning the guitar..strings....");
	}
	void pluck() { //exclusive method
		System.out.println("Plucking guitar.....ting ting....");
	}
	void moreFun() { //inherited - cum - overridden
		System.out.println("moreFun of guitar strings......");
	}
}

//The type Violin must implement the inherited abstract method 
//Instrument.use()
class Violin extends StringBasedMusicalInstrument
{
	void playMusic() { //MANDATORY : implemented method from grand parent
		System.out.println("Playing Violin....");
	}
	void tuneStrings() { //MANDATORY : implemented method from parent
		System.out.println("Tuning the Violin..strings....");
	}
	void bowing() { //exclusive method
		System.out.println("Bowing violin.........");
	}
	void moreFun() { //inherited - cum - overridden
		System.out.println("moreFun of violin strings......");
	}
}
class Cello extends Violin 
{
	void bowingThickerStrings() {
		System.out.println("Bowing thicker strings...of the Cello...");
	}
}
class ElectronicGuitar extends Guitar
{
	void supplyThePower() {
		System.out.println("Supplying power to the Electronic Guitar....");
	}
	void presetOfGuitar() {
		System.out.println("Selecting presets of the Guitar....");
	}
}

public class AbstractTest {

	public static void main(String[] args) {
		Guitar g = new Guitar();
		g.pluck(); //exclusive method - I
		g.fun(); //inherited function - II
		g.moreFun();// inherited - cum- overridden - III
		g.playMusic(); //mandate : implemented function - IV
		g.tuneStrings(); //mandate : implemented function - IV
		System.out.println("================");
		
		ElectronicGuitar eg = new ElectronicGuitar();
		eg.supplyThePower();
		eg.pluck();
		eg.fun();
		eg.moreFun();
		eg.playMusic();
		eg.tuneStrings();
		eg.presetOfGuitar();
		System.out.println("================");
		
		Violin v = new Violin();
		v.playMusic();
		v.moreFun();
		v.fun();
		v.tuneStrings();
		v.bowing();
		System.out.println("================");
		
		Cello c = new Cello();
		c.playMusic();
		c.tuneStrings();
		c.moreFun();
		c.fun();
		c.bowingThickerStrings();
		c.bowing();
		
		
		
		

	}

}
