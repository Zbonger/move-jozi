import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {catchError, retry} from "rxjs/operators";
import {LoadModule} from "../load/module/load.module";
@Injectable({
  providedIn: 'root'
})
export class LoadService {

  //curl -X GET "http://localhost:1111/eureka/apps/" -H "Content-Type:application/json" -H "Accept:application/json"
  private apiUrl = '/api/service-discovery';
  constructor(private httpClient: HttpClient) { }

  // @ts-ignore
  findAllLoads() : Observable<any>  {
    return this.httpClient.get<LoadModule[]>('http://localhost:8085/load-service/api/v1/load/all')
      .pipe(
        retry(1),
        catchError(this.handleError)
    )

    // return this.httpClient.get<any>('http://localhost:8085/load-service/api/v1/load/all')
    //   .toPromise()
    //   .then(response => response.json() as any[])
    //   .catch(this.handleError);
  }

  private handleError(error: any): Promise<Array<any>> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
