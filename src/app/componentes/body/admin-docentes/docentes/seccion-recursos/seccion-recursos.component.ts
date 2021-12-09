import { Component, OnInit } from '@angular/core';
import { UloginService } from 'src/app/services/ulogin.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { finalize } from 'rxjs';

@Component({
  selector: 'app-seccion-recursos',
  templateUrl: './seccion-recursos.component.html',
  styleUrls: ['./seccion-recursos.component.scss']
})
export class SeccionRecursosComponentDocentes implements OnInit {

  data: any;

  constructor(private uloginService: UloginService, private router: Router) { }

  ngOnInit(): void {
  }
  Recursos() {
    this.uloginService.GetRecursos().subscribe((response: any) => {
      console.log(response)
      this.data = response;
    })
    return this.data;
  }
  recursos = this.Recursos()

  CrearRecurso() {
    this.router.navigate(['agregar-recurso-docentes']);
  }
  BorrarRecurso(i: any) {
    let id = this.data[i].id
    this.router.navigate(['recarga'])
    Swal.fire({
      title: 'Estas Seguro de eliminar ' + this.data[i].nombreRecurso + "?",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Eliminar'

    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire(
          'Eliminado !',
          'Se ha eliminado ' + this.data[i].nombreRecurso + ' con exito',
          'success'
        )

        this.uloginService.DeleteRecursos(id).pipe(finalize(() => this.DevolverARecursos())).subscribe((response: any) => {
          console.log(response)
        })

      } else {
        this.router.navigate(['seccion-recursos-docentes'])
      }
    })
  }
  DevolverARecursos() {
    this.router.navigate(['seccion-recursos-docentes'])

  }
  CerrarSesion(){
    localStorage.removeItem("token")
    localStorage.removeItem("rolUsuario")
    localStorage.removeItem("idUsuario")
  }

}
