import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {
	public static void main(String[] args) {
		Song s1 = new Song("My Heart Will Go On", "Celine D", "Titanic", 1996);
		Song s2 = new Song("Zhingat", "Ajay Atul", "Sairat", 2016);
		Song s3 = new Song("I want it that way","Backstreet Boys", "Backstreet Boys", 1998);
		Song s4 = new Song("Kolavari", "Dhanush", "3", 2014);
		Song s5 = new Song("Lungi Dance", "Honey Singh","Chennai Express", 2019);
		
		List<Song> myJukeBox  = new ArrayList<Song>();
		myJukeBox.add(s1);myJukeBox.add(s2);myJukeBox.add(s3);
		myJukeBox.add(s4);myJukeBox.add(s5);
		
		Iterator<Song> songIterator =  myJukeBox.iterator();
		while(songIterator.hasNext()) {
			Song theSong = songIterator.next();
			System.out.println("Song : "+theSong);
		}
//The method sort(List<T>) in the type Collections is not 
//applicable for the arguments (ArrayList<Song>)
		
		System.out.println("Sorting...");
		Collections.sort(myJukeBox);
		System.out.println("Sorted...");
		
		songIterator =  myJukeBox.iterator();
		while(songIterator.hasNext()) {
			Song theSong = songIterator.next();
			System.out.println("Song : "+theSong);
		}
		
	}
}
