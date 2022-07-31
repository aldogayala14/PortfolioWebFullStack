import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgModel } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ignoreElements } from 'rxjs';
import { Person } from 'src/app/model/person';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { ResidenceService } from 'src/app/services/residence.service';
import { TokenService } from 'src/app/services/token.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  urlpicture!: string;
  isLogged = false;

  id!: number;
  firstName!: string;
  lastName!: string;
  birthDate!: string;
  email!: string;
  nationality!: string;
  aboutMe!: string;
  occupation!: string;
  imageBackgroundHeader!: string;
  imageProfile!: string;

  portfolioData: any;
  residenceData: any;

  person!: Person;


  name!: string;
  percentageKnowledge!: number;

  personData: any;

  @ViewChild('contenido') modalEdit!: ElementRef;
  @ViewChild('contenidoPlus') modalPlus!: ElementRef;

  constructor(private service: PortfolioService,
    private serviceResidence: ResidenceService,
    private router: Router,
    private tokenService: TokenService,
    private modalService: NgbModal) { }

  ngOnInit(): void {

    this.init();

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }


  }

  public init(): void {
    this.service.getData().subscribe(data => {
      this.portfolioData = data;
    });

    this.serviceResidence.getData().subscribe(data => {
      this.residenceData = data;
    });
  }

  public login() {
    this.router.navigate(['/login']);
  }

  onLoggout(): void {
    this.tokenService.logOut();
    window.location.reload();
  }


  public editPerson(): void {
    this.person = new Person(
      this.firstName,
      this.lastName,
      this.birthDate,
      this.email,
      this.nationality,
      this.aboutMe,
      this.occupation,
      this.imageBackgroundHeader,
      this.imageProfile)
   

    if (this.person != undefined) {
      this.service.update(this.id, this.person).subscribe(
        data => {
          this.init();
          alert("Se edito la informacion");
        }, err => {
          alert("No se pudo guardar la informacion");
        }

      );
    }
  }

  public openModalEdit(
    id: number,
    firstName: string,
    lastName: string,
    birthDate: string,
    email: string,
    nationality: string,
    aboutMe: string,
    occupation: string,
    imageBackgroundHeader: string,
    imageProfile: string): any {
    if (id != undefined) {
      this.id = id;
      this.firstName = firstName,
        this.lastName = lastName,
        this.birthDate = birthDate,
        this.email = email,
        this.nationality = nationality,
        this.aboutMe = aboutMe,
        this.occupation = occupation,
        this.imageBackgroundHeader = " ",
        this.imageProfile = imageProfile
      this.modalService.open(this.modalEdit);
    }

  }

  public openModalPlus()
  {
    this.modalService.open(this.modalPlus);
  }


}
