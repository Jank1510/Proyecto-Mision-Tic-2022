import { Component, Injectable, OnInit } from '@angular/core';
import { UloginService } from 'src/app/services/ulogin.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-docentes',
  templateUrl: './docentes.component.html',
  styleUrls: ['./docentes.component.scss']
})
@Injectable({//le ponemos injectable para llamar los desde agregar recursos
  providedIn: 'root'
})
export class DocentesComponent implements OnInit {

   usuario: string;
   password: string;
  user: any;
  list: any = [];
  ValidarUsuario: boolean;
  public idUsuarios:any;
  

  constructor(private uloginService: UloginService, private router: Router) {
    this.usuario = ""
    this.password = ""
    this.ValidarUsuario = false;
  }

  ngOnInit(): void {
    if(localStorage.getItem("rolUsuario")==="15"){
      this.router.navigate(['seccion-recursos-docentes']);
    }
    if(localStorage.getItem("rolUsuario")==="5"){
      this.router.navigate(['seccion-recursos-curso-admin'])
    }
  }


  login() {//este metodo es llamado en el boton enviar y crea el objeto de user y llama el metodo postlogin del servicio donde se le pasa como parametro el objeto creado 

    if (this.usuario === "") {
      Swal.fire({
        icon: 'error',
        title: 'Usuario Vacio !'
      })
    } else {
      if (this.password === "") {
        Swal.fire({
          icon: 'error',
          title: 'Password Vacio !'
        })
      } else {
        this.user = {
          "nickName": this.usuario,
          "contraseña": this.password
        }
        this.uloginService.PostLogin(this.user).pipe(finalize(() => this.validaruser())).subscribe((response: any) => {
          this.list = response;

          for (let jank in this.list) {
            if (jank === "rol") {
              localStorage.setItem("rolUsuario", this.list[jank].id)
              if (this.list[jank].id === 15) {// el 15 hace referencia al rol de docentes 
                this.router.navigate(['seccion-recursos-docentes']);
              }
              if (this.list[jank].id === 5) {
                this.router.navigate(['seccion-recursos-curso-admin'])
              }
            }
            if(jank==="id"){
              localStorage.setItem("idUsuario", this.list[jank])//aca guardamos el id del usuario para usarlo en subir archivos y eso
            }
            if (jank === "token") {
              localStorage.setItem("token", (this.list[jank]));//enviar token
            }


          }
          this.ValidarUsuario = true;//esto para validar si entra aca ya q solo entra cuando existe el usuario
        })

      }
    }
  }


  validaruser() {
    if (this.ValidarUsuario === false) {//aca se valida el boleano cuando es false es porq no existe el usuario
      Swal.fire({
        icon: 'error',
        title: 'El Usuario Es Incorrecto!'
      })
    }

  }

}
