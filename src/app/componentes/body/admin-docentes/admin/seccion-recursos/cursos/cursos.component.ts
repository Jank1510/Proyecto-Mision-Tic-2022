import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { finalize } from 'rxjs/operators';
import { UloginService } from 'src/app/services/ulogin.service';
import Swal from 'sweetalert2';
 
@Component({
  selector: 'app-cursos',
  templateUrl: './cursos.component.html',
  styleUrls: ['./cursos.component.scss']
})
export class CursosComponent implements OnInit {

  cursos: any;
  curso: any

  constructor(private uloginService: UloginService, private router: Router) {
  }

  ngOnInit(): void {
  }

  CargarCursos() {
    this.uloginService.GetCursos().subscribe((response: any) => {
      this.cursos = response
    })
    return this.cursos
  }
  a = this.CargarCursos();

  eliminarCurso(i: any) {
    let id = (this.cursos[i].id)
    this.router.navigate(['recarga'])
    Swal.fire({
      title: 'Estas Seguro de eliminar ' + this.cursos[i].descripcion + "?",
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
          'Se ha eliminado ' + this.cursos[i].descripcion + ' con exito',
          'success'
        )

        this.uloginService.DeleteCursos(id).pipe(finalize(() => this.DevolverACursos())).subscribe((response: any) => {
        
        })
      } else {

        this.router.navigate(['seccion-recursos-curso-admin'])
      }
    })

  }
  async AgregarCursos() {
    this.router.navigate(['recarga'])
    const { value: curso } = await Swal.fire({
      input: 'text',
      title: 'INGRESA EL NUEVO CURSO',
      inputPlaceholder: 'Nombre del curso',
    })
    if (curso) {
      this.curso = curso
      this.cursos = {
        "descripcion": this.curso
      }
      Swal.fire('Agregado ¡', '', 'success')
      this.uloginService.PostCursos(this.cursos).pipe(finalize(() => this.DevolverACursos())).subscribe((response: any) => {
        console.log(response)
      })

    }
  }
  DevolverACursos() {
    this.router.navigate(['seccion-recursos-curso-admin'])
  }
}
