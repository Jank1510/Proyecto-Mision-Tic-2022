import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UloginService } from 'src/app/services/ulogin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-agregar-noticias',
  templateUrl: './agregar-noticias.component.html',
  styleUrls: ['./agregar-noticias.component.scss']
})
export class AgregarNoticiasComponent implements OnInit {
  tituloNoticia: any
  descripcionNoticia: any
  fileToUpload: any;
  selectedFiles?: FileList;
  jsonNoticia: any

  constructor(private uloginService: UloginService, private router: Router) {
    this.tituloNoticia = ""
    this.descripcionNoticia = ""
  }

  ngOnInit(): void {
  }

  selectFile(event: any): void {
    this.selectedFiles = event.target.files;
    this.fileToUpload = this.selectedFiles?.item(0)
  }
  GuardarRecursos() {
    if (this.tituloNoticia === "") {
      Swal.fire({
        icon: 'error',
        title: 'Titulo Noticias Vacio!'
      })
    } else {
      if (this.descripcionNoticia === "") {
        Swal.fire({
          icon: 'error',
          title: 'Descripcion Noticia Vacio!'
        })
      } else {
        this.jsonNoticia = {
          "tituloNoticia": this.tituloNoticia,
          "descripcion": this.descripcionNoticia
        }
        var noticiaString = JSON.stringify(this.jsonNoticia)
        var formulario = new FormData();
        formulario.append('imagen', this.fileToUpload);
        formulario.append('noticia', noticiaString);
        this.uloginService.PostNoticias(formulario).subscribe((res: any) => {
          Swal.fire({
            icon: 'success',
            title: 'Noticia Subida Con exito !'
          })
          this.router.navigate(['seccion-recursos-noticias-admin'])
        })
      }
    }

  }
  Cancelar() {
    this.router.navigate(['seccion-recursos-noticias-admin'])
  }
}
