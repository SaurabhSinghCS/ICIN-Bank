import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { PandingUser } from '../model/PandingUser';
import { UsersServiceService } from '../service/users-service.service';

@Component({
  selector: 'app-registeration-requests',
  templateUrl: './registeration-requests.component.html',
  styleUrls: ['./registeration-requests.component.css']
})
export class RegisterationRequestsComponent implements OnInit {

  constructor(private userService : UsersServiceService) { }

  pandingusers : PandingUser[] = <PandingUser[]>[]
  ngOnInit(): void {

    this.userService.getAllPandingUsers().subscribe(data => {
      console.log(data)
      this.pandingusers = data;
      console.log(this.pandingusers)
      for(let i=0;i<this.pandingusers.length;i++){

        var date = new Date(this.pandingusers[i].dob);
        this.pandingusers[i].dob = this.userService.formatDate(date);
      }
    })
  }

  confirm(username:string){
    this.userService.confirmUser(username).subscribe(data => {
      if(data === null){
        Swal.fire({
          icon: 'error',
          title: 'Error occured ..',
          showConfirmButton: false,
          timer: 700
        })
      }else{
        Swal.fire({
          icon: 'success',
          title: 'Users Account Confirmed Successfully',
          showConfirmButton: false,
          timer: 700
        })
      }
      this.ngOnInit();
    })

    
  }

  decline(username:string){
    this.userService.declineUser(username).subscribe(data => {
      if(data === null){
        Swal.fire({
          icon: 'success',
          title: 'Users account Canceled successfully',
          showConfirmButton: false,
          timer: 700
        })
      }else{
        Swal.fire({
          icon: 'error',
          title: 'Error occured ..',
          showConfirmButton: false,
          timer: 700
        })
      }
      this.ngOnInit();
    })

  }

  isPandingUser(){
    return !(this.pandingusers.length === 0);
  }

}
