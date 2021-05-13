import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { UserHistory } from '../model/UserHistory';
import { AuthenticationService } from '../service/authentication.service';
import { RequestsServiceService } from '../service/requests-service.service';

@Component({
  selector: 'app-user-history',
  templateUrl: './user-history.component.html',
  styleUrls: ['./user-history.component.css']
})
export class UserHistoryComponent implements OnInit {

  constructor(private requestService : RequestsServiceService,
    private authService : AuthenticationService,
    private route : Router) { }

    
  user:User = <User>{};

  transactionList:UserHistory[] = <UserHistory[]>[];

  ngOnInit(): void {

    if(!this.authService.isLoggedIn()){
      this.route.navigate([""]);
    }

    this.authService.setUser().subscribe(data => {
      this.user = data;
    });

    

    this.requestService.getUserHistory().subscribe(data => {
      this.transactionList = data;
    })
    

  }


}
