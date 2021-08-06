
public class Greeting {
	public static void main(String[] args) {
		
		System.out.println("Greeting");
		
	}
}



/*

marriage ceremony

		|		keep welcoming new guest
		at the gate - Front Controller - invitation card
		You					|
					---------------------------------------------------------------------------
					|			|				|					|					|
			  SeatController  FoodController  IcecreamController  ReceptionController PhotoGrapherController
		you got the seat

	MVC
	
				  emp <-- table -LAYER1 
					|
		DATA - Employee - pojo - LAYER2
		|					
		JPA - EmployeeRepository  LAYER3		ORM
		|
		Model   			View - jsp pages/html 		
	
												LAYER 4 - SERVICE

	GET		POST		PUT		DELETE	
	|		|			 |			|
	|		new record  update	delete
	get a single
	get multiple records
@Controller
@RequestMapping("/employees")
EmployeeController 
			|
		spring web mvc framework - FrontController
		
		
http://localhost:8080/bidder/getBids
http://localhost:8080/employees/updateEmp
http://localhost:8080/employees/getAllEmps
http://localhost:8080/employees/addEmp
http://localhost:8080/employees/deleteEmp
...25 URLS

browser  browser  browser - LAYER 6 - localhost:4200
ng generate service Employee -> EmployeeService - getEmployee() {
			|Show Bids| ->	http.get("http://localhost:8080/getBids"....);
			|List Crops|			
PNR		  EMPNO		ACNO
*/