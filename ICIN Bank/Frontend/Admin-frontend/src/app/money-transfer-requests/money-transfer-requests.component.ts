import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { TransferRequest } from '../model/TransferRequest';
import { RequestServiceService } from '../service/request-service.service';

@Component({
  selector: 'app-money-transfer-requests',
  templateUrl: './money-transfer-requests.component.html',
  styleUrls: ['./money-transfer-requests.component.css']
})
export class MoneyTransferRequestsComponent implements OnInit {

  constructor(private requestService : RequestServiceService) { }

  transferRequestList:TransferRequest[] = [];
  ngOnInit(): void {

    this.requestService.allTransferRequests().subscribe(data => {
      this.transferRequestList = data;
    })

    this.isAnyTransferRequest();

  }

  confirm(username:string){
    this.requestService.confirmTransferRequest(username).subscribe(data => {
      if(data.transfer_access === false){
        Swal.fire({
          icon: 'error',
          title: 'Error occured ..',
          showConfirmButton: false,
          timer: 800
        })
      }else{
        Swal.fire({
          icon: 'success',
          title: 'Transfer Access Granted Successfully',
          showConfirmButton: false,
          timer: 800
        })
      }
      this.ngOnInit();
    })

    
  }

  decline(username:string){
    this.requestService.declineTransferRequest(username).subscribe(data => {
      if(data.transfer_access === false){
        Swal.fire({
          icon: 'success',
          title: 'Transfer Access request cancelled',
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

  isAnyTransferRequest(){
    return !(this.transferRequestList.length === 0);
  }

}
