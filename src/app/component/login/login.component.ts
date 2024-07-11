import { Component, OnInit, NgModule  } from '@angular/core';
import { LoginService } from 'src/app/service/login.service';
import { LocalStorageService } from 'src/app/service/local-storage.service';
import { loginModel } from 'src/app/model/loginModel';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  loginRequest: loginModel = new loginModel();
  response: any;


  constructor(
    private jwtService:LoginService,
    private localStorageService: LocalStorageService,
    private router: Router,
  ){}
  ngOnInit(): void {
    this.localStorageService.clear();
  }

  username: string = '';
  password: string = '';
  role:string ='';
  readFormData(formData: any) {

    console.log("------------------Login--1----",formData.form.value);
    
    this.loginRequest.username = formData.form.value.username;
    this.loginRequest.password = formData.form.value.password;
    this.getAccessToken(this.loginRequest);
    // const responseData=JSON.parse(this.response);
    // this.role=responseData.data.role;
    
    
  }
  getAccessToken(authRequest: loginModel) {
    console.log("---Login.ts--2--", authRequest);
    
    this.jwtService.getGeneratedToken(authRequest).subscribe((resp)=>{
      console.log(resp);
       this.response= resp;
       const responseData=JSON.parse(this.response);
     // const token=resp.
      //console.log("tokenavalue"+token);
      this.role = responseData.data.role;
      this.localStorageService.setItem("adminId",responseData.data.adminID );

      if(this.role==="admin"){
        // this.localStorageService.setItem("token", this.token);
        // this.localStorageService.setItem("adminId", this.response.data.adminID);
        // this.localStorageService.setItem("adminName", this.response.data.adminName);
        
        this.router.navigate(['/adminDashboardHeader']);
      }
      if(this.role==="seller"){
        // this.localStorageService.setItem("token", this.token);
        // this.localStorageService.setItem("sellerId", this.response.data.sellerId);
        // this.localStorageService.setItem("sellerPhoneNumber", this.response.data.phoneNumber);
        this.router.navigate(['/sellerDashboard']);
      }
      if(this.role==="customer"){
        // this.localStorageService.setItem("token", this.token);
        // this.localStorageService.setItem("customerId", this.response.data.customerId);
        // this.localStorageService.setItem("customerName", this.response.data.customerName);
        // this.localStorageService.setItem("contactNumber", this.response.data.contactNumber);
        // this.localStorageService.setItem("email", this.response.data.email);
        // this.localStorageService.setItem("role", this.response.data.role);
        // this.localStorageService.setItem("address", this.response.data.address);
        // this.localStorageService.setItem("CartId", this.response.data.cartId);
        // this.localStorageService.setItem("username", this.response.data.username);
        this.router.navigate(['/customerDashboard']);
        // this.router.navigate([{outlets:{customerOutlet:['/customer-main']}}]);
        // this.router.navigate([{ outlets: { customerOutlet: ['customer'] } }]);
  
  
      }
      
    })
  }

}
