import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-agregar-cursos',
  templateUrl: './agregar-cursos.component.html',
  styleUrls: ['./agregar-cursos.component.scss']
})
export class AgregarCursosComponent implements OnInit {
  curso:any
  constructor() { }

  ngOnInit(): void {
  }
  
  async x() {
    const { value: curso } = await Swal.fire({
      input: 'text',
      title: 'INGRESA EL NUEVO CURSO',
      inputPlaceholder: 'Nombre del curso',
    })
    if (curso) {
      Swal.fire('Agregado ¡','','success')
      console.log(curso)
    }
    
    console.log(this.curso)
  }
  a=this.x()

}
