import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Experience } from '../model/experience';

@Injectable({
  providedIn: 'root'
})
export class ExperiencieService {

  constructor(private http: HttpClient) { }

  URL= 'https://aldogayalaportfolio.herokuapp.com/api/';
  

  public getData():Observable<any>{
    return this.http.get(this.URL + 'workexperiencie');
  } 

  public save(experience:Experience):Observable<any>{
    return this.http.post<any>(this.URL +'workexperiencie', experience);
  }

  public update(id:number,experience:Experience): Observable<any>{
    return this.http.put<any>(this.URL + `workexperiencie/${id}`, experience);
  }

  public delete(id:number):Observable<any>{
    return this.http.delete<any>(this.URL + `workexperiencie/${id}`);
  }
}
