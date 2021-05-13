import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ChequeBook } from '../model/ChequeBook';
import { User } from '../model/User';
import { AuthenticationService } from '../service/authentication.service';
import { RequestsServiceService } from '../service/requests-service.service';

@Component({
  selector: 'app-cheque-book-request',
  templateUrl: './cheque-book-request.component.html',
  styleUrls: ['./cheque-book-request.component.css']
})
export class ChequeBookRequestComponent implements OnInit {

  constructor(private requestService: RequestsServiceService,
    public authService: AuthenticationService,
    private route: Router) { }

    user:User = <User>{}

  ngOnInit(): void {

    if(!this.authService.isLoggedIn()){
      this.route.navigate([""]);
    }

    this.authService.setUser().subscribe(data => {
      this.user = data;
    });

    this.requestService.isAlreadyPresent(sessionStorage.getItem("user")+"").subscribe(data => {
      if (data === null) {
        this.alreadyRequested = false;
      } else {
        this.alreadyRequested = true;
      }
    });
    
  }

  alreadyRequested = false;

  pages = [
    { name: "20", value: 20 },
    { name: "50", value: 50 },
    { name: "75", value: 75 }
  ]

  page = 0;

  pageError = false;

  chequeBook: ChequeBook = <ChequeBook>{};

  request() {

    if(this.page === 0){
      this.pageError = true;
      this.ngOnInit();
    }else{

    this.requestService.chequeBookRequest(sessionStorage.getItem("user")+"", this.page)
      .subscribe(data => {
        if (data !== null) {
          Swal.fire({
            icon: 'success',
            title: 'Successfully Requested for Cheque Book',
            showConfirmButton: false,
            timer: 1000
          });
          this.route.navigate(["welcome"]);
        }

      })
    }

  }

}
