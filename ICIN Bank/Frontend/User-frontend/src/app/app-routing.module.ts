import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChequeBookRequestComponent } from './cheque-book-request/cheque-book-request.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
import { TransferBetweenAccountsComponent } from './transfer-between-accounts/transfer-between-accounts.component';
import { TransferHistoryComponent } from './transfer-history/transfer-history.component';
import { UserHistoryComponent } from './user-history/user-history.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:'register',component:RegisterComponent},
  {path:"cheque-book",component:ChequeBookRequestComponent},
  {path:"welcome",component:WelcomeComponent},
  {path:"transaction-history",component:UserHistoryComponent},
  {path:"transfer-history",component:TransferHistoryComponent},
  {path:"edit-profile",component:EditProfileComponent},
  {path:"log-out",component:LogoutComponent},
  {path:"transfer-funds",component:TransferBetweenAccountsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
