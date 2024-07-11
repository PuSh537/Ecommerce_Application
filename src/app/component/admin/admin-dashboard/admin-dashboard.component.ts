import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LocalStorageService } from 'src/app/service/local-storage.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {
  constructor(private router:Router, private localStorageService:LocalStorageService){}
  ngOnInit() {
    // if(!this.localStorageService.getItem('token')){
    //   this.router.navigate(['/login']); 
    // }
  }
}
