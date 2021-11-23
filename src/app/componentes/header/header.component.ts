import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss','../../css Mostly Fluid/phone.scss','../../css Mostly Fluid/desktop.scss'] 
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  mostrarDatos:boolean=false;

  //esta funcion surge para reemplazar css y ocultar y mostrar el contenido del
  //menu desplegable de forma mas bonita xd
  MostrarOcultarDesple():void{
    if (this.mostrarDatos==false){
      this.mostrarDatos=true
      console.log("true")
    }else if(this.mostrarDatos==true){
      this.mostrarDatos=false
      console.log("false")
    }    
  }
  ocultardesple():void{
    console.log("llamamos el metodo")
    if (this.mostrarDatos==true){
      this.mostrarDatos=false; 
      console.log("click afuera")
    }
  }
}
