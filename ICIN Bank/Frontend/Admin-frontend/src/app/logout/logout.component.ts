import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private loginService : LoginService,
    private route : Router) { }

  ngOnInit(): void {
    this.loginService.logout();

    Swal.fire({
      icon: 'success',
      title: 'Successfully Logged Out',
      showConfirmButton: false,
      timer: 2000
    });
    this.route.navigate([""]);

  }

}
