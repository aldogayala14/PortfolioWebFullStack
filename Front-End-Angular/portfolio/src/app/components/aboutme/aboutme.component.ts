import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { TokenService } from 'src/app/services/token.service';


@Component({
  selector: 'app-aboutme',
  templateUrl: './aboutme.component.html',
  styleUrls: ['./aboutme.component.css']
})
export class AboutmeComponent implements OnInit {

  isLogged = false;
  aboutMeData:any;
  @ViewChild('contenidoAbout') modal!: ElementRef;

  constructor(private service:PortfolioService, private tokenService:TokenService, private serviceModal:NgbModal) { }

  ngOnInit(): void {
    this.service.getData().subscribe(data =>{
        this.aboutMeData = data;
    });

    if(this.tokenService.getToken()){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  open(){
    this.serviceModal.open(this.modal);
  }

}
