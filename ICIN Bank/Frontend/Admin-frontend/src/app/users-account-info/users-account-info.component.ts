import { Component, OnInit } from '@angular/core';
import { User } from '../model/User';
import { UsersServiceService } from '../service/users-service.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
import { componentFactoryName } from '@angular/compiler';
import { element } from 'protractor';

@Component({
  selector: 'app-users-account-info',
  templateUrl: './users-account-info.component.html',
  styleUrls: ['./users-account-info.component.css']
})
export class UsersAccountInfoComponent implements OnInit {

  user:User[] = []
  constructor(private userService : UsersServiceService,
    private route:Router) { }

  ngOnInit(): void {
    this.userService.getUsers().subscribe(data => {
      this.user = data;
      console.log(data)
      console.log(this.user);
    });

    this.isUsersDeactivated();
  }


  disable(id: number){
    this.userService.block(id).subscribe(data => {
      this.user = data
      data.forEach(element => {
        if(element.id === id){
          if(element.blocked === false){
            Swal.fire({
              icon: 'success',
              title: 'Sorry Users account is not Disabled',
              showConfirmButton: false,
              timer: 1000
            })
          }else{
            Swal.fire({
              icon: 'success',
              title: 'Users account disabled successfully',
              showConfirmButton: false,
              timer: 1000
            })
          }
          return;
        }
      });
      
    })

    this.ngOnInit();
    
  }

  isUsersDeactivated(){
    return this.user.some(element => element.blocked === false)
  }

}
