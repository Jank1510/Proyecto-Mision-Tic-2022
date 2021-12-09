import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { finalize } from 'rxjs';
import { UloginService } from 'src/app/services/ulogin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-noticias',
  templateUrl: './noticias.component.html',
  styleUrls: ['./noticias.component.scss']
})
export class NoticiasComponent implements OnInit {
  noticias: any

  constructor(private uloginService: UloginService, private router: Router) { }

  ngOnInit(): void {
  }
  CrearNoticia() {
    this.router.navigate(['agregar-noticias'])
  }

  CargarNoticias() {
    this.uloginService.GetNoticias().subscribe((res: any) => {
      this.noticias = res
    })
  }
  a = this.CargarNoticias()

  BorrarNoticias(i: any) {
    let id = (this.noticias[i].id)
    this.router.navigate(['recarga'])
    Swal.fire({
      title: 'Estas Seguro de eliminar la noticia ' + this.noticias[i].tituloNoticia,
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
          'Se ha eliminado ' + this.noticias[i].tituloNoticia,
          'success'
        )

        this.uloginService.DeleteNoticias(id).pipe(finalize(() => this.DevolverACursos())).subscribe((response: any) => {

        })       
      }else{
        this.router.navigate(['seccion-recursos-noticias-admin'])
      }
    })
  }
  DevolverACursos(){
    this.router.navigate(['seccion-recursos-noticias-admin'])
  }
}
