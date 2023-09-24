import { Component, OnInit } from '@angular/core';
import { HttpserviceService } from '../httpservice.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  otpGenerated: boolean = false; // Track whether OTP has been generated
  incorrect:string='';


  constructor(private service:HttpserviceService,
              private router:Router) { }

  ngOnInit(): void {
    document.body.className='bg_background';
  }



  onSubmit(id:number, otp:string) {
      let obj = {
        customerId: id,
        otp: otp
      };
    
      this.service.verifyOtp(obj)
      .subscribe((response: any) => {
    
        if (response.isValid) {
          sessionStorage.setItem("customerId", response.customer.customerId);
          console.log(response.customer.customerId);

          sessionStorage.setItem("customerDetail", response.customer);
          this.router.navigate(['/dashboard']);
        } else {
          this.incorrect = 'Invalid User'; 
        }
      },
      (error) => {
        console.error('incorrect OTP:', error);
        this.incorrect = 'Incorrect OTP. Please try again.';
      } );

  
  }
  


  generateOTP(id: number) {
    this.otpGenerated = true;

    this.service.sendOtp(id)
      .subscribe(
        (response: any) => {
          if (response != null) {
            console.log(response);
            window.alert("OTP for Login "+response)
          } else {
            this.incorrect = 'User does not exist.';
            console.log(response);
          }
        }
      );
  }
  


  ngOnDestroy(): void {
    document.body.className='';
  }

}
