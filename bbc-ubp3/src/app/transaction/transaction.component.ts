import { Component, OnInit } from '@angular/core';
import { HttpserviceService } from '../httpservice.service';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styleUrls: ['./transaction.component.css']
})
export class TransactionComponent implements OnInit {
  transactions: any[] = [];
  constructor(private http: HttpserviceService) { }

  ngOnInit(): void {
    this.getTransaction(this.cusId);
  }
  cusId = sessionStorage.getItem("customerId")
  getTransaction(cusId: any) {
    this.http.getTransactions(cusId).subscribe((response: any) => {
      this.transactions = response;
    })
  }
}
