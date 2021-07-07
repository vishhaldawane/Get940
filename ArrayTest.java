import java.util.ArrayList;

// BiggestBox greeting [ BiggerBox [ perfume ] [ Box [  choc[DiamondRing]olate ] ] ]

class MyInteger //primitive is acting as an Object
{
	int i; // int is hidden here inside a wrapper
	void set(int x) {		i = x;	}
	void print() {		System.out.println("i "+i);	}
	void increment() {		i++; 	}
}

public class ArrayTest {
	public static void main(String[] args) {
		BankAccount baRef = new BankAccount();
		baRef.setBankAccount(101, "Julia", 50000);
		baRef.showBankAccount();
		
		//ArrayList<Integer> mylist  = new ArrayList();
		
		MyInteger mi = new MyInteger();
		mi.set(100);
		mi.print();		mi.increment();
		mi.increment();		mi.increment();
		mi.print();
		
		Integer i = 100; // casting | autoboxing
		System.out.println("i "+i);
	}
}
