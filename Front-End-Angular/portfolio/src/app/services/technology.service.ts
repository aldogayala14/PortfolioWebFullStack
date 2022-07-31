import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Technology } from '../model/technology';

@Injectable({
  providedIn: 'root'
})
export class TechnologyService {

  URL= 'https://aldogayalaportfolio.herokuapp.com/api/';
  constructor(private http: HttpClient) { }
  

  public getData():Observable<any>{
    return this.http.get(this.URL + 'technology');
  }  

  public save(technology:Technology):Observable<any>{
    return this.http.post<any>(this.URL +'technology', technology);
  }

  public update(id:number,technology:Technology): Observable<any>{
    return this.http.put<any>(this.URL + `technology/${id}`, technology);
  }

  public delete(id:number):Observable<any>{
    return this.http.delete<any>(this.URL + `technology/${id}`);
  }
}
