import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { User } from '../model/User';
import { AuthenticationService } from '../service/authentication.service';
import { TransferServiceService } from '../service/transfer-service.service';

@Component({
  selector: 'app-transfer-between-accounts',
  templateUrl: './transfer-between-accounts.component.html',
  styleUrls: ['./transfer-between-accounts.component.css']
})
export class TransferBetweenAccountsComponent implements OnInit {

  constructor(private formBuilder: FormBuilder,
    private route: Router,
    private transferService: TransferServiceService,
    private authService : AuthenticationService) { }

  user:User = <User>{};
  transferForm: FormGroup=<FormGroup>{};
  ifscError = false;
  submitted = false;

  private ifsc = "ICIN09030914";
  
  ngOnInit() {
    
    

    if(!this.authService.isLoggedIn()){
      this.route.navigate([""]);
    }

    this.authService.setUser().subscribe(data => {
      this.user = data;
    });

   var username:String=this.user.user_name;
   var accNo=this.user.accno;
   console.log(accNo)
   console.log(username)
   this.transferForm = this.formBuilder.group({
      username : username,
      saccountNo: accNo,
      ifscNo: ['', [Validators.required, Validators.minLength(8)]],
      raccountNo: ['', [Validators.required]],
      amount:['',[Validators.required]]
  
  });

}
get saccountno(): any {
  return localStorage.getItem('savingAccNo');
}
get fval() { return this.transferForm.controls; }

  transfer(){
    this.submitted = true;
    if (this.transferForm.invalid) {
      return;
    }
    const result:any = Object.assign({}, this.transferForm.value);
      
    try{
      this.transferService.insertEntry(result.username,result.ifscNo,this.user.accno,result.raccountNo,result.amount).subscribe(
        (data : any) =>{
         if(data.transferStatus==true){
          Swal.fire({
            icon: 'success',
            title: 'Transaction successful',
            text:data.responseMessage
          });
         }
         else{
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: data.responseMessage,
          })
         }
         }
       );
    }catch{
    }
      

  }
}
