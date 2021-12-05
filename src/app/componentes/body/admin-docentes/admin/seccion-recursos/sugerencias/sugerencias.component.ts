import { Component, OnInit } from '@angular/core';
import { UloginService } from 'src/app/services/ulogin.service';

@Component({
  selector: 'app-sugerencias',
  templateUrl: './sugerencias.component.html',
  styleUrls: ['./sugerencias.component.scss']
})
export class SugerenciasComponent implements OnInit {

  sugerencias:any;

  constructor(private uloginService: UloginService) { }

  ngOnInit(): void {
  }

  CargarSugerencias(){
    this.uloginService.GetSugerencias().subscribe((response:any) => {
      this.sugerencias=response
    })
    return this.sugerencias
  }
  a=this.CargarSugerencias();

}
