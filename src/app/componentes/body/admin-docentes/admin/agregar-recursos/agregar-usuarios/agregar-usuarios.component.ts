import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UloginService } from 'src/app/services/ulogin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-agregar-usuarios',
  templateUrl: './agregar-usuarios.component.html',
  styleUrls: ['./agregar-usuarios.component.scss']
})
export class AgregarUsuariosComponent implements OnInit {

  nickName: any
  password: any
  nombre: any
  apellidos: any
  data: any


  constructor(private uloginService: UloginService, private router: Router) { 
    this.nickName="";
    this.password="";
    this.nombre="";
    this.apellidos="";
  }

  ngOnInit(): void {
  }


  AgregarUsuario() {
    if (this.nickName === "") {
      Swal.fire({
        icon: 'error',
        title: 'nickName Vacio !'
      })
    } else {
      if (this.password === "") {
        Swal.fire({
          icon: 'error',
          title: 'Password Vacio !'
        })
      } else {
        if (this.nombre === "") {
          Swal.fire({
            icon: 'error',
            title: 'Nombre Vacio !'
          })
        } else {
          if (this.apellidos === "") {
            Swal.fire({
              icon: 'error',
              title: 'apellidos Vacio !'
            })
          } else {
            this.data = {
              "nickName": this.nickName,
              "contraseña": this.password,
              "nombres": this.nombre,
              "apellidos": this.apellidos,
              "rol": {
                "id": 15
              }
            }
            console.log(this.data)
            this.uloginService.PostUsuarios(this.data).subscribe((response:any) => {
              Swal.fire({
                icon: 'success',
                title: 'Agregado Con Exito!'
              })
              this.router.navigate(['seccion-recursos-usuarios-admin'])

            })
          }
        }
      }
    }
   
  }
  Cancelar(){
    this.router.navigate(['seccion-recursos-usuarios-admin'])

  }

}
