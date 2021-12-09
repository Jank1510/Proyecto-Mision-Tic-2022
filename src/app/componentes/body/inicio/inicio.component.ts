import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UloginService } from 'src/app/services/ulogin.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.scss']
})
export class InicioComponent implements OnInit {
  noticias: any
  ruta1: any
  ruta2: any
  ruta3: any
  ruta4: any
  ruta5: any
  titulo1: any
  titulo2: any
  titulo3: any
  titulo4: any
  titulo5: any
  descripcion1: any
  descripcion2: any
  descripcion3: any
  descripcion4: any
  descripcion5: any

  constructor(private uloginService: UloginService, private router: Router) { }

  ngOnInit(): void {
  }
  ObtenerNoticias() {
    this.uloginService.GetNoticias().subscribe((response: any) => {
      console.log(response)
      this.noticias = response

      let x =this.noticias.length//para mirar cuantas noticias hay
      
      this.ruta1 = this.noticias[(x-(1))].ruta
      this.ruta2 = this.noticias[(x-(2))].ruta
      this.ruta3 = this.noticias[(x-(3))].ruta
      this.ruta4 = this.noticias[(x-(4))].ruta
      this.ruta5 = this.noticias[(x-(5))].ruta

      this.titulo1 = this.noticias[(x-(1))].tituloNoticia
      this.titulo2 = this.noticias[(x-(2))].tituloNoticia
      this.titulo3 = this.noticias[(x-(3))].tituloNoticia
      this.titulo4 = this.noticias[(x-(4))].tituloNoticia
      this.titulo5 = this.noticias[(x-(5))].tituloNoticia

      this.descripcion1 = this.noticias[(x-(1))].descripcion
      this.descripcion2 = this.noticias[(x-(2))].descripcion
      this.descripcion3 = this.noticias[(x-(3))].descripcion
      this.descripcion4 = this.noticias[(x-(4))].descripcion
      this.descripcion5 = this.noticias[(x-(5))].descripcion
      
    })

  }
  a = this.ObtenerNoticias()
 
}
