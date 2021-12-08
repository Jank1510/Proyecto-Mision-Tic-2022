import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UloginService } from 'src/app/services/ulogin.service';

@Component({
  selector: 'app-recursos',
  templateUrl: './recursos.component.html',
  styleUrls: ['./recursos.component.scss']
})
export class RecursosComponent implements OnInit {
  cursos:any
  cursosSelect:any
  CursosIndice:any
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
    
    this.CursosIndice=this.cursos[this.cursosSelect]
    this.uloginService.GetRecursos().subscribe((res:any)=>{
      this.recursos=res
    console.log(this.recursos)

    })
  }

}
