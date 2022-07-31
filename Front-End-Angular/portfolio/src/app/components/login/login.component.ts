import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthService } from 'src/app/services/auth.service';
import { TokenService } from 'src/app/services/token.service';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isLogged = false;
  isLoginFail = false;
  loginUser!: User;
  username!:string;
  password! :string;  
  errorMsj!: string;

  constructor(private tokenService:TokenService, private authService:AuthService, private router:Router) { }

  ngOnInit(): void {

    if(this.tokenService.getToken()){
      this.isLogged = true;
      this.isLoginFail = false;
    }
  }

  public onLogin(){
    
    this.loginUser = new User(this.username, this.password);
   
    this.authService.login(this.loginUser).subscribe(data => {
        
        this.isLogged = true;
        this.isLoginFail = false;
        this.tokenService.setToken(Object.values(data)[0]);
        this.tokenService.setUserName(this.username);
        this.router.navigate([''])
      }, err => {
        this.isLogged = false;
        this.isLoginFail = true;
        alert("Usuario o contraseña incorrecto");
        this.errorMsj = "Usuario o contraseña incorrecto";
        console.log(this.errorMsj);
      });
          
  }

}
