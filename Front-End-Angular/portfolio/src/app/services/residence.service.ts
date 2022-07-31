import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ResidenceService {

  constructor(private http:HttpClient) { }

  getData():Observable<any>{
    return this.http.get('https://aldogayalaportfolio.herokuapp.com/api/residence');
  }
}
