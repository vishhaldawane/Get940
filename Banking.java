// a public class must be saved in its own file
public class Banking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Banking Test..");
		
		//will have to create an object of BankAccount
		//          ref	allocator		ctor
		BankAccount ba = new 		BankAccount();
		
		ba.setBankAccount(101, "Julie", 500000);
			ba.showBankAccount();
			
		ba.withdraw(3000);
			ba.showBankAccount();
			
		ba.deposit(90000);
			ba.showBankAccount();
	}
}
class BankAccount
{
	int bankAccountNumber; //data member
	String bankAccountHolder; //data member
	double bankAccountBalance; //data member
	
	//member function
	void setBankAccount(int acno,String name,double bal)
	{
		System.out.println("Setting BankDetails...");
		bankAccountNumber=acno;
		bankAccountHolder=name;
		bankAccountBalance=bal;
	}
	
	//member function
	void showBankAccount() {
		System.out.println("ACNO : "+bankAccountNumber);
		System.out.println("NAME : "+bankAccountHolder);
		System.out.println("BAL  : "+bankAccountBalance);
	}
	
	//member function
	void withdraw(double amountToWithdraw) {
		System.out.println("Withdrawing...."+amountToWithdraw);
		bankAccountBalance =  bankAccountBalance - amountToWithdraw;
	}
	
	//member function
	void deposit(double amountToDeposit) {
		System.out.println("Depositing...."+amountToDeposit);
		bankAccountBalance =  bankAccountBalance + amountToDeposit;
	}
}