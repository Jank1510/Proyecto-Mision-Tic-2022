import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { finalize } from 'rxjs/operators';
import { UloginService } from 'src/app/services/ulogin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-materias',
  templateUrl: './materias.component.html',
  styleUrls: ['./materias.component.scss']
}) 
export class MateriasComponent implements OnInit {
  materias:any;

  constructor(private uloginService: UloginService, private router: Router) { }

  ngOnInit(): void {
  }

  CargarMaterias(){
    this.uloginService.GetMaterias().subscribe((response:any) => {
      this.materias=response
    })
    return this.materias
  }
  a=this.CargarMaterias();
  
  eliminarMaterias(i:any){
    let id = (this.materias[i].id)
    this.router.navigate(['recarga'])
    Swal.fire({
      title: 'Estas Seguro de eliminar '+this.materias[i].nombre+"?",
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
          'Se ha eliminado '+this.materias[i].nombre+' con exito',
          'success'
        )
      
      this.uloginService.DeleteMaterias(id).pipe(finalize(() => this.DevolverAMaterias())).subscribe((response:any) =>{
        console.log(response)
      })
    }else{
      this.router.navigate(['seccion-recursos-materias-admin'])
    }
    })
    
  }
  async AgregarMaterias(){
    this.router.navigate(['recarga'])
    const { value: materias } = await Swal.fire({
      input: 'text',
      title: 'INGRESA LA NUEVA MATERIA',
      inputPlaceholder: 'Nombre de Materia',
    })
    if (materias) {
      this.materias=materias
      this.materias={
        "nombre":this.materias
      }
      Swal.fire('Agregado ¡','','success')
      this.uloginService.PostMaterias(this.materias).pipe(finalize(() => this.DevolverAMaterias())).subscribe((response:any)=>{
        console.log(response)
      })
    }
  }
  DevolverAMaterias(){
    this.router.navigate(['seccion-recursos-materias-admin'])
  }
}
