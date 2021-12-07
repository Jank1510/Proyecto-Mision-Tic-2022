import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UloginService {
  url:string="https://chiquitines-backend.herokuapp.com"

  constructor(private http: HttpClient) {
    console.log("llego al servicio")
   }

  PostLogin(user: any){
    let direccion = this.url+"/usuarios/login"
    return this.http.post(direccion,user)
  }
  GetRecursos(){
    let direccion = this.url+"/recursos/getAll"
    return this.http.get(direccion)
  }
  GetMaterias(){
    let direccion= this.url+"/materias"
    return this.http.get(direccion)
  }
  GetCursos(){
    let direccion = this.url+"/cursos"
    return this.http.get(direccion)
  }
  PostContactenos(pqr:any){
    let direccion=this.url+"/sugerencias/add"
    return this.http.post(direccion,pqr)
  }

  PostRecursos(formulario:any){    
    const headers:HttpHeaders=new HttpHeaders({
      'Authorization': 'Bearer '+localStorage.getItem("token")
    })
    let direccion = this.url+"/recursos/subir_recurso"
    return this.http.post(direccion,formulario,{headers: headers})
  }

  GetSugerencias(){
    const headers:HttpHeaders=new HttpHeaders({
      'Content-Type': 'application/json;charset="utf-8',
      'Authorization': 'Bearer '+localStorage.getItem("token")
    })
    let direccion = this.url+"/sugerencias"
    return this.http.get(direccion,{headers: headers});
  }
  GetUsuarios(){
    const headers:HttpHeaders=new HttpHeaders({
      'Content-Type': 'application/json;charset="utf-8',
      'Authorization': 'Bearer '+localStorage.getItem("token")
    })
    let direccion = this.url+"/usuarios/getAll"
    return this.http.get(direccion,{headers: headers});
  }
  DeleteCursos(id:any){
    const headers:HttpHeaders=new HttpHeaders({
      'Content-Type': 'application/json;charset="utf-8',
      'Authorization': 'Bearer '+localStorage.getItem("token")
    })
    let direccion = this.url+"/cursos/delete/"+id
    return this.http.delete(direccion,{headers: headers})
  }
  DeleteMaterias(id:any){
    const headers:HttpHeaders=new HttpHeaders({
      'Content-Type': 'application/json;charset="utf-8',
      'Authorization': 'Bearer '+localStorage.getItem("token")
    })
    let direccion = this.url+"/materias/delete/"+id
    return this.http.delete(direccion,{headers: headers})
  }
  DeleteUsuarios(id:any){
    const headers:HttpHeaders=new HttpHeaders({
      'Content-Type': 'application/json;charset="utf-8',
      'Authorization': 'Bearer '+localStorage.getItem("token")
    })
    let direccion = this.url+"/usuarios/borrar/"+id
    return this.http.delete(direccion,{headers: headers})
  }
  PostCursos(data:any){
    const headers:HttpHeaders=new HttpHeaders({
      'Authorization': 'Bearer '+localStorage.getItem("token")
    })
    let direccion = this.url+"/cursos/add"
    return this.http.post(direccion,data,{headers: headers})
  }
  PostMaterias(data:any){
    const headers:HttpHeaders=new HttpHeaders({
      'Authorization': 'Bearer '+localStorage.getItem("token")
    })
    let direccion = this.url+"/materias/add"
    return this.http.post(direccion,data,{headers: headers})
  }
  PostUsuarios(data:any){
    const headers:HttpHeaders=new HttpHeaders({
      'Authorization': 'Bearer '+localStorage.getItem("token")
    })
    let direccion = this.url+"/usuarios/agregar"
    return this.http.post(direccion,data,{headers: headers})
  }
}

