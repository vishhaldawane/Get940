import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from './Employee';
//localhost:4200
@Component({
  selector: 'app-employee-management',
  templateUrl: './employee-management.component.html',
  styleUrls: ['./employee-management.component.css']
})
export class EmployeeManagementComponent implements OnInit {

  empno: number=0;
  allEmployees: Employee[] = [] ; // gloal variable available to all other methods + html
  tempEmployees: Employee[] =[] ; // gloal variable available to all other methods + html

  constructor(private empService: EmployeeService) { }

  ngOnInit(): void {
    console.log('ngOnInit called....');
    this.loadAllEmployees();
  } //end of ngOnInit

  loadAllEmployees() {
    console.log('Load all employees');
    this.empService.findAllEmployeeService().subscribe(
      (data: Employee[])=> 
      {
        this.allEmployees = data;
        this.tempEmployees = data; //copied into a temp array also
      }, 
      (err) => {
        console.log(err);
      }
    ); // invocation of the subscribe method
  }
  updateEmployeeArray() {
    if(this.empno == 0 ) {
      console.log('its zero' + this.empno);
      this.tempEmployees = this.allEmployees;
    }
    else {
      console.log('its NOT zero' + this.empno);
      this.tempEmployees = this.allEmployees.filter(e=>(e.employeeNumber == this.empno));
      console.log('length of tempEmployees : '+this.tempEmployees.length);
      console.log('length of allEmployees  : '+this.allEmployees.length);
    }
  }
  xdata: any;
  deleted: Boolean;
  deleteEmployee(eno: number) 
  {
    
    console.log('emp number to delete '+eno);
    this.empService.deleteEmployeeService(eno).
    subscribe((data:any) =>
    {
       this.xdata = data;
      console.log('log is' + data);
        if(data == null ) {
          this.deleted=true;
         // alert('record has been deleted');
          this.tempEmployees = this.allEmployees.filter(e=>(e.employeeNumber != eno));

          console.log('from deleteEmployee() '+ data); 
                    console.log(this.tempEmployees);
          this.allEmployees = this.tempEmployees;
          console.log('Employee deleted '+eno);
        }
      }, (err) => { 
          console.log(err + ' error '+this.xdata);
      });
     // if(this.deleted) {
        
      //}
      //this.loadAllEmployees();
      //window.location.reload();
    } //end of delete

}
