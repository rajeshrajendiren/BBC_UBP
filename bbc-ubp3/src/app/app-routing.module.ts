import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ErrorPageComponent } from './error-page/error-page.component';
import { HeaderComponent } from './header/header.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { UnpaidbillComponent } from './unpaidbill/unpaidbill.component';

import { AuthGuard } from './auth-guard.service';

import { PayingComponent } from './paying/paying.component';
import { PaidBillComponent } from './paid-bill/paid-bill.component';
import { TransactionComponent } from './transaction/transaction.component';


const routes: Routes = [
  { path: "", redirectTo: "/login", pathMatch: "full" },
  { path: "login", component: LoginComponent },
  { path: "dashboard", component: DashboardComponent ,canActivate:[AuthGuard]},
  { path: 'unpaidbill', component: UnpaidbillComponent ,canActivate:[AuthGuard]},
  { path: 'paying', component: PayingComponent,canActivate:[AuthGuard]},
  { path: 'paidbill', component: PaidBillComponent ,canActivate:[AuthGuard]},
  { path: 'transaction', component: TransactionComponent,canActivate:[AuthGuard] },
  //{ path: 'wallet', component: WalletFormComponent },
  //{ path: 'upi', component: UpiFormComponent },





  { path: "**", component: ErrorPageComponent ,canActivate:[AuthGuard]},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
