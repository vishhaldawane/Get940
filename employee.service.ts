import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from './employee-management/Employee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  baseURL: string = 'http://localhost:8080/emps/' //Spring's EmployeeJPAController 
  
  constructor(private myhttp: HttpClient) { }

  findAllEmployeeService() : Observable<Employee[]> {
      return this.myhttp.get<Employee[]>(this.baseURL+"getAllEmps/");
  }

  deleteEmployeeService(empNo : number) : Observable<any> {//eno is copied here to empNo
    return this.myhttp.delete<any>(this.baseURL+"deleteEmp/"+empNo);
  }

}
/*
  
class ATM
{
  foo() {
    fun();
  }
  fun() {
    far();
  }
  far() {

  }
}
*/