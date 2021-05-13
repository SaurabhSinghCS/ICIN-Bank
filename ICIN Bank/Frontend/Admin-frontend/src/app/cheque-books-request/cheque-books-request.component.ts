import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { ChequeBook } from '../model/ChequeBook';
import { RequestServiceService } from '../service/request-service.service';

@Component({
  selector: 'app-cheque-books-request',
  templateUrl: './cheque-books-request.component.html',
  styleUrls: ['./cheque-books-request.component.css']
})
export class ChequeBooksRequestComponent implements OnInit {

  constructor(private requestService : RequestServiceService) { }

  chequeBookList:ChequeBook[] = [];
  ngOnInit(): void {

    this.requestService.chequeBookRequests().subscribe(data => {
      this.chequeBookList = data;
    })
  }

  confirm(username:string){
    this.requestService.confirmChequeBook(username).subscribe(data => {
      if(data !== null){
        Swal.fire({
          icon: 'error',
          title: 'Error occured ..',
          showConfirmButton: false,
          timer: 800
        })
      }else{
        Swal.fire({
          icon: 'success',
          title: 'Users Account Confirmed Successfully',
          showConfirmButton: false,
          timer: 800
        })
      }
      this.ngOnInit();
    })

    
  }

  decline(username:string){
    this.requestService.declineChequeBook(username).subscribe(data => {
      if(data === null){
        Swal.fire({
          icon: 'success',
          title: 'Users account Canceled successfully',
          showConfirmButton: false,
          timer: 800
        })
      }else{
        Swal.fire({
          icon: 'error',
          title: 'Error occured ..',
          showConfirmButton: false,
          timer: 800
        })
      }
      this.ngOnInit();
    })

  }

  isAnyBook(){
    return !(this.chequeBookList.length === 0);
  }

}
