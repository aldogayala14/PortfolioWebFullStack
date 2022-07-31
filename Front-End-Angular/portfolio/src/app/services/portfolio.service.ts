import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from '../model/person';


@Injectable({
  providedIn: 'root'
})
export class PortfolioService {

  portfolioData:any;
  id!:number;

  constructor(private http:HttpClient) { }

  URL= 'https://aldogayalaportfolio.herokuapp.com/api/';

  public getData():Observable<any>{
    return this.http.get(this.URL + 'person');
  }  

  public save(person:Person):Observable<any>{
    return this.http.post<any>(this.URL +'person', person);
  }

  public update(id:number,person:Person): Observable<any>{
    return this.http.put<any>(this.URL + `person/${id}`, person);
  }

  public delete(id:number):Observable<any>{
    return this.http.delete<any>(this.URL + `person/${id}`);
  }
 
   

}
