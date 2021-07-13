public class Song implements Comparable<Song>
{
	private String title;
	private String artist;
	private String album;
	private int year;
	
	/*public int compareTo(Song anotherSong) //invoked by Collections.sort method
	{
		System.out.println("Comparing "+year+" with anotherSong's year "+anotherSong.year);
		return Integer.compare(year, anotherSong.year);
	}
			A  E  C		A  E  C
			65 69 67    65 69 67
			
				B-E = -3
						0
				E-B = +3
				
					
	*
	*/
	/*public int compareTo(Song anotherSong) //invoked by Collections.sort method
	{
		System.out.println("Comparing "+artist+" with anotherSong's artist "+anotherSong.artist);
		return artist.compareTo(anotherSong.artist);
		// -1 0 1  
	}*/
	
	public int compareTo(Song anotherSong) //invoked by Collections.sort method
	{
		System.out.println("Comparing "+title+" with anotherSong's title "+anotherSong.title);
		return anotherSong.title.compareTo(title); //not recursion
		// -1 0 1  
	}
	public Song(String title, String artist, String album, int year) {
		super();
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
	}
	@Override
	public String toString() {
		return "Song [title=" + title + ", artist=" + artist + ", album=" + album + ", year=" + year + "]";
	}
	
	
}