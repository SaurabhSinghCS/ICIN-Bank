import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { User } from '../model/User';
import { AuthenticationService } from '../service/authentication.service';
import { TransferServiceService } from '../service/transfer-service.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor(private authService : AuthenticationService,
    private route : Router,
    private transferService : TransferServiceService) { }

  user:User = <User>{};
  ngOnInit(): void {

    this.user = this.authService.user;
    if(!this.authService.isLoggedIn()){
      this.route.navigate([""]);
    }

    this.authService.setUser().subscribe(data => {
      console.log("data start")
      console.log(data);
      this.user = data;
      console.log(this.user);
      console.log("user end")
    });

    this.transferService.isAlreadyRequested().subscribe(data => {
      console.log("holla")
      console.log(data);
      if(data === null){
        this.isrequest = false;
      }
    })

  }

  transferRequest(){

    this.transferService.transferRequest().subscribe(data => {
      if(data === null){
        Swal.fire({
          icon: 'error',
          title: "Oops ... \nSorry not Requested",
          showConfirmButton: false,
          timer: 1000
        });
      } else{
        Swal.fire({
          icon: 'success',
          title: "Seccessfully Requested Please Wait for some time",
          showConfirmButton: false,
          timer: 1000
        });
      }
      this.ngOnInit()
    });
    
  }

  isrequest = true;

  
  
}
