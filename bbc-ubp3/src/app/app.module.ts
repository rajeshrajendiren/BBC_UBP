import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { UnpaidbillComponent } from './unpaidbill/unpaidbill.component';
import { HttpClientModule } from '@angular/common/http';




import { HttpserviceService } from './httpservice.service';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { PayingComponent } from './paying/paying.component';
import { PaidBillComponent } from './paid-bill/paid-bill.component';
import { TransactionComponent } from './transaction/transaction.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    UnpaidbillComponent,
  
  
   
    LoginComponent,
    ErrorPageComponent,
    DashboardComponent,
    PayingComponent,
    PaidBillComponent,
    TransactionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  exports: [RouterModule],
  providers: [HttpserviceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
