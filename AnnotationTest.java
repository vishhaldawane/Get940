import java.lang.annotation.*;
import java.lang.reflect.Method;
@DesignedBy(designer="vishal")
@ProducedBy(company="LTI")
class SavingsAccount
{
	@FieldBy(provider="rita")
	float balance;  //<-- core field
	
	@MethodDevelopedBy(developer="Jack", version=4.0)
	public void withdraw(float amt) {
		System.out.println("Withdrawing..."+amt);
	}
}
public class AnnotationTest {

	public static void main(String[] args) {
		SavingsAccount sa = new SavingsAccount();
		Class classInfo = sa.getClass();
		Annotation anno [] = classInfo.getAnnotations();
		for (int i = 0; i < anno.length; i++) {
			System.out.println("Annotation is : "+anno[i]);
			DesignedBy db = (DesignedBy) anno[i];
			System.out.println("designer : "+db.designer());
			if(db.designer().equals("vishal")) {
				System.out.println("Loading the class....");
			}
			else {
				System.out.println("Not ready to load the class....");
			}
		}
		
		Method allMethods [] = classInfo.getMethods();
		for (int i = 0; i < allMethods.length; i++) {
			Method method = allMethods[i];
			//System.out.println("method name : "+method);
			Annotation methodAnnos [] = method.getAnnotations();
			for (int j = 0; j < methodAnnos.length; j++) {
				Annotation annotation = methodAnnos[j];
				//System.out.println("Method anno is "+annotation);
				if(annotation instanceof MethodDevelopedBy) {
					MethodDevelopedBy mdb = (MethodDevelopedBy) annotation;
					System.out.println("Method developer : "+mdb.developer());
					System.out.println("Method version   : "+mdb.version());
					if(mdb.version()==4.0) {
						System.out.println("Invoking the method...");
					}
					else {
						System.out.println("method version is not ready for upload......");
					}
				}
			}
		}
		
		//every instance of an "Object class" got a method
		//called as "getClass()" that returns an instance
		//of "class Class"
	}

}
