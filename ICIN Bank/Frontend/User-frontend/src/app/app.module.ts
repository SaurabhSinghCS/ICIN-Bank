import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { RegisterComponent } from './register/register.component';
import { ChequeBookRequestComponent } from './cheque-book-request/cheque-book-request.component';
import { ActivitesComponent } from './activites/activites.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { WelcomeComponent } from './welcome/welcome.component';
import { UserHistoryComponent } from './user-history/user-history.component';
import { TransferBetweenAccountsComponent } from './transfer-between-accounts/transfer-between-accounts.component';
import { TransferHistoryComponent } from './transfer-history/transfer-history.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { ChequeBookHistoryComponent } from './cheque-book-history/cheque-book-history.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    LoginComponent,
    LogoutComponent,
    RegisterComponent,
    ChequeBookRequestComponent,
    ActivitesComponent,
    WelcomeComponent,
    UserHistoryComponent,
    TransferBetweenAccountsComponent,
    TransferHistoryComponent,
    EditProfileComponent,
    ChequeBookHistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
