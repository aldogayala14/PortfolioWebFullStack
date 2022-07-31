import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Project } from 'src/app/model/project';
import { ProjectService } from 'src/app/services/project.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-proyects',
  templateUrl: './proyects.component.html',
  styleUrls: ['./proyects.component.css']
})
export class ProyectsComponent implements OnInit {

  project!: Project;
  id!: number;

  name!: string;
  image!: string;
  projectStart!: string;
  projectEnd!: string;
  url!: string;

  isLogged = false;
  projectData: any;

  @ViewChild('contenidoProject') modal!: ElementRef;
  @ViewChild('deleteProject') modalDelete!: ElementRef;
  @ViewChild('editProjectForm') modalEdit!: ElementRef;

  constructor(private service: ProjectService, 
    private tokenService: TokenService,
    private serviceModal: NgbModal) { }

  ngOnInit(): void {
    this.initProject();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  public initProject(): void {
    this.service.getData().subscribe(data => {

      this.projectData = data;      
    });

  }

  public delete() {    
    if (this.id != undefined) {
      this.service.delete(this.id).subscribe(
        data => {
          this.initProject();
        }, err => {
          alert("No se pudo eliminar el proyecto");
        }

      );
    }


  }

  public saveProject(): void {
    this.project= new Project(
      this.name,
      this.image,
      this.projectStart,
      this.projectEnd,
      this.url)


    if (this.project != undefined) {
      this.service.save(this.project).subscribe(
        data => {
          this.initProject();
          alert("Nuevo proyecto creado");
        }, err => {
          alert("No se pudo guardar el proyecto");
        }

      );
    }
  }


  public editProject(): void {
    this.project = new Project(
      this.name,
      this.image,
      this.projectStart,
      this.projectEnd,
      this.url)


    if (this.project != undefined) {
      this.service.update(this.id, this.project).subscribe(
        data => {
          this.initProject();
          alert("Se edito el proyecto");
        }, err => {
          alert("No se pudo guardar el proyecto");
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
    image:string,
    projectStart:string,
    projectEnd:string,
    url:string): any {
    if (id != undefined) {
      this.id = id;
      this.name = name;
      this.image = image;
      this.projectStart = projectStart;
      this.projectEnd = projectEnd;
      this.url = url;
      this.serviceModal.open(this.modalEdit);
    }

  }


  public setData(): void {
    if (this.id != undefined) {
      this.name = "";
      this.image = "";
      this.projectStart = "";
      this.projectEnd = "";
      this.url = "";
    }

  }


}
