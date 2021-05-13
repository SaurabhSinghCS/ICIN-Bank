import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Transfer } from '../model/transferhistory';
import { User } from '../model/User';
import { AuthenticationService } from '../service/authentication.service';
import { TransferServiceService } from '../service/transfer-service.service';

@Component({
  selector: 'app-transfer-history',
  templateUrl: './transfer-history.component.html',
  styleUrls: ['./transfer-history.component.css']
})
export class TransferHistoryComponent implements OnInit {

  constructor(private authService : AuthenticationService,
    private route : Router,
    private transferService : TransferServiceService) { }

    transferList:Transfer[] = <Transfer[]>[]

    user:User = <User>{};

  ngOnInit(): void {

    if(!this.authService.isLoggedIn()){
      this.route.navigate([""]);
    }

    this.authService.setUser().subscribe(data => {
      this.user = data;
    });

    this.transferService.getTransfer().subscribe(data => {
      this.transferList = data;
    })

  }


  

}
