import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-botones-secciones',
  templateUrl: './botones-secciones.component.html',
  styleUrls: ['./botones-secciones.component.scss']
})
export class BotonesSeccionesComponent implements OnInit {

  constructor(  private router: Router) { }

  ngOnInit(): void {  
    
  }
 


  Cursos() {
    this.router.navigate(['seccion-recursos-curso-admin']);
  }
  Materias() {
    this.router.navigate(['seccion-recursos-materias-admin']);
  }
  Noticias() {
    this.router.navigate(['seccion-recursos-noticias-admin']);
  }
  Sugerencias() {
    this.router.navigate(['seccion-recursos-sugerencias-admin']);
  }
  Usuarios() {
    this.router.navigate(['seccion-recursos-usuarios-admin']);
  }
  CerrarSesion(){
    localStorage.removeItem("token")
    localStorage.removeItem("idUsuario")
    localStorage.removeItem("rolUsuario")
    
  }

}
