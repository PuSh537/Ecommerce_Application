
import { Component } from '@angular/core';
import { customerModel } from 'src/app/model/customerModel';
import { CustomerService } from 'src/app/service/customer.service';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css'],
})
export class CustomerComponent {
  constructor(private customerService: CustomerService) { }

  customer: any = {
    customerName: '',
    gender: '',
    contactNumber: '',
    email: '',
    username: '',
    password: '',
    role: '',
    address: {
      addressLine1: '',
      postalCode: '',
      city: '',
      state: '',
      country: '',
    },
  };
  submitted = false;
  onSubmit(customerForm: any) {
    this.submitted = true;
    console.log('outside valid--------', customerForm.value);
    const formValues = customerForm.value;
    const customerData: customerModel = {
      customerName: formValues.customerName,
      gender: formValues.gender,
      contactNumber: formValues.contactNumber,
      email: formValues.email,
      username: formValues.username,
      password: formValues.password,
      role: formValues.role,
      address: {
        addressLine1: formValues.addressLine1,
        postalCode: formValues.postalCode,
        city: formValues.city,
        state: formValues.state,
        country: formValues.country,
      },
    };

    this.customerService.addCustomer(customerData).subscribe(
      (resp) => {
        console.log('Customer added successfully:', resp);
        customerForm.resetForm();
        this.submitted = false;
      },
      (error) => {
        console.error('Error adding customer:', error);
      }
    );
  }
}
