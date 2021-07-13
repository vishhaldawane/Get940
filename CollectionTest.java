import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Creating the Container (Glass) ");
		Collection<Integer> myCollection = new ArrayList<Integer>();
		//Collection<Integer> myCollection = new LinkedList<Integer>();
		//Collection<Integer> myCollection = new TreeSet<Integer>();
		//Collection<Integer> myCollection = new HashSet<Integer>();
		System.out.println("Container (Glass) is ready");
		
		System.out.println("Now adding the content (ButterMilk) in the Container (Glass)..");
		myCollection.add(9);	myCollection.add(8);
		myCollection.add(12);	myCollection.add(5);
		myCollection.add(5); 	myCollection.add(9);
		myCollection.add(50);	myCollection.add(3);
		myCollection.add(7);	myCollection.add(45);
		myCollection.add(65);
		System.out.println("Content is added in the container...");
		
		System.out.println("Now Traversing the container...for which we need the Itarator..(Straw)");
		Iterator<Integer> myIterator = myCollection.iterator();
		
		while(myIterator.hasNext()) {
			Integer x= myIterator.next();
			System.out.println("Value is : "+x);
		}
		
	}

}
