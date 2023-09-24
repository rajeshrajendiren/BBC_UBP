import { Component, OnInit } from '@angular/core';
import { HttpserviceService } from '../httpservice.service';

@Component({
  selector: 'app-paying',
  templateUrl: './paying.component.html',
  styleUrls: ['./paying.component.css']
})
export class PayingComponent implements OnInit {
  isCreditCardSelected: boolean = false;
  isUpiSelected: boolean = false;
  isWalletSelected: boolean = false;
  customerId = sessionStorage.getItem("customerId");

  constructor(private http:HttpserviceService) { }

  ngOnInit(): void {
  }

  selectPaymentMethod(paymentMethod: string) {
    // Set the selected payment method and hide others
   if( this.isCreditCardSelected = paymentMethod === 'credit-card'){}
    this.isUpiSelected = paymentMethod === 'upi';
    this.isWalletSelected = paymentMethod === 'wallet';
  }
  bills: any[] = []
  amount!: any;


  postCreditCardData(cardnumber:string,date:string,cvc:any,ownername:string) {

    console.log("testttt")
   
    this.amount = sessionStorage.getItem("amount");
    console.log(this.amount);
  
    const billStr = sessionStorage.getItem("bills");
    if (billStr) {
      this.bills = JSON.parse(billStr);
    }
  
    let paymentData: any = {
      amount: this.amount,
      creditCard: {
        creditCardNumber:cardnumber,
        cardHolderName:ownername,
        expirydate:date,
        cvv:cvc
    },
      bills: this.bills
    }
    this.http.posterCreditCard(this.customerId,paymentData).subscribe
    (
      (response)=>{
        console.log(response);
      }
    )
  
 

    }
    postUpiData(upiId:any){
    
      this.http.posterUpi(this.customerId,upiId).subscribe
      (
        (response)=>{
          console.log(response);
        }
      )
  
    }
    postWalletData(wallet:any){
      this.http.posterWallet(this.customerId,wallet).subscribe
      (
        (response)=>{
          console.log(response);
        }
      )
    }
  }
  



