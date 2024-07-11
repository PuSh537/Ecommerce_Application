import { Component } from '@angular/core';
import { SellerModel } from 'src/app/model/sellerModel';
import { SellerService } from 'src/app/service/seller.service';

@Component({
  selector: 'app-seller-register',
  templateUrl: './seller-register.component.html',
  styleUrls: ['./seller-register.component.css']
})
export class SellerRegisterComponent {
  constructor(private sellerService: SellerService) { }

  // sellerId:number;
  //   sellerName:string;
  //   businessName:string;
  //   phoneNumber:string;
  //   email:string;
  //   address:string;
  //   sellingDomain:string;
  //   username:string;
  //   password:string;
  //   role:string;
  seller: any = {
    sellerName: '',
    businessName: '',
    phoneNumber: '',
    email: '',
    address:'',
    sellingDomain: '',
    username: '',
    password: '',
    role: '',
    
  };
  submitted = false;
  onSubmit(sellerForm: any) {
    this.submitted = true;
    console.log('outside valid--------', sellerForm.value);
    const formValues = sellerForm.value;
    const sellerData: SellerModel = {
      sellerName: formValues.sellerName,
      businessName: formValues.businessName,
      phoneNumber: formValues.phoneNumber,
      email: formValues.email,
      address: formValues.address,
      sellingDomain: formValues.sellingDomain,
      username: formValues.username,
      password: formValues.password,
      role: formValues.role,
      sellerId: 0
    };

    this.sellerService.addSeller(sellerData).subscribe(
      (resp) => {
        console.log('seller added successfully:', resp);
        sellerForm.resetForm();
        this.submitted = false;
      },
      (error) => {
        console.error('Error adding seller:', error);
      }
    );
  }

}
