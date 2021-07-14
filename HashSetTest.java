import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

class Book
{
	int  bookNumber;
	String bookName;
	float bookPrice;

	public Book(int bookNumber) {
		super();
		this.bookNumber = bookNumber;
	}

	public Book(int bookNumber, String bookName, float bookPrice) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "Book [bookNumber=" + bookNumber + ", bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + bookNumber;
		result = prime * result + Float.floatToIntBits(bookPrice);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookNumber != other.bookNumber)
			return false;
		if (Float.floatToIntBits(bookPrice) != Float.floatToIntBits(other.bookPrice))
			return false;
		return true;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public float getBookPrice() {
		return bookPrice;
	}

	


	
	
}
class Tiger { }

public class HashSetTest {
	public static void main(String[] args) {
		Book b1 = new Book(101,"Java8",1200.0f);
		Book b2 = new Book(102,"Java9",1200.0f);
		Book b3 = new Book(103,"Java11",1200.0f);
		Book b4 = b1;
	//	Book b5 = null;
	//	Book b6 = null;
		System.out.println("Book are ready....");
		
		HashSet<Book> myBookShelf = new HashSet<Book>();
		System.out.println("Book shelf is ready....");
		
		System.out.println("Adding books to the bookShelf....");
		myBookShelf.add(b1);//referring equals+hashcode of Book
		myBookShelf.add(b2);//referring equals+hashcode of Book
		myBookShelf.add(b3);//referring equals+hashcode of Book
		myBookShelf.add(b4);
		//myBookShelf.add(b5);
		//myBookShelf.add(b6);
		//myBookShelf.add((Book) new Tiger());
		System.out.println("Books are added to the Shelf..");
		Iterator<Book> bookIterator = myBookShelf.iterator();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Which book number to search : ");
		int number = scan.nextInt();

		boolean found=false;
		
		while(bookIterator.hasNext()) {
			Book theBook = bookIterator.next();
			
			if(theBook.getBookNumber()==number ) {
				System.out.println("Found it..");
				System.out.println("The Book : "+theBook);
				found=true;
				break;
			}
		}
		if(found==false) {
			System.out.println("Not found..."+number);
		}
	}
}
