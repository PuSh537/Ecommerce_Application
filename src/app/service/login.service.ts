import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})

export class LoginService {
  constructor(private http: HttpClient) {}
  baseURL: string = 'http://localhost:9090/api/';
  getGeneratedToken(requestBody: any) {
    if (requestBody.username.startsWith('c_')) {
      return this.http.post(
        this.baseURL + 'customer/login/authenticate',
        requestBody
        ,
        { responseType: 'text' as 'json' }
      );
    } else if (requestBody.username.startsWith('s_')) {
      return this.http.post(
        this.baseURL + 'seller/login/authenticate',
        requestBody,
        { responseType: 'text' as 'json' }
      );
    } else {
      return this.http.post(
        this.baseURL + 'admin/login/authenticate',
        requestBody,
        { responseType: 'text' as 'json' }
      );
    }
  }
}
