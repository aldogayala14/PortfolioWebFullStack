import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Education } from '../model/education';

@Injectable({
  providedIn: 'root'
})
export class EducationService {

  constructor(private http: HttpClient) { }

  URL= 'https://aldogayalaportfolio.herokuapp.com/api/';
  

  public getData():Observable<any>{
    return this.http.get(this.URL + 'education');
  } 

  public save(education:Education):Observable<any>{
    return this.http.post<any>(this.URL +'education', education);
  }

  public update(id:number,education:Education): Observable<any>{
    return this.http.put<any>(this.URL + `education/${id}`, education);
  }

  public delete(id:number):Observable<any>{
    return this.http.delete<any>(this.URL + `education/${id}`);
  }
}
