import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { LocalStorageService } from './local-storage.service';
import { Observable } from 'rxjs';
import { customerModel } from '../model/customerModel';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  baseUrl: string = 'http://localhost:9090/api/customer';

  constructor(
    private http: HttpClient,
    private localstorageservice: LocalStorageService
  ) {}

  addCustomer(customerbody: customerModel):Observable<customerModel> {
    console.log("customer Body-------------------",customerbody);
    return this.http.post<customerModel>(this.baseUrl+"/register",customerbody);
    // return this.http.post(this.baseUrl + '/register', customer);
  }
}
