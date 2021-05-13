import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/User';
import { LoginService } from '../service/login.service';
import { UsersServiceService } from '../service/users-service.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-blocked-users',
  templateUrl: './blocked-users.component.html',
  styleUrls: ['./blocked-users.component.css']
})
export class BlockedUsersComponent implements OnInit {

  user:User[] = []
  constructor(private userService : UsersServiceService,
    private loginService : LoginService,
    private route : Router) { }

  ngOnInit(): void {
    if(!this.loginService.isLoggedIn()){
      this.route.navigate([""]);
    }
    this.userService.getUsers().subscribe(data => {
      this.user = data;
    });

    this.isUsersDeactivated();
  }

  enable(id: number){
    this.userService.unBlock(id).subscribe(data => {
      this.user = data
      data.forEach(element => {
        if(element.id === id){
          if(element.blocked === false){
            Swal.fire({
              icon: 'success',
              title: 'Users account enabled successful',
              showConfirmButton: false,
              timer: 700
            })
          }else{
            Swal.fire({
              icon: 'error',
              title: 'Sorry Users account is not Enables',
              showConfirmButton: false,
              timer: 700
            })
          }
        }
      });
      
    })

    this.ngOnInit();

      

  }

  isUsersDeactivated(){
    return this.user.some(element => element.blocked === true)
  }



}
