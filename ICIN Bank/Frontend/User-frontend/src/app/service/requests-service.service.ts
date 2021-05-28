import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ChequeBook } from '../model/ChequeBook';
import { ChequeBookHistory } from '../model/ChequeBookHistory';
import { User } from '../model/User';
import { UserHistory } from '../model/UserHistory';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RequestsServiceService {

  constructor(private http : HttpClient,
    private authService:AuthenticationService) { }

  url = "http://ec2-18-205-240-69.compute-1.amazonaws.com:8087";

  chequeBookRequest(username:String,pages:number):Observable<ChequeBook>{

    var data = {
      username:username,
      pages:pages,
      date:this.authService.formatDate(new Date()),
    }

    console.log(data);

    return this.http.post<ChequeBook>(this.url+"/chequeBookRequest",data);
  }

  isAlreadyPresent(username:String):Observable<ChequeBook>{

    var data = {
      username:username,
    }

    console.log()
    console.log(data);
    return this.http.post<ChequeBook>(this.url+"/alreadyRequested",data);

  }

  getUserHistory():Observable<UserHistory[]>{
    var tempData = {
      username:sessionStorage.getItem("user")+"",

    }
    return this.http.post<UserHistory[]>(this.url+"/getUserHistory",tempData);
  }


  chequeBookHistory():Observable<ChequeBookHistory[]>{

    var data = {
      username : sessionStorage.getItem("user"),
    };

    return this.http.post<ChequeBookHistory[]>(this.url+"/chequebookhistory",data);
  }

  
}


