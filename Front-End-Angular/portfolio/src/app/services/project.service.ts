import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Project } from '../model/project';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  URL= 'https://aldogayalaportfolio.herokuapp.com/api/';
  constructor(private http: HttpClient) { }
  

  public getData():Observable<any>{
    return this.http.get(this.URL + 'project');
  }  

  public save(project:Project):Observable<any>{
    return this.http.post<any>(this.URL +'project', project);
  }

  public update(id:number,project:Project): Observable<any>{
    return this.http.put<any>(this.URL + `project/${id}`, project);
  }

  public delete(id:number):Observable<any>{
    return this.http.delete<any>(this.URL + `project/${id}`);
  }
}
