import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authService : AuthenticationService,
    private route : Router) { }

  ngOnInit(): void {

    this.authService.logout();
    Swal.fire({
      icon: 'success',
      title: 'Successfully Logged Out',
      showConfirmButton: false,
      timer: 2000
    });
    this.route.navigate([""]);
  }

}
