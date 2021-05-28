import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ChequeBook } from '../model/ChequeBook';
import { TransferRequest } from '../model/TransferRequest';
import { User } from '../model/User';

@Injectable({
  providedIn: 'root'
})
export class RequestServiceService {

  url = "http://ec2-54-152-96-255.compute-1.amazonaws.com:8086";

  constructor(private http : HttpClient) { }

  chequeBookRequests():Observable<ChequeBook[]>{

    return this.http.get<ChequeBook[]>(this.url+"/chequeBook")
  }

  confirmChequeBook(username:string):Observable<ChequeBook>{
    var data = {
      username : username,
    };

    return this.http.post<ChequeBook>(this.url+"/confirmChequeBook",data);
  }

  declineChequeBook(username:string):Observable<ChequeBook>{
    var data = {
      username : username,
    };

    return this.http.post<ChequeBook>(this.url+"/declineChequeBook",data);
  }

  allTransferRequests():Observable<TransferRequest[]>{
    return this.http.get<TransferRequest[]>(this.url+"/allTransferRequests");
  }


  confirmTransferRequest(username:string):Observable<User>{
    var data = {
      username : username,
    };

    return this.http.post<User>(this.url+"/confirmTransferRequest",data);
  }

  declineTransferRequest(username:string):Observable<User>{
    var data = {
      username : username,
    };

    return this.http.post<User>(this.url+"/declineTransferRequest",data);
  }

  
}
