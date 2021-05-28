import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/User';
import { Observable } from 'rxjs';
import { PandingUser } from '../model/pandinguser';
import { Result } from '../model/Result';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  user: User = <User>{};

  constructor(private http: HttpClient) { }

  valid = false;

  url = "http://ec2-18-205-240-69.compute-1.amazonaws.com:8087";

  isPendingUser(username: String, password: String): Observable<PandingUser> {
    var data = {
      username: username,
      password: password,
    }

    return this.http.post<PandingUser>(this.url + "/isUserPanding", data);
  }

  isUserPresent(username: String, password: String): Observable<User> {
    var data = {
      username: username,
      password: password,
    }
    return this.http.post<User>(this.url + "/validateLogin", data);
  }


  // checking whether user Logged in or not
  isLoggedIn() {
    return !(sessionStorage.getItem("user") === null);
  }



  setUser(): Observable<User> {
    var tempData = {
      username: sessionStorage.getItem("user") + "",

    }
    console.log(tempData)
    return this.http.post<User>(this.url + "/getUser", tempData);
  }

  logout() {
    let user = sessionStorage.removeItem('user');
  }

  register(data: PandingUser): Observable<PandingUser> {
    console.log(data);

    var tempData = {
      firstname: data.firstName,
      lastname: data.lastName,
      username: data.userName,
      dob: data.dob,
      address: data.address,
      email: data.email,
      password: data.password,
      kyctype: data.kycType,
      kycid: data.kycId,
    }

    console.log(tempData)
    return this.http.post<PandingUser>(this.url + "/registerUser", tempData);
  }


  isUnique(data: PandingUser): Observable<Result> {
    console.log(data);

    var tempData = {
      username: data.userName,
      kycid: data.kycId,
    }

    console.log(tempData)
    return this.http.post<Result>(this.url + "/isUnique", tempData);
  }

  formatDate(date: Date) {
    var d = new Date(date),
      month = '' + (d.getMonth() + 1),
      day = '' + d.getDate(),
      year = d.getFullYear();

    if (month.length < 2)
      month = '0' + month;
    if (day.length < 2)
      day = '0' + day;

    return [day, month, year].join('-');
  }

  //Update
  update(username: string, email: string, address: string, prevpassword: string, newpassword: string) {
    var body = {
      username: sessionStorage.getItem("user"),
      email: email,
      address: address,
      newpassword: newpassword
    }

    console.log(body);
    return this.http.post(this.url + '/updateUser', body);
  }

}
