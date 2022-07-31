import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Education } from 'src/app/model/education';
import { EducationService } from 'src/app/services/education.service';
import { PortfolioService } from 'src/app/services/portfolio.service';
import { TokenService } from 'src/app/services/token.service';


@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {


  education!: Education;

  id!: number;

  college!: string;
  title!: string;
  image!: string;
  career!: string;
  status!: string;
  qualification!: number;
  careerStart!: string;
  careerEnd!: string;

  isLogged = false;
  educationData: any;

  @ViewChild('contenidoEducation') modal!: ElementRef;
  @ViewChild('deleteEducation') modalDelete!: ElementRef;
  @ViewChild('editEducationForm') modalEdit!: ElementRef;


  
  constructor(private service: PortfolioService, 
    private tokenService: TokenService, 
    private serviceEducation: EducationService,
    private serviceModal: NgbModal) { }

  ngOnInit(): void {
    
    this.initEducation();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }


  public initEducation(): void {
    this.serviceEducation.getData().subscribe(data => {

      this.educationData = data;     
    });

  }

  public delete() {   
    if (this.id != undefined) {
      this.serviceEducation.delete(this.id).subscribe(
        data => {
          this.initEducation();
        }, err => {
          alert("No se pudo eliminar la educacion");
        }

      );
    }


  }

  public saveEducation(): void {
    this.education= new Education(
      this.college,
      this.title,
      this.image,
      this.career,
      this.status,
      this.qualification,
      this.careerStart,
      this.careerEnd)


    if (this.education != undefined) {
      this.serviceEducation.save(this.education).subscribe(
        data => {
          this.initEducation();
          alert("Nueva educacion creada");
        }, err => {
          alert("No se pudo guardar la educacion");
        }

      );
    }
  }


  public editEducation(): void {
    this.education= new Education(
      this.college,
      this.title,
      this.image,
      this.career,
      this.status,
      this.qualification,
      this.careerStart,
      this.careerEnd)


    if (this.education != undefined) {
      this.serviceEducation.update(this.id, this.education).subscribe(
        data => {
          this.initEducation();
          alert("Se edito la educacion");
        }, err => {
          alert("No se pudo guardar la educacion");
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

  public openModalEdit(id:number,
    college:string,
    title:string,
    image:string,
    career:string,
    status:string,
    qualification:number,
    careerStart:string,
    careerEnd:string): any {
    if (id != undefined) {
      this.id = id;
      this.college = college,
      this.title = title,
      this.image = image,
      this.career = career,
      this.status = status,
      this.qualification = qualification,
      this.careerStart = careerStart,
      this.careerEnd = careerEnd;
      this.serviceModal.open(this.modalEdit);
    }

  }


  public setData(): void {
    if (this.id != undefined) {
      this.college = "",
      this.title = "",
      this.image = "",
      this.career = "",
      this.status = "",
      this.qualification = 0,
      this.careerStart = "",
      this.careerEnd = "";
    }

  }

}
