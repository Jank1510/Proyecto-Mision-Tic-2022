import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UloginService } from 'src/app/services/ulogin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-agregar-recurso',
  templateUrl: './agregar-recurso.component.html',
  styleUrls: ['./agregar-recurso.component.scss']
})
export class AgregarRecursoComponentDocentes implements OnInit {

  materias: any;
  cursos: any;
  fileToUpload: any;
  datosRecurso: any;
  selectedFiles?: FileList;
  nombreRecurso: any;
  materiasRecurso: any;
  materiasRecursoFinal: any;
  cursosRecurso: any;
  cursosRecursoFinal: any;


  constructor(private uloginService: UloginService, private router: Router) { }

  ngOnInit(): void {
  }

  Materias() {//metodo para cargar las materias 
    this.uloginService.GetMaterias().subscribe((response: any) => {
      console.log(response)
      this.materias = response
    })
    return this.materias;
  }
  a = this.Materias()//el a no significa nada solo para llamar el metodo y se cargue la variable gloabl

  Cursos() {//metodo para cargar los cursos
    this.uloginService.GetCursos().subscribe((response: any) => {
      this.cursos = response
      console.log(response)
    })
    return this.cursos;
  }
  b = this.Cursos()

  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
    this.fileToUpload = this.selectedFiles?.item(0)
  }

  GuardarRecursos() {
    for (const i of (this.Materias())) {//aqui iteramos la funcion materias q retorna un json
      if (this.materiasRecurso === i.nombre) {//buscamos el nombre de la materia comparandolo con materiaRecurso que es lo q el usuario selecciono 
        this.materiasRecursoFinal = i.id
      }
    }
    for (const i of (this.Cursos())) {//aqui iteramos la funcion materias q retorna un json
      if (this.cursosRecurso === i.descripcion) {//buscamos el nombre de la materia comparandolo con materiaRecurso que es lo q el usuario selecciono 
        this.cursosRecursoFinal = i.id
      }
    }
    if (this.nombreRecurso === undefined) {
      Swal.fire({
        icon: 'error',
        title: 'Nombre Del Recurso Vacio !'
      })
    } else {
      if (this.materiasRecursoFinal === undefined) {
        Swal.fire({
          icon: 'error',
          title: 'Seleccione Una Materia !'
        })
      } else {
        if (this.cursosRecursoFinal === undefined) {
          Swal.fire({
            icon: 'error',
            title: 'Seleccione Un Curso !'
          })
        } else {
          if(this.fileToUpload===undefined){
            Swal.fire({
              icon: 'error',
              title: 'Seleccione Un Archivo !'
            })
          }else{
            this.datosRecurso = {
              "nombreRecurso": this.nombreRecurso,
  
              "materia": {
                "id": this.materiasRecursoFinal
              },
              "curso": {
                "id": this.cursosRecursoFinal
              },
              "usuario": {
                "id": localStorage.getItem("idUsuario")
              }
            }
            var datosRecursoString = JSON.stringify(this.datosRecurso)
            var formulario = new FormData();
            formulario.append('recurso', datosRecursoString);
            formulario.append('archivo', this.fileToUpload);
            this.uloginService.PostRecursos(formulario).subscribe((res: any) => {
              Swal.fire({
                icon: 'success',
                title: 'Archivo Subido Con exito !'
              })
              this.router.navigate(['seccion-recursos-docentes'])
            })
          }          
        }
      }
    }
  }
  Cancelar() {
    this.router.navigate(['seccion-recursos-docentes'])
  }
}
