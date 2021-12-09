import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UloginService } from 'src/app/services/ulogin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-recursos',
  templateUrl: './recursos.component.html',
  styleUrls: ['./recursos.component.scss']
})
export class RecursosComponent implements OnInit {
  cursos:any
  cursosSelect:any
  CursosIndice:any=[]
  recursos:any

  constructor(private uloginService: UloginService, private router: Router) { }

  ngOnInit(): void {
  }
  CargarCursos(){
    this.uloginService.GetCursos().subscribe((response:any)=>{
      this.cursos=response
    })
    return this.cursos
  }
  a=this.CargarCursos()

  Consultar(){
    this.CursosIndice=[]
    
    this.uloginService.GetRecursos().subscribe((res:any)=>{
      this.recursos=res
    for (const i of this.recursos) {
      if (i.curso.id===this.cursos[this.cursosSelect].id){
        this.CursosIndice.push(i)
      }
    }
    if(this.CursosIndice.length===0){
      Swal.fire({
        icon: 'info',
        title: 'No hay actividades en este curso¡ !'
      })
    }
    })
    
    
  }

}
