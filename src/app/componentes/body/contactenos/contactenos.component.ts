import { Component, OnInit } from '@angular/core';
import { UloginService } from 'src/app/services/ulogin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-contactenos',
  templateUrl: './contactenos.component.html',
  styleUrls: ['./contactenos.component.scss']
})
export class ContactenosComponent implements OnInit {

  nombreapellido: string;
  email: string;
  mensaje: string;
  condiciones: boolean;
  pqr: any = [];

  constructor(private uloginService: UloginService) {
    this.nombreapellido = "";
    this.email = "";
    this.mensaje = "";
    this.condiciones = false;
  }

  ngOnInit(): void {

  }
  ContactenosDatos() {
    if (this.nombreapellido === "") {
      Swal.fire({
        icon: 'error',
        title: 'Nombres Vacio !'
      })
    } else {
      if (this.email === "") {
        Swal.fire({
          icon: 'error',
          title: 'Email Vacio !'
        })
      } else {
        if (this.mensaje === "") {
          Swal.fire({
            icon: 'error',
            title: 'Mensaje Vacio !'
          })
        } else {
          if (this.condiciones === false) {
            Swal.fire({
              icon: 'error',
              title: 'Acepta Nuestra Politica !'
            })
          } else {
            Swal.fire({
              title: 'Enviado Con Exito',
              width: 600,
              padding: '3em',
              background: '#fff url(../../../../assets/img/trees.png)',
              backdrop: `
                rgba(0,0,123,0.4)
                url("../../../../assets/img/nyan-cat.gif") 
                left top
                no-repeat
              `
            })
            this.pqr = {
              "nombresApellidos": this.nombreapellido,
              "correo": this.email,
              "mensaje": this.mensaje
            }
            this.nombreapellido=""
              this.email=""
              this.mensaje=""
              this.condiciones=false

            this.uloginService.PostContactenos(this.pqr).subscribe((response:any) =>{
              console.log(response)
              
            })
          }
        }
      }
    }
  }

}
