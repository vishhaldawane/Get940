
public class StringTest {
	public static void main(String[] args) {
		String  name1=new String("Julia");
		String  name2=new String("Julia");
		
		System.out.println("name1 "+name1.hashCode());
		System.out.println("name2 "+name2.hashCode());
		
		StringBuffer name3=new StringBuffer("Julia");
		StringBuffer name4=new StringBuffer("Julia");
		
		System.out.println("name3 "+name3);
		System.out.println("name3 "+name3.hashCode());
		System.out.println("name4 "+name4.hashCode());
		
		name3.append("Robert");
		System.out.println("name3 "+name3);
		System.out.println("name3 "+name3.hashCode());
		
		
		StringBuilder name5=new StringBuilder("Julia");
		StringBuilder name6=new StringBuilder("Julia");
		
		System.out.println("name5 "+name5.hashCode());
		System.out.println("name6 "+name6.hashCode());
	}
}
