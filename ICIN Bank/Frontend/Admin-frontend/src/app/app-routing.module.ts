import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BlockedUsersComponent } from './blocked-users/blocked-users.component';
import { ChequeBooksRequestComponent } from './cheque-books-request/cheque-books-request.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MoneyTransferRequestsComponent } from './money-transfer-requests/money-transfer-requests.component';
import { RegisterationRequestsComponent } from './registeration-requests/registeration-requests.component';
import { UsersAccountInfoComponent } from './users-account-info/users-account-info.component';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"logout",component:LogoutComponent},
  {path:"users-info",component:UsersAccountInfoComponent},
  {path:"cheque-book-requests",component:ChequeBooksRequestComponent},
  {path:"money-transfer-requests",component:MoneyTransferRequestsComponent},
  {path:"blocked-users",component:BlockedUsersComponent},
  {path:"waiting-users",component:RegisterationRequestsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
