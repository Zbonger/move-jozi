import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
@Injectable({
  providedIn: 'root'
})
export class LoadService {

  constructor(private httpClient: HttpClient) { }

  getTruckLoadsCatalogue() {
    //return //this.http.get('http://localhost/api/users')
    //return this.httpClient.get<LoadCatalogue[]>('http://localhost:/employees');
    return null;
  }
}
