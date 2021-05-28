`use strict`
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { PandingUser } from '../model/PandingUser';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class UsersServiceService {

  constructor(private http : HttpClient) { }

  url = "http://ec2-54-152-96-255.compute-1.amazonaws.com:8086";
  getUsers():Observable<User[]>{
    return this.http.get<User[]>(this.url+"/allUsers");
  }

  unBlock(id:number):Observable<User[]>{
    var dataId = {
      id:id
    }
    return this.http.post<User[]>(this.url+"/unblock",dataId);
  }


  block(id:number):Observable<User[]>{
    var dataId = {
      id:id
    }
    return this.http.post<User[]>(this.url+"/block",dataId);
  }

  confirmUser(username:string):Observable<User>{
    var data = {
      username : username,
    };

    return this.http.post<User>(this.url+"/confirmUser",data);
  }

  declineUser(username:string):Observable<PandingUser>{
    var data = {
      username : username,
    };

    return this.http.post<PandingUser>(this.url+"/declineUser",data);
  }


  getAllPandingUsers():Observable<PandingUser[]>{
    return this.http.get<PandingUser[]>(this.url+"/getAllPandingUsers");
  }


  formatDate(date:Date) {
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

  
}
