import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from "@angular/router";
import { CommonModule } from '@angular/common';
import { AdminHeaderComponent } from './admin-header/admin-header.component';
import { AddAdminComponent } from './add-admin/add-admin.component';



@NgModule({
  declarations: [
    AdminHeaderComponent,
    AddAdminComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    RouterModule
  ]
})
export class AdminModule { }
