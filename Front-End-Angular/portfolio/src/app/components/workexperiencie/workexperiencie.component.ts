import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Experience } from 'src/app/model/experience';
import { ExperiencieService } from 'src/app/services/experiencie.service';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { TokenService } from 'src/app/services/token.service';


@Component({
  selector: 'app-workexperiencie',
  templateUrl: './workexperiencie.component.html',
  styleUrls: ['./workexperiencie.component.css']
})
export class WorkexperiencieComponent implements OnInit {

  occupation!: string;
  observations!: string;
  image!: string;
  occupationStart!: string;
  occupationEnd!: string;
  company!: string;
  id!: number;

  experiencie!: Experience;

  isLogged = false;
  experiencieData: any;

  @ViewChild('contenidoExperiencia') modal!: ElementRef;
  @ViewChild('deleteExperiencia') modalDelete!: ElementRef;
  @ViewChild('editExperiencia') modalEdit!: ElementRef;

  constructor(
    private service: PortfolioService,
    private experienceService: ExperiencieService,
    private tokenService: TokenService,
    private serviceModal: NgbModal) { }

  ngOnInit(): void {

    this.initExperience();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  public initExperience(): void {
    this.experienceService.getData().subscribe(data => {

      this.experiencieData = data;    
    
    });

  }

  public delete() {    
    if (this.id != undefined) {
      this.experienceService.delete(this.id).subscribe(
        data => {
          this.initExperience();
        }, err => {
          alert("No se pudo eliminar la experiencia");
        }

      );
    }


  }

  public saveExperiencie(): void {
    this.experiencie = new Experience(
      this.occupation,
      this.observations,
      this.image,
      this.occupationStart,
      this.occupationEnd,
      this.company)


    if (this.experiencie != undefined) {
      this.experienceService.save(this.experiencie).subscribe(
        data => {
          this.initExperience();
          alert("Nueva experiencia creada");
        }, err => {
          alert("No se pudo guardar la experiencia");
        }

      );
    }
  }


  public editExperiencie(): void {
    this.experiencie = new Experience(
      this.occupation,
      this.observations,
      this.image,
      this.occupationStart,
      this.occupationEnd,
      this.company)


    if (this.experiencie != undefined) {
      this.experienceService.update(this.id, this.experiencie).subscribe(
        data => {
          this.initExperience();
          alert("Se edito la experiencia");
        }, err => {
          alert("No se pudo guardar la experiencia");
        }

      );
    }
  }

  public openModalAdd(): void {
    this.setData();
    this.serviceModal.open(this.modal);

  }

  public openModalDelete(id: number): void {
    if (id != undefined) {
      this.id = id;
      this.serviceModal.open(this.modalDelete);
    }

  }

  public openModalEdit(id: number,
    occupation: string,
    observations: string,
    image: string,
    occupationStart: string,
    occupationEnd: string,
    company: string): void {
    if (id != undefined) {
      this.id = id;
      this.occupation = occupation;
      this.observations = observations;
      this.image = image;
      this.occupationStart = occupationStart;
      this.occupationEnd = occupationEnd;
      this.company = company;
      this.serviceModal.open(this.modalEdit);
    }

  }


  public setData():void{      
    if(this.id != undefined){
      this.occupation = "";
      this.observations ="";
      this.image = "";
      this.occupationStart = "";
      this.occupationEnd = "";
      this.company = "";
    }
      
  }

}
