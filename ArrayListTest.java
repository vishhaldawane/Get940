import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class AlbumComparator implements Comparator<Song>
{
	public int compare(Song o1, Song o2) {
		System.out.println("Comparing "+o1.getAlbum()+" with "+o2.getAlbum());
		return o1.getAlbum().compareTo(o2.getAlbum());
	}
}
class ArtistComparator implements Comparator<Song>
{
	public int compare(Song o1, Song o2) {
		System.out.println("Comparing "+o1.getArtist()+" with "+o2.getArtist());
		return o1.getArtist().compareTo(o2.getArtist());
	}
}
class TitleComparator implements Comparator<Song>
{
	public int compare(Song o1, Song o2) {
		System.out.println("Comparing "+o1.getTitle()+" with "+o2.getTitle());
		return o1.getTitle().compareTo(o2.getTitle());
	}
}
class YearComparator implements Comparator<Song>
{
	public int compare(Song o1, Song o2) {
		System.out.println("Comparing "+o1.getYear()+" with "+o2.getYear());
		return Integer.compare(o1.getYear(), o2.getYear());
	}
}
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
//	The method sort(List<T>) in the type Collections is not 
//applicable for the arguments (ArrayList<Song>)
		int choice=0;
		Scanner scan = new Scanner(System.in);
		Comparator<Song> cmp = null;
		do
		{
			System.out.println("Sort Menu");
			System.out.println("1. Sort by Album");
			System.out.println("2. Sort by Artist");
			System.out.println("3. Sort by Title");
			System.out.println("4. Sort by Year");
			System.out.println("Enter choice : ");
			choice = scan.nextInt();
			switch(choice) {
				case 1:	cmp = new AlbumComparator(); break;
				case 2:	cmp = new ArtistComparator(); break;
				case 3:	cmp = new TitleComparator(); break;
				case 4:	cmp = new YearComparator(); break;
				case 5:	break;
				default: System.out.println("Mismatched case...");
			}
			System.out.println("Sorting...");
			//	Collections.sort(myJukeBox); //Comparable is used
				Collections.sort(myJukeBox, cmp); //Comparator is used
				System.out.println("Sorted...");
				
				songIterator =  myJukeBox.iterator();
				while(songIterator.hasNext()) {
					Song theSong = songIterator.next();
					System.out.println("Song : "+theSong);
				}
				System.out.println("========================");
		} while(choice!=5);
		
		
		
		
	}
}
