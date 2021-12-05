import { Component, OnInit } from '@angular/core';
import { UloginService } from 'src/app/services/ulogin.service';
import { LoginI } from 'src/app/modelos/login.interface';
import { Router } from '@angular/router';
import { ResponseI } from 'src/app/modelos/response.interface';
import Swal from 'sweetalert2';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-docentes',
  templateUrl: './docentes.component.html',
  styleUrls: ['./docentes.component.scss']
})
export class DocentesComponent implements OnInit {

  usuario: string;
  password: string;
  user: any;
  list: any = [];
  ValidarUsuario: boolean;

  constructor(private uloginService: UloginService, private router: Router) {
    this.usuario = ""
    this.password = ""
    this.ValidarUsuario = false;
  }

  ngOnInit(): void {
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
              if (this.list[jank].id === 15) {// el 2 hace referencia al rol de docentes 
                this.router.navigate(['seccion-recursos-docentes']);
              }
              if (this.list[jank].id === 5){
                this.router.navigate(['seccion-recursos-curso-admin'])
              }
            }
            if (jank === "token") {
              localStorage.setItem("token", (this.list[jank]));

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
