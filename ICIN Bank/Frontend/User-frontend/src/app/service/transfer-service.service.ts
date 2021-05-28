import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Transfer } from '../model/transferhistory';
import { TransferRequest } from '../model/TransferRequest';
import { User } from '../model/User';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class TransferServiceService {

  constructor(private http : HttpClient,
    private authService : AuthenticationService) { }

  url = "http://ec2-18-205-240-69.compute-1.amazonaws.com:8087";

  getTransfer():Observable<Transfer[]>{

    var data = {
      username : sessionStorage.getItem("user")+"",
    }
    return this.http.post<Transfer[]>(this.url+"/getTransfer",data);
  }

  transferRequest():Observable<TransferRequest>{

    var data = {
      username : sessionStorage.getItem("user")+"",
    }
    return this.http.post<TransferRequest>(this.url+"/transferRequest",data);
  }


  isAlreadyRequested():Observable<TransferRequest>{
    var data = {
      username : sessionStorage.getItem("user")+"",
    }
    return this.http.post<TransferRequest>(this.url+"/alreadyTransferRequested",data);
  }

  insertEntry(username:string, ifsc : string, saccount:number,raccount:string,amount:number) {
    var body = {
      username:sessionStorage.getItem("user"),
      ifsc:ifsc,
      saccount: saccount,
      raccount:raccount,
      amount:amount,
      date:this.authService.formatDate(new Date()),
    }
    console.log(body);
    return this.http.post(this.url + '/transferMoney', body);
  }

  isAccountPresent(accno:number):Observable<User>{
    var data = {
      accno : accno,
    };

    return this.http.post<User>(this.url+"/isAccountExist",data);
    
  }
}
