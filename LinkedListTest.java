import java.util.Iterator;
import java.util.LinkedList;

class Contact //implements Comparable
{
	String contactName;
	String mobileNumber;
	String emailAddress;
	public Contact(String contactName, String mobileNumber, String emailAddress) {
		super();
		this.contactName = contactName;
		this.mobileNumber = mobileNumber;
		this.emailAddress = emailAddress;
	}
	@Override
	public String toString() {
		return "Contact [contactName=" + contactName + ", mobileNumber=" + mobileNumber + ", emailAddress="
				+ emailAddress + "]";
	}
	
	
}
public class LinkedListTest {
	public static void main(String[] args) {
		Contact ctx1 = new Contact("Dinesh M", "9822334455", "dinesh@lti.com");
		Contact ctx2 = new Contact("Majrul A", "8877334455", "majrul@lti.com");
		Contact ctx3 = new Contact("Simant", "7722884455", "simant@lti.com");
		
		LinkedList<Contact> myPhoneBook = new LinkedList<Contact>();
		
		myPhoneBook.add(ctx1);
		myPhoneBook.add(ctx2);
		myPhoneBook.add(ctx3);
		
		Iterator<Contact> phoneBookIterator = myPhoneBook.iterator();
		while(phoneBookIterator.hasNext()) {
			Contact theCtx = phoneBookIterator.next();
			System.out.println("theCtx : "+theCtx);
		}
		
		
		
	}
}
