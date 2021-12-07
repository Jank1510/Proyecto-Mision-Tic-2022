import { CursorError } from '@angular/compiler/src/ml_parser/lexer';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UloginService } from 'src/app/services/ulogin.service';

@Component({
  selector: 'app-agregar-recurso',
  templateUrl: './agregar-recurso.component.html',
  styleUrls: ['./agregar-recurso.component.scss']
})
export class AgregarRecursoComponentDocentes implements OnInit {

  materias: any;
  cursos: any;
  public archivos: any = [];
  datosRecurso: any;

  constructor(private uloginService: UloginService, private router: Router) { }

  ngOnInit(): void {
  }

  Materias() {
    this.uloginService.GetMaterias().subscribe((response: any) => {
      console.log(response)
      this.materias = response
    })
    return this.materias;
  }
  a = this.Materias()//el a no significa nada solo para llamar el metodo y se cargue la variable gloabl

  Cursos() {
    this.uloginService.GetCursos().subscribe((response: any) => {
      this.cursos = response
      console.log(response)
    })
    return this.cursos;
  }
  b = this.Cursos()

  capturarFile(event: any) {
    const archivoCapturado = event.target.files[0]
    this.archivos.push(archivoCapturado)
    console.log(event.target.files)
  }
  GuardarRecursos() {
    this.datosRecurso = {
      "nombreRecurso": "xcxcx",

      "materia": {
        "id": "75"
      },
      "curso": {
        "id": "65"
      },
      "usuario": {
        "id": "15"
      }
    }
    const formulario = new FormData();
    formulario.append('recurso', this.datosRecurso);
    formulario.append('archivo',this.archivos);

    console.log(this.archivos)
    console.log(this.datosRecurso)

    this.uloginService.PostRecursos(formulario).subscribe((res: any) => {
      console.log(res)
    })
  }
}
