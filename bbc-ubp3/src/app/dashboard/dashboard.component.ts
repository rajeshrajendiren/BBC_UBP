import { Component, OnInit } from '@angular/core';
import { HttpserviceService } from '../httpservice.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
 
  cusid:any = sessionStorage.getItem('customerId')
  customer:any;
 
  

  
  constructor(
    private http:HttpserviceService

  ) { }

  ngOnInit(): void {

    console.log(this.cusid);
  }

  getCustomer(){
    this.http.getCustomer(this.cusid).subscribe(
    (res:any)=>{
      this.customer=res;
    }
    )



  }



}
