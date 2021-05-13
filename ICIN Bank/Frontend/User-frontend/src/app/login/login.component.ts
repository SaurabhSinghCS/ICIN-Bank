import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';
import Swal from 'sweetalert2';
import { CompileShallowModuleMetadata } from '@angular/compiler';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private authservice: AuthenticationService,
    private route: Router) { }

  ngOnInit(): void {

    if(this.authservice.isLoggedIn()){
      this.route.navigate(["welcome"]);
    }
  }

  username = ""
  password = ""
  isValidLogin = false
  errorMessage = "Invalid Credentials"
  credentialsMessage = ""

  handleLogin() {
    if(this.username === "" || this.password === ""){

      this.credentialsMessage = "All credentials are required"
      
    }else{

    this.authservice.isPendingUser(this.username, this.password)
      .subscribe(data => {
        if (data === null) {
          this.validLogin();
        } else {
          Swal.fire({
            icon: 'error',
            title: 'Sorry Your account is not activated yet',
            showConfirmButton: false,
            timer: 1000
          });
        }
      })

            
    }

  }


  validLogin() {
    this.authservice.isUserPresent(this.username, this.password)
      .subscribe(data => {
        if (data === null) {
          Swal.fire({
            icon: 'error',
            title: 'Sorry no User Exist Please Register First',
            showConfirmButton: false,
            timer: 2000
          });

          this.route.navigate(["register"]);
        } else {
          if (data.password === this.password) {
            if(data.blocked === true){
              Swal.fire({
                icon: 'error',
                title: 'Your account is blocked please contact to your nearest branch',
                showConfirmButton: false,
                timer: 2000
              });
            }else{
              console.log(data)
              Swal.fire({
                icon: 'success',
                title: 'Successfully Logged In',
                showConfirmButton: false,
                timer: 2000
              });
              sessionStorage.setItem("user",data.user_name);
              this.authservice.user = data;
              this.route.navigate(["welcome"]);
            }
          }
          else {
            this.isValidLogin = true;
          }
        }
      })
  }

}
