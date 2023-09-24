import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { HttpserviceService } from '../httpservice.service';
@Component({
  selector: 'app-paid-bill',
  templateUrl: './paid-bill.component.html',
  styleUrls: ['./paid-bill.component.css']
})
export class PaidBillComponent implements OnInit {
  bills:any[] = [];
  cusId = sessionStorage.getItem("customerId");
  constructor(private http:HttpserviceService,private route:Router,private http1:HttpClient) { }

  ngOnInit(): void {
    this.http1.get(`http://localhost:8080/fetch-paid-bills/${this.cusId}`).subscribe((data:any)=>{
      this.bills=data;
       
      
    
    })

}
}
