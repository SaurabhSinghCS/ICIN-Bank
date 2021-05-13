import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { PandingUser } from '../model/pandinguser';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private formBuilder : FormBuilder,
    private authService : AuthenticationService) { }

    submitted = false;

    identityType = [
      { name: "Aadhar Card", value:"Aadhar"},
     { name: "PAN card", value:"Pancard"},
     { name: "Passport", value:"Passport"},
     { name: "Voter Id Card", value: "Voter" }
   ];
  ngOnInit() {

    this.registerForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      userName: ['', Validators.required],
      dob: ['', Validators.required],
      address: ['', Validators.required],
      email: ['',[Validators.required,Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      kycType:['', Validators.required],
      kycId:['', Validators.required],

  });

  }

  get fval() { return this.registerForm.controls; }

  registerForm: FormGroup = this.formBuilder.group({});


  isUnique(){

    const result:PandingUser= Object.assign({}, this.registerForm.value);

    // result.dob = this.authService.formatDate();


    this.authService.isUnique(result).subscribe(data => {
      if(data.unique === true){
        this.register(result);
      }else{
        Swal.fire({
          icon: 'error',
          title: data.message,
          showConfirmButton: false,
          timer: 1000
        });
      }
    });
  }
  register(result:PandingUser){

    this.authService.register(result).subscribe(data => {
      if(data === null){
        Swal.fire({
          icon: 'error',
          title: 'Registration failed Please try again later',
          showConfirmButton: false,
          timer: 1000
        });
      }else{
        Swal.fire({
          icon: 'success',
          title: 'Successfully Registered wait for activations',
          showConfirmButton: false,
          timer: 1000
        });
      }

    });
    
  }

}
