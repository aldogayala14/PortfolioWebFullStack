import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { from, Observable } from 'rxjs';
import { JwtDto } from '../model/jwt-dto';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  authURL = 'https://aldogayalaportfolio.herokuapp.com/api/auth/';
  constructor(private httpClient: HttpClient) { }

  public login(loginUser: User):Observable<string>{

    return this.httpClient.post<string>(this.authURL + 'singin', loginUser);

  }
}
