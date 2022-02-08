package com.bags;

import java.util.ArrayList;

public class GenericsTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	ArrayList list = new ArrayList(); //its a raw bag
	//	ArrayList<Integer> list = new ArrayList<Integer>(); //its NOT a raw bag
		
		//purchase  eggs, tomatoes, onions, chillies, jackfruit, potatoes
		
	//	list.add(10);
	//	list.add("str");
	//	list.add(30);
		
		
		GenericContainer<Integer> intContainer = new GenericContainer<Integer>(10, 20);
		intContainer.showGenericContainer();
		intContainer.swapGenericContainer();
		intContainer.showGenericContainer();
		
		System.out.println("---------");
		
		GenericContainer<Float> floatContainer = new GenericContainer<Float>(12.5f, 66.8f);
		floatContainer.showGenericContainer();
		floatContainer.swapGenericContainer();
		floatContainer.showGenericContainer();
		
		System.out.println("---------");
		
		GenericContainer<String> strContainer = new GenericContainer<String>("Robert","Juliet");
		strContainer.showGenericContainer();
		strContainer.swapGenericContainer();
		strContainer.showGenericContainer();
		
		System.out.println("---------");
		
		Song s1 = new Song("My Heart Will Go On", "Celine D", "Titanic", 1996);
		Song s2 = new Song("I want it that way","Backstreet Boys", "The Millenium", 1998);
	
		GenericContainer<Song> jukeBox = new GenericContainer<Song>(s1, s2);
		jukeBox.showGenericContainer();
		jukeBox.swapGenericContainer();
		jukeBox.showGenericContainer();
		
		
		
		
	}

}

//Template class

class GenericContainer<T> //Container - 
{
	private T x; //Content
	private T y; //Content
	
	GenericContainer(T i, T j) { //Container initialization
		System.out.println("GenericContainer() constructor...");
		x = i;
		y = j;
	}
	void showGenericContainer() { //Show the Contents of the Container..
		System.out.println("x "+x);
		System.out.println("y "+y);
	}
	
	void swapGenericContainer() { //Algorithm...To swap the Contents of the Container
		System.out.println("Swapping...T...");
		T temp=x;
		x=y;
		y=temp;
		System.out.println("Swapped...T...");
	}
}

