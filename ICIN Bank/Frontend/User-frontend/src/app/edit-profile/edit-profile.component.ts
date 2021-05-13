import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { User } from '../model/User';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

  user:User = <User>{};

  constructor(
    private formBuilder: FormBuilder,
    private route: Router,
    private authService : AuthenticationService) { }

  updateForm: FormGroup = <FormGroup>{};
  loading = false;
  submitted = false;

  isPasswordInCorrect = false;


  ngOnInit() {

    if(!this.authService.isLoggedIn()){
      this.route.navigate([""]);
    }

    this.authService.setUser().subscribe(data => {
      this.user = data;
    });

    this.updateForm = this.formBuilder.group({
      address:[this.user.address],
      email: [this.user.email, [Validators.email]],
      prevpassword: ["", [Validators.minLength(6)]],
      password:['',[Validators.minLength(6)]]

  });
  }
  get fval() { return this.updateForm.controls; }

  update(){
    this.submitted = true;
    // return for here if form is invalid
    if (this.updateForm.invalid) {
      return;
    }
    const result:User= Object.assign({}, this.updateForm.value);
    // if(this.user.password === this.updateForm.value.prevpassword){
      console.log(this.updateForm.value.prevpassword);
      console.log(result);
    // }
    this.loading = true;

    if(this.user.password === this.updateForm.value.prevpassword){
        
        try{
          this.authService.update(this.user.user_name,result.email,result.address,result.password,result.password).subscribe(
            (data : any) =>{
              // localStorage.clear();
              // localStorage.setItem('user',JSON.stringify(data));
              console.log(data);
              this.loading=false;
              if(data.transferStatus==true){
                Swal.fire(
                  {
                    icon: 'success',
                    title: 'Profile updated successfully!',
                    text:data.responseMessage
                  }
                )
                this.route.navigate(["logout"]);
              }else{
                Swal.fire({
                  icon: 'error',
                  title: 'Oops...',
                  text: data.responseMessage,
                })
              }
              this.route.navigate(['/editProfile']);
    
            }
          );
        }catch{
          this.loading=false;
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: "Something went wrong!"
          })
        }
      }else{
        this.loading = false;
      }
        
  }
}