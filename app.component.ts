import { Component } from '@angular/core';
import { CurrencyConverterService } from './currency-converter.service';
import { FundTransferService } from './fund-transfer.service';
import { FundTransfer1Service } from './fund-transfer/fund-transfer1.service';

//in angular is it known as decorator |in java it is

@Component({ 
  selector: 'app-root', /*this would be the tag name*/ 
  template: '<button  class="{{b}}" (click)="goLike()">{{likes}}{{likeCounter}}</button>  <button class=dislikes (click)="goDisLike()" > {{dislikes}}{{disLikeCounter}} </button>', /* VIEW */
  styles: [
      `.likes {
          background-color: #4CAF50; /* Green */
          border: none;
          color: white;
          padding: 15px 32px;
          text-align: center;
          text-decoration: none;
          display: inline-block;
          font-size: 16px;
        }
        .liked {
          background-color: #4CAF50; /* Green */
          border: none;
          color: blue;
          padding: 15px 32px;
          text-align: center;
          text-decoration: none;
          display: inline-block;
          font-size: 16px;
        }

        .dislikes  {
          background-color: red; 
          border: none;
          color: white;
          padding: 15px 32px;
          text-align: center;
          text-decoration: none;
          display: inline-block;
          font-size: 16px;
        }
   `]
})
export class AppComponent {

  a: string="likes";
  b: string="liked";

  likeCounter: number=100;
  disLikeCounter: number=25;
  likes: string ="Likes";
  dislikes: string ="DisLikes";
  
  goLike() {
    console.log('like');
    this.likeCounter = this.likeCounter +1;
  }
  goDisLike() {
    console.log('dislike');
    this.disLikeCounter=this.disLikeCounter-1;
  }

  accountOpeningDate = new Date();
  showThis: boolean = false;
  canDialISD : boolean = true;
  num: number = 555;
  principal: number = 15000;
  rate: number = 4.5;
  years: number = 7;
  simpleInterest: number;

  //national scholarship portal   online finance
  
  myImageUrl="assets/images/head_first_java.jpg";

/*  <img src="assets/images/alexander_the_great.jpeg">
  <br>
  <img [src]="myImageUrl">  
  <br>
  <img src="{{myImageUrl}}">  */

  // <button (click)="calculate($event)"> CalculateIt</button> <-- html code 
  calculate($event) {
    this.simpleInterest = (this.principal * this.rate * this.years)/100;
    console.log("Calculate It is invoked....",$event);
    console.log("Calculate It is invoked....",this.simpleInterest);
    this.ccs.convert();
    this.ccs.findCurrency();
  }
  addPayee($event) { //regular function
    console.log('addPayee as a general function invoked..');
     //invoking service function
    this.fts.addPayeeService(); //notice this one ends with Service
  }
  viewPayee($event) { //regular function
    console.log('viewPayee as a general function invoked..');
     //invoking service function
    this.fts.viewPayeeService(); //notice this one ends with Service
  }

  viewAllPayees($event) { //regular function
    console.log('viewAllPayees as a general function invoked..');
     //invoking service function
    this.fts.viewAllPayeesService(); //notice this one ends with Service
  }

  deletePayee($event) { //regular function
    console.log('deletePayee as a general function invoked..');
     //invoking service function
     
     //can do something here too...
    this.fts.deletePayeeService() //notice this one ends with Service
    //can do something here too...
  }
  showAllPayees() {
    this.fts1.checkFunds();
  }
  constructor(private ccs: CurrencyConverterService 
    , private fts: FundTransferService, 
    private fts1: FundTransfer1Service ) { //constructor of the class
    this.savObj1.accountNumber =1000;
    this.savObj1.accountHolder="Suresh";
    this.savObj1.accountBalance=50000;

    this.savObj2.accountNumber =2000;
    this.savObj2.accountHolder="Dinesh";
    this.savObj2.accountBalance=60000;

    this.savObj3.accountNumber =3000;
    this.savObj3.accountHolder="Rajesh";
    this.savObj3.accountBalance=70000;

  }
  title = 'LTI Bank'; //DATA may be from the DBMS
  payeeName="Suresh";  fund = 10000;  balance = 50000;
  savObj1: SavingsAccount = new SavingsAccount();
  savObj2: SavingsAccount = new SavingsAccount();
  savObj3: SavingsAccount = new SavingsAccount();

  

  savAry: SavingsAccount[] = [
    {
        accountNumber:1001,
        accountHolder:"Paresh",
        accountBalance:30000,
        accountHolderAddress : {area:"Ram Mahal",street:"West Avenue",city:"Pune",pin:"401501",state:"Maharashtra"} 
    },
    {
        accountNumber:1002,
        accountHolder:"Ritesh",
        accountBalance:40000,
        accountHolderAddress : {area:"Raheem Manzil",street:"East Avenue",city:"Hyderabad",pin:"501501",state:"Telangana"}  
    },

    {
        accountNumber:1003,
        accountHolder:"Rutesh",
        accountBalance:50000,
        accountHolderAddress : {area:"Queens Palace",street:"South  Avenue",city:"Bangalore",pin:"601701",state:"Karnataka"} 
    },

    {
        accountNumber:1004,
        accountHolder:"Jayesh",
        accountBalance:60000, 
        accountHolderAddress : {area:"Joy Villa",street:"North Avenue",city:"Delhi",pin:"501801",state:"Chandigarh"}  
    },

    {
        accountNumber:1005,
        accountHolder:"Rakesh",
        accountBalance:70000, 
        accountHolderAddress : {area:"Happy Home",street:"Center Avenue",city:"Nagpur",pin:"405545",state:"Maharashtra"}  
    }
  ]

  
  cities: City[] = [
    {cityName : 'Mumbai', cityId:1 },
    {cityName : 'Chennai', cityId:2 },
    {cityName : 'Delhi', cityId:3 },
    {cityName : 'Kolkatta', cityId:4 },
    {cityName : 'Bangalore', cityId:5 },
    {cityName : 'Hyderabad', cityId:6 },
  ]
}
class City
{
  cityName:   string;
  cityId: number;
}
class Address {
  area : string;  street: string;  city : string;  pin : string;  state : string;
}
class SavingsAccount {
  accountNumber: number |undefined; //101
  accountHolder: string |undefined ; //Suresh
  accountBalance: number|undefined; //10000
  accountHolderAddress: Address; //hasA
}
/*{
        accountNumber:1005,        accountHolder:"Rakesh",        accountBalance:70000, 
        accountHolderAddress : 
        {area:"Happy Home",street:"Center Avenue",city:"Nagpur",pin:"405545",
        state:"Maharashtra"}  
    }

    class AppComponent <-- java style
    {
      private CurrenConverterService ccs ;
        AppComponent(CurrenConverterService x) {
          ccs = x;
        }
    }
    class AppComponent <-- angular  style
    {
      
        AppComponent(private ccs: CurrenConverterService) {
        
        }
    }
*/