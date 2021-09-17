
public class Test {
	public static void main(String[] args) {
		
		Rose rose = new Rose(); //tight coupling
		rose.flowering(); 
		
		Flower f1 = Garden.getFlower(); //loose coupling
		f1.flowering(); //still the default is Rose
		
		Flower f2 = Garden.getFlower("prayer"); //proper loose coupling
		f2.flowering();
		
	}
}
class Garden {
	static Flower getFlower () {
		return new Rose(); //default
	}
	
	static Flower getFlower (String hint) {
		Flower fl = null;
		if(hint.equals("valentine")) 
			fl = new Rose();
		else if(hint.equalsIgnoreCase("decorate")) 
			fl = new Lily();
		else if(hint.equalsIgnoreCase("prayer")) 
			fl = new Lotus();
		
		return fl;
	}
}
abstract class Flower
{
	abstract void flowering();
}
class Rose extends Flower {
	void flowering() {
		System.out.println("Rose is flowering...");
	}
}
class Lily extends Flower {
	void flowering() {
		System.out.println("Lily is flowering...");
	}
}
class Lotus extends Flower {
	void flowering() {
		System.out.println("Lotus is flowering...");
	}
}

/*
 
 						Threading  Framework
 						Collection Framework
						MVC Framework
			Hibernate - ORM Framework
								|
							semi developed application
							

		51 people
		|	
		your own car							uber,ola
		|										|
		buy a car								x
		buy the insurance | renew				x
		fuel | fuel station queue				x
		driving skill | licence | renew			x
		traffic signal | bill | challan			x
		speed control | speed limit				x
		1 hour - to office 						saved - self improvement
		1 hour - to home						saved - self improvement
		
												
		Washing Clothes							Laundry Facility
		|												|
		Pattern										framework	
		1. washing machine [buy]			1. array of washing machines [ heavy load ]
		2. washing powder [buy]				2. variety of washing powder, etc....
		3. water [ pay bill ]				3. hot water/cold water/soft water/hard water
		4. electricity [ pay bill ]			4. electricity load, 3 phase supply
		5. clothes							*5. clothes 
		6. process - washing programs		6. array of operations | dry cleaning
		wash(),rinse(),spin()						washing programs...silk, blanket,linen, cotton...jeans..
		7. dry it							7. dry it
		8. press it							8. press ...
		9. pack it							9. pack it
		10. store it in your storage		10. ready for delivery
		|
		30 mnts 45
		TIME MONEY ENERGY					TIME MONEY ENERGY
		
		
		develop
																	jenkins
		deploy it on github - eclipse plugin to Team->Share			webapp-packaging->webapp-deploying
		making a war - jar -cvf...
		deploy a war -> copy on tomcat
		
		you make your own linkedlist code						utilize the ready made class
			and add your object									LinkedList.class -> add(e);

				
		
			Hibernate ORM Framework
			
			
			Object		->		java class -> POJO -> Plin Old Java Object
			Relational	->		database table
			Model		->		way 
			
			
		class SavingsAccount
		{
				acno|name|balance;
				Address addr; //hasA
				Payee payeeList;
				Statement statement;
				..
				..
		}
		
		objects are not tables	| 	tables are not object
		
		
		SavingsAccount savObj = new SavingsAccount(101,"Julie",5000); <-- O
		
		Address address = new Address(100,"West Avenue","MP","India");
		savObj.setAddress(address);
		
		Payee thePayee = new Payee("Jack","123',"ICICI","ICICI72377");
		savObj.setPayee(thePayee);
		
		Statement st = new Statement("10-Aug-2020","Credit",7000);
		savObj.setStatement(st);
		
		PreparedStatement pst1 =conn.preparedStatement("insert into savings(?,?,?);
		pst1...fill the acno name balance
		
		PreparedStatement pst2 =conn.preparedStatement("insert into address(?,?,?,?,?);
		pst2...fill the house,street,state,country,acno_fk
		
		
		PreparedStatement pst3 =conn.preparedStatement("insert into payee(?,?,?,?,?);
		pst3...fill the payeename,acno,bank,ifsc, acno_fk
		
		PreparedStatement pst4 =conn.preparedStatement("insert into statement(?,?,?,?,?);
		pst4...fill the transdate,transtype,transamt, rembal, acnofk
		
		pst1.executeUpdate();
		pst2.executeUpdate();
		pst3.executeUpdate();
		pst4.executeUpdate();
		
		
		oracle
		---
		savings
		--------
		acno		name		balance		
		[101]			julie		5000
		
		address
		------
		house		street		state	country		acno_fk
		100			west avenue	mp		india		[101]
		
		payee
		------
		payeename	acno	bank	ifsc			acno_fk
		Jack		123		ICICI	ICICI72377		[101]
		
		statement
		----------
		trans_date	trans_type	trans_amout		rem_balance	acno_fk
		10-Aug-2020	Credit			7000		12000		[101]
		
		
		database
		|
		ORM / jdbc code - boiler plate code
		| 
		|			worldwide all the doctors using 1.boiler plate
		|				2.steralization process 
		|
		Your java application
		
		
		
				A Java Project
				|
			---------------
			|			|
			src			pom.xml <-- hibernate dependencies mentioned
			|
	-----------------------------------
	|			|			|
	main		test		resources
	|			|			|
	java		java		META-INF/persistence.xml
	|									|
	pojos						database driver/url/username/password
	SavingsAccount.class		and few hibernate settings
	Address.class
	Payee.class
	Statement.class
	Test program to try ORM
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		




*/