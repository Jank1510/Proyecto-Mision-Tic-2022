import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { finalize } from 'rxjs';
import { UloginService } from 'src/app/services/ulogin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.scss']
})
export class UsuariosComponent implements OnInit {

  usuarios: any

  constructor(private uloginService: UloginService, private router: Router) { }

  ngOnInit(): void {
  }
  CargarUsuarios() {
    this.uloginService.GetUsuarios().subscribe((response: any) => {
      this.usuarios = response
    })
    return this.usuarios
  }
  a = this.CargarUsuarios();

  eliminarUsuarios(i: any) {
    let id = (this.usuarios[i].id)
    this.router.navigate(['recarga'])
    Swal.fire({
      title: 'Estas Seguro de eliminar al ' + this.usuarios[i].rol.descripcion + " " + this.usuarios[i].nombres,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      cancelButtonText: 'Cancelar',
      confirmButtonText: 'Eliminar'

    }).then((result) => {
      if (id != 5) {
        if (result.isConfirmed) {
          Swal.fire(
            'Eliminado !',
            'Se ha eliminado ' +this.usuarios[i].rol.descripcion + " " + this.usuarios[i].nombres+ ' con exito',
            'success'
          )

          this.uloginService.DeleteUsuarios(id).pipe(finalize(() => this.DevolverAUsuarios())).subscribe((response: any) => {
            console.log(response)
          })
        }else{
          this.router.navigate(['seccion-recursos-usuarios-admin'])
        }
      }else{
        Swal.fire({
          icon: 'error',
          title: 'Es Imposible Borrar A Este Administrador!'
        })
      }      
    })
  }
  CrearUsuario(){
    this.router.navigate(['agregar-usuario'])
  }
  DevolverAUsuarios(){
    this.router.navigate(['seccion-recursos-usuarios-admin'])
  }

}
