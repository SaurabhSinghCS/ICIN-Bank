import { Component, OnInit } from '@angular/core';
import { ChequeBookHistory } from '../model/ChequeBookHistory';
import { RequestsServiceService } from '../service/requests-service.service';

@Component({
  selector: 'app-cheque-book-history',
  templateUrl: './cheque-book-history.component.html',
  styleUrls: ['./cheque-book-history.component.css']
})
export class ChequeBookHistoryComponent implements OnInit {

  constructor(private requestService : RequestsServiceService) { }

  chequeBookList:ChequeBookHistory[] = [];

  ngOnInit(): void {

    this.requestService.chequeBookHistory().subscribe(data => {
      console.log(data);
      this.chequeBookList = data;
    })
  }

  isAnyBook(){
    return !(this.chequeBookList.length === 0);
  }

  // ind = 1;

}
