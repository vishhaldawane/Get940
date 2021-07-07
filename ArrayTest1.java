import java.util.Iterator;

public class ArrayTest1 {
	public static void main(String[] args) {
		
		int score[]= {85,44,30,55,78,120};
		
		System.out.println("Size of the array : "+score.length);
		
		for (int i = 0; i < score.length; i++) {
			System.out.println("Score is : "+score[i]);
		}
//		float runRate[5]; //error
		
		
	//  array reference		allocation of the size
		float runRate[] = new float[15];
		runRate[0]=12.45f;
		runRate[1]=22.15f;
		runRate[4]=(float) 42.65;
		runRate[7]=62.75f;
		runRate[14]=32.45F;
		for (int i = 0; i < runRate.length; i++) {
			System.out.println(i+" RunRate : "+runRate[i]);
		}
		System.out.println("----object array----");
		
		//create 5 references 
		BankAccount allAccounts[] = new BankAccount[5];
		
		allAccounts[0] = new BankAccount();
		allAccounts[0].setBankAccount(101, "Julie",500000);
		
		allAccounts[1] = new BankAccount();
		allAccounts[1].setBankAccount(102, "Julia",600000);
		
		allAccounts[2] = new BankAccount();
		allAccounts[2].setBankAccount(103, "Robert",700000);
		
		allAccounts[3] = new BankAccount();
		allAccounts[3].setBankAccount(104, "Sonia",800000);
		
		allAccounts[4] = new BankAccount();
		
		for (int i = 0; i < allAccounts.length; i++) {
			System.out.println("---Showing Account---");
			allAccounts[i].showBankAccount();
			System.out.println("--------");
		}
		System.out.println("====");
		
		BankAccount allAccs[]= 
			{
				new BankAccount(),
				new BankAccount(),
				new BankAccount()
			};
		allAccs[0].setBankAccount(555, "Ramesh", 550000);
		allAccs[1].setBankAccount(666, "Haresh", 660000);
		allAccs[2].setBankAccount(777, "Jayesh", 770000);
		
		allAccs[0].showBankAccount();
		allAccs[1].showBankAccount();
		allAccs[2].showBankAccount();
	}
}

