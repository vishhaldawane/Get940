package com.bags;

public class GenericsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerContainer intContainer = new IntegerContainer(10, 20);
		intContainer.showIntegerContainer();
		intContainer.swapIntegerContainer();
		intContainer.showIntegerContainer();
		
		System.out.println("---------");
		
		FloatContainer floatContainer = new FloatContainer(12.5f, 66.8f);
		floatContainer.showFloatContainer();
		floatContainer.swapFloatContainer();
		floatContainer.showFloatContainer();
		
		System.out.println("---------");
		
		StringContainer strContainer = new StringContainer("Robert","Juliet");
		strContainer.showStringContainer();
		strContainer.swapStringContainer();
		strContainer.showStringContainer();
		
		System.out.println("---------");
		
		Song s1 = new Song("My Heart Will Go On", "Celine D", "Titanic", 1996);
		Song s2 = new Song("I want it that way","Backstreet Boys", "The Millenium", 1998);
	
		SongContainer jukeBox = new SongContainer(s1, s2);
		jukeBox.showSongContainer();
		jukeBox.swapSongContainer();
		jukeBox.showSongContainer();
		
		
		
		
	}

}
class IntegerContainer //Container
{
	private int x; //Content
	private int y; //Content
	
	IntegerContainer(int i, int j) { //Container initialization
		System.out.println("IntegerContainer() constructor...");
		x = i;
		y = j;
	}
	void showIntegerContainer() { //Show the Contents of the Container..
		System.out.println("x "+x);
		System.out.println("y "+y);
	}
	
	void swapIntegerContainer() { //Algorithm...To swap the Contents of the Container
		System.out.println("Swapping...ints...");
		int temp=x;
		x=y;
		y=temp;
		System.out.println("Swapped...ints...");
	}
}

class FloatContainer //Container
{
	private float x; //Content
	private float y; //Content
	
	FloatContainer(float i, float j) { //Container initialization
		System.out.println("FloatContainer() constructor...");
		x = i;
		y = j;
	}
	void showFloatContainer() { //Show the Contents of the Container..
		System.out.println("x "+x);
		System.out.println("y "+y);
	}
	
	void swapFloatContainer() { //Algorithm...To swap the Contents of the Container
		System.out.println("Swapping...floats...");
		float temp=x;
		x=y;
		y=temp;
		System.out.println("Swapped...floats...");
	}
}

class StringContainer //Container
{
	private String x; //Content
	private String y; //Content
	
	StringContainer(String i, String j) { //Container initialization
		System.out.println("StringContainer() constructor...");
		x = i;
		y = j;
	}
	void showStringContainer() { //Show the Contents of the Container..
		System.out.println("x "+x);
		System.out.println("y "+y);
	}
	
	void swapStringContainer() { //Algorithm...To swap the Contents of the Container
		System.out.println("Swapping...Strings...");
		String temp=x;
		x=y;
		y=temp;
		System.out.println("Swapped...Strings...");
	}
}

class SongContainer //ContainerjukeBox.showSongContainer();

{
	private Song x; //Content
	private Song y; //Content
	
	SongContainer(Song i, Song j) { //Container initialization
		System.out.println("SongContainer() constructor...");
		x = i;
		y = j;
	}
	void showSongContainer() { //Show the Contents of the Container..
		System.out.println("x "+x);
		System.out.println("y "+y);
	}
	
	void swapSongContainer() { //Algorithm...To swap the Contents of the Container
		System.out.println("Swapping...Songs...");
		Song temp=x;
		x=y;
		y=temp;
		System.out.println("Swapped...Songs...");
	}
}