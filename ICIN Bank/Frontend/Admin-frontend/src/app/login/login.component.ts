import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../model/Admin';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit {

  constructor(private loginService : LoginService,
    private route : Router) { }

  ngOnInit(): void {
  }

  username = ""
  password = ""
  isValidLogin = false;
  errorMessage = "Please enter valid Credentials"

  handleLogin(){
    this.loginService.isValidLogin(this.username,this.password)
    .subscribe(data => {
      if(data === null){
        this.isValidLogin = true;
      }else{
        let admin:Admin = <Admin>data;
        sessionStorage.setItem("admin",admin.id+``);
        this.route.navigate(["users-info"])
      }
    })
  }
}
