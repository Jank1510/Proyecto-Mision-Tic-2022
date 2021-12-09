import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { finalize, Observable } from 'rxjs';
import Swal from 'sweetalert2';
import { UloginService } from '../services/ulogin.service';

@Injectable({
  providedIn: 'root'
})
export class VigilanteDocentesGuard implements CanActivate {
  verifylogin!: boolean
  constructor(private uloginService: UloginService, private router: Router) { }


  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
      this.uloginService.VerifiLogin().pipe(finalize(() => this.validaruser())).subscribe((response: any) => {
        this.verifylogin = response
      })
    
      return true; 
  }
  validaruser() {
    if (this.verifylogin != true) {
      console.log("no es true")
      this.router.navigate(['docentes'])//si no corrio aqueya peticion y manda undefinide quiere decir q no hay ningun token valido      
      Swal.fire({
        icon: 'warning',
        title: 'Logeate Primero !'
      })

    localStorage.removeItem("token")
    localStorage.removeItem("rolUsuario")
    localStorage.removeItem("idUsuario")
    }
  }
  
}
