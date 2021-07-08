class Phone
{
	void dial() {
		System.out.println("dialing to gf..");
	}
	void dial(byte b) {
		System.out.println("dialing to intecomm.."+b);
	}
	void dial(byte b1, byte b2) {
		System.out.println("dialing to intecomm..conference call "+b1+" with "+b2);
	}
	void dial(char b) {
		System.out.println("dialing to char .."+b);
	}
	void dial(int b) {
		System.out.println("dialing to int .."+b);
	}
	void dial(char b, int code) {
		System.out.println("dialing to char int.."+b+code);
	}
	void dial(int code,char b) {
		System.out.println("dialing to int..char "+b+code);
	}
}
public class FunctionOverloadingTest {
	public static void main(String[] args) {
		Phone p = new Phone();
		p.dial();
		p.dial(33);
		p.dial((byte)33, (byte)66);
		p.dial('+',91);
		p.dial('+',20);
	}
}
