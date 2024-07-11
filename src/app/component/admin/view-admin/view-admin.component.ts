import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/service/admin.service';
import { LocalStorageService } from 'src/app/service/local-storage.service';

@Component({
  selector: 'app-view-admin',
  templateUrl: './view-admin.component.html',
  styleUrls: ['./view-admin.component.css']
})
export class ViewAdminComponent {
  adminProfile: any;
  adminId:any;
  constructor(private localStoraage:LocalStorageService,private adminService:AdminService, private router: Router) { }
  ngOnInit(){
    this.viewProfile()
  }
  viewProfile() {
     this.adminId = localStorage.getItem("adminId");
    this.adminService.viewAdminById(this.adminId).subscribe(res=>{
      console.log(res);
      this.adminProfile=res;
    })
    
}
goBack(){
  this.router.navigate(['/adminDashboardHeader']);
}

}
