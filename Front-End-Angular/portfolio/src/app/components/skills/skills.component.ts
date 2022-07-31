import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Technology } from 'src/app/model/technology';
import { TechnologyService } from 'src/app/services/technology.service';
import { TokenService } from 'src/app/services/token.service';


@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  isLogged = false;
  skillData: any;

  technology!: Technology;
  id!: number;

  name!: string;
  percentageKnowledge!: number;

  technologyData: any;

  @ViewChild('contenidoTechnology') modal!: ElementRef;
  @ViewChild('deleteTechnology') modalDelete!: ElementRef;
  @ViewChild('editTechnologyForm') modalEdit!: ElementRef;

  constructor(private service: TechnologyService,
     private tokenService: TokenService,
     private serviceModal: NgbModal) { }

  ngOnInit(): void {
    
    this.initTechnology();

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }


  }  


  public initTechnology(): void {
    this.service.getData().subscribe(data => {

      this.skillData = data;    
    });

  }

  public delete() {
    console.log(this.id);
    if (this.id != undefined) {
      this.service.delete(this.id).subscribe(
        data => {
          this.initTechnology();
        }, err => {
          alert("No se pudo eliminar la skill");
        }

      );
    }


  }

  public saveSkill(): void {
    this.technology= new Technology(
      this.name,
      this.percentageKnowledge)


    if (this.technology != undefined) {
      this.service.save(this.technology).subscribe(
        data => {
          this.initTechnology();
          alert("Nueva skill creada");
        }, err => {
          alert("No se pudo guardar la skill");
        }

      );
    }
  }


  public editTechnology(): void {
    this.technology = new Technology(
      this.name,
      this.percentageKnowledge)


    if (this.technology != undefined) {
      this.service.update(this.id, this.technology).subscribe(
        data => {
          this.initTechnology();
          alert("Se edito la skill");
        }, err => {
          alert("No se pudo guardar la skill");
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
    name:string,
   percentageKnowledge:number): any {
    if (id != undefined) {
      this.id = id;
      this.name = name;
      this.percentageKnowledge = percentageKnowledge;
      this.serviceModal.open(this.modalEdit);
    }

  }


  public setData(): void {
    if (this.id != undefined) {
      this.name = "";
    this.percentageKnowledge = 0;
    }

  }



}
