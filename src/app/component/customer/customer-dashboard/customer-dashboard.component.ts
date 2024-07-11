import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LocalStorageService } from 'src/app/service/local-storage.service';

@Component({
  selector: 'app-customer-dashboard',
  templateUrl: './customer-dashboard.component.html',
  styleUrls: ['./customer-dashboard.component.css']
})
export class CustomerDashboardComponent {

  constructor(private router: Router) {}
  isDropdownOpen: boolean = false;

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }
  addCustomer() {
    this.router.navigate(['/customerRegister']);
  }
  // addAdmin() {
  //   this.router.navigate(['/addAdmin']);
  // }
  Logout() {
    this.router.navigate(['/login']);
  }
}
