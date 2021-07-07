
public class DataTypeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			     //0111 1111
		byte b1= 127; //( it is aware that it is a byte)
		
		System.out.println("b1 "+b1);
		
//	Type mismatch: cannot convert from int to byte
				//<--1----> <--1----> <--1----> <--1---->		
				//0000 0000 0000 0000 0000 0000 1000 0000 <--128
				//0000 0000 0000 0000 0000 0101 0100 0001 <-- 1345
		byte b2= (byte) 2150; //explicit DOWNcast
		System.out.println("b2 "+b2); // value is lost/ undefined
		
		//implicit cast - safe 
		byte b3 = 'A'; // converted character into a byte
		System.out.println("b3 "+b3); // value is lost/ undefined
		
		int i1 = 125; // IMPLICIT UPCAST - 125 is a byte and assigned to int
		
		boolean isRahulMarried=false; //age is 50
		System.out.println("isRahul Married : "+isRahulMarried);
		isRahulMarried=true;
		System.out.println("isRahul Married : "+isRahulMarried);
		
		String month1="January"; // IMMUTABLE STRING
		System.out.println("str1 : "+month1);
		System.out.println("str1 : "+month1.hashCode());
		month1="JANUARY"; //no overwrite at old place
					// infact is a new allocation for month1
		
		System.out.println("> str1 : "+month1);
		System.out.println("> str1 : "+month1.hashCode());
		
		String month2="January";
		System.out.println("str2 : "+month2);
		System.out.println("str2 : "+month2.hashCode());
		month2="january";
		System.out.println(">str2 : "+month2);
		System.out.println(">str2 : "+month2.hashCode());
		
		//final String carNumberPlate="MH-01-9873";
		//carNumberPlate="MH-01-1111"; //4 
	}
	

}
