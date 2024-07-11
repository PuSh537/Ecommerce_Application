import { Component } from '@angular/core';
import { adminModel } from 'src/app/model/adminModel';
import { AdminService } from 'src/app/service/admin.service';

@Component({
  selector: 'app-add-admin',
  templateUrl: './add-admin.component.html',
  styleUrls: ['./add-admin.component.css'],
})
export class AddAdminComponent {

  newAdmin: any;
  
  constructor(private adminService: AdminService) {  }
    adAdmin: any = {
      adminName: '',
      email: '',
      phoneNumber: '',
      username: '',
      password: '',
      joiningDate: '',
      role: ''
    };

  addAdmin(adminForm: any) {
   // this.newAdmin.role = 'admin';

    const formValues = adminForm.value;
    const adminData: adminModel = {

    adminID: formValues.adminID,
    adminName: formValues.adminName,
      phoneNumber: formValues.phoneNumber,
      email: formValues.email,
      username: formValues.username,
      password: formValues.password,
      role: formValues.role,
      joiningDate: formValues.joiningDate
    };

    console.log(this.newAdmin);
    this.adminService.addAdmin(adminData).subscribe(res=>{
      console.log(res);
      this.newAdmin = res; 
      alert("Admin added successfully!");
    })
  }
}
