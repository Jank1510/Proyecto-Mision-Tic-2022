import { Component, OnInit } from '@angular/core';
import { UloginService } from 'src/app/services/ulogin.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seccion-recursos',
  templateUrl: './seccion-recursos.component.html',
  styleUrls: ['./seccion-recursos.component.scss']
})
export class SeccionRecursosComponentDocentes implements OnInit {

  data: any;

  constructor(private uloginService: UloginService,  private router: Router) { }

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

  CrearRecurso(){
    this.router.navigate(['agregar-recurso-docentes']);
  }

}
