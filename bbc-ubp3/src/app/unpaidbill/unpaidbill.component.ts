import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { HttpserviceService } from '../httpservice.service';
declare var $: any;

@Component({
  selector: 'app-unpaidbill',
  templateUrl: './unpaidbill.component.html',
  styleUrls: ['./unpaidbill.component.css']
})




export class UnpaidbillComponent implements OnInit {
  bills:any[] = [];
  selectedBills:any[]=[];
  isSelected=true;
  selectedRows: Set<any> = new Set();
  total!:string;
  cusId = sessionStorage.getItem("customerId")
  amount:any=0;
  constructor(private http:HttpserviceService,private route:Router,private http1:HttpClient) { }

  ngOnInit(): void {
    this.http1.get(`http://localhost:8080/fetch-unpaid-bills/${this.cusId}`).subscribe((data:any)=>{
      this.bills=data;
       console.log(this.bills);
      
    
    })
   
  }
  onSelect(row:any)
    {
      if (this.selectedRows.has(row)) {
        console.log(this.selectedRows)
        this.selectedRows.delete(row);
      } else {
        this.selectedRows.add(row);
       
      }
      console.log(this.selectedRows.entries)
      
}

onTotal() {
  if (this.selectedRows.size !== 0) {
    this.amount = 0;

    for (let bill of this.selectedRows) {
      this.amount += bill.unitConsumption * 41.50;
    }

    // Store the amount and selected bills in sessionStorage
    sessionStorage.setItem("amount", this.amount.toString());
    sessionStorage.setItem("bills", JSON.stringify(Array.from(this.selectedRows)));
  }
}

  onClear(){
    for (let bill of this.selectedRows) {
      this.selectedRows.delete(bill);
    };
  }
  onPay(){
    console.log(this.selectedRows)
    this.route.navigateByUrl("/paying")

  }


}
