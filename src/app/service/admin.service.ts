import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LocalStorageService } from './local-storage.service';
import { adminModel } from '../model/adminModel';
import { Observable } from 'rxjs';
@Injectable({
    providedIn: 'root',
})
export class AdminService {
    constructor(private http: HttpClient, private localstorageservice: LocalStorageService) { }
    baseUrl: string = "http://localhost:9090/api/admin";
    private getHeaders(): HttpHeaders {
        return new HttpHeaders({
            'Content-Type': 'application/json',
            'Authorization': "Bearer " + this.localstorageservice.getItem('token')

        });
    }
    addAdmin(admin: adminModel): Observable<adminModel>{
  
        return this.http.post<adminModel>(this.baseUrl+"/addAdmin",admin);
      }

      viewAdminById(adminId: number): Observable<adminModel> {
    
        return this.http.get<adminModel>(this.baseUrl + "/viewAdminById/" + adminId);
      }

}
