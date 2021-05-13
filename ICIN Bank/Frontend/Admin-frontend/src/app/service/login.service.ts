import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http : HttpClient) { }

  valid = false;

  url = "http://localhost:8084/validateLogin";
  isValidLogin(username : String,password:String){
    var data = {
      username : username,
      password : password
    }

    return this.http.post(this.url,data);
  }

  changeValidity(){
    this.valid = true;
  }

  isLoggedIn(){
    return sessionStorage.getItem("admin");
  }

  logout(){
    let user = sessionStorage.removeItem('admin');
  }

}
