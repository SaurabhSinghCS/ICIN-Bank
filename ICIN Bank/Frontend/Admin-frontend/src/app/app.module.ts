import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BlockedUsersComponent } from './blocked-users/blocked-users.component';
import { UsersAccountInfoComponent } from './users-account-info/users-account-info.component';
import { ChequeBooksRequestComponent } from './cheque-books-request/cheque-books-request.component';
import { RegisterationRequestsComponent } from './registeration-requests/registeration-requests.component';
import { MoneyTransferRequestsComponent } from './money-transfer-requests/money-transfer-requests.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    LogoutComponent,
    BlockedUsersComponent,
    UsersAccountInfoComponent,
    ChequeBooksRequestComponent,
    RegisterationRequestsComponent,
    MoneyTransferRequestsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
