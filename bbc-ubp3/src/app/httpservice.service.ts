import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpserviceService {
  url: string = "http://localhost:8080/";
  constructor(private http: HttpClient) { }



  sendOtp(id: any) {
    return (this.http.get('http://localhost:8080/get-opt/' + id, { responseType: 'text' }))
  }


  verifyOtp(obj: any) {
    return (this.http.post("http://localhost:8080/login/verify", obj));

  }




 

  posterCreditCard(cusId:any,data:any){
    return this.http.post(`http://localhost:8080/pay/creditcard/${cusId}`,data, {responseType: 'text'});
  }
  posterDebitCard(cusId:any,data:any){
    return this.http.post(`http://localhost:8080/pay/debitcard/${cusId}`,data, {responseType: 'text'});
  }
  posterWallet(cusId:any,data:any){
    return this.http.post(`http://localhost:8080/pay/wallet/${cusId}`,data, {responseType: 'text'});
  }
  posterUpi(cusId:any,data:any){
    return this.http.post(`http://localhost:8080/pay/upiid/${cusId}`,data, {responseType: 'text'});
  }


  getTransactions(cusId:any){
    return this.http.get(`http://localhost:8080/get-by-customer/${cusId}`);


  }

  getCustomer(cusId:any){
    return this.http.get(`http://localhost:8080/get-customer/${cusId}`);
  }
  postBillData(context: any) {
    return this.http.post(`http://localhost:8080/pay/creditcard`, context, { responseType: 'text' });
  }
}
