import { Component } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-seller-dashboard',
  templateUrl: './seller-dashboard.component.html',
  styleUrls: ['./seller-dashboard.component.css']
})
export class SellerDashboardComponent {

  constructor(private router: Router) {}
  isDropdownOpen: boolean = false;

  toggleDropdown() {
    this.isDropdownOpen = !this.isDropdownOpen;
  }
  addseller() {
    this.router.navigate(['/sellerRegister']);
  }
  addProduct() {
    this.router.navigate(['/addProduct']);
  }
  Logout() {
    this.router.navigate(['/login']);
  }
}
