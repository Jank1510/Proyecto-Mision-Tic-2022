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
  titulo1: any
  titulo2: any
  titulo3: any
  descripcion1: any
  descripcion2: any
  descripcion3: any

  constructor(private uloginService: UloginService, private router: Router) { }

  ngOnInit(): void {
  }
  ObtenerNoticias() {
    this.uloginService.GetNoticias().subscribe((response: any) => {
      console.log(response)
      this.noticias = response
      
      this.ruta1 = this.noticias[0].ruta
      this.ruta2 = this.noticias[1].ruta
      this.ruta3 = this.noticias[2].ruta

      this.titulo1 = this.noticias[0].tituloNoticia
      this.titulo2 = this.noticias[1].tituloNoticia
      this.titulo3 = this.noticias[2].tituloNoticia

      this.descripcion1 = this.noticias[0].descripcion
      this.descripcion2 = this.noticias[2].descripcion
      this.descripcion3 = this.noticias[2].descripcion
    })

  }
  a = this.ObtenerNoticias()

}
