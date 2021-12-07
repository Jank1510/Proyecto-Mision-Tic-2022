import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactenosComponent } from './componentes/body/contactenos/contactenos.component';
import { DocentesComponent } from './componentes/body/admin-docentes/docentes.component';
import { InicioComponent } from './componentes/body/inicio/inicio.component';
import { HimnoComponent } from './componentes/body/quienes-somos/himno/himno.component';
import { HistoriaComponent } from './componentes/body/quienes-somos/historia/historia.component';
import { MisionComponent } from './componentes/body/quienes-somos/mision/mision.component';
import { ObjetivosComponent } from './componentes/body/quienes-somos/objetivos/objetivos.component';
import { VisionComponent } from './componentes/body/quienes-somos/vision/vision.component';
import { AgregarRecursoComponentDocentes } from './componentes/body/admin-docentes/docentes/agregar-recurso/agregar-recurso.component';
import { SeccionRecursosComponentDocentes } from './componentes/body/admin-docentes/docentes/seccion-recursos/seccion-recursos.component';
import { CursosComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/cursos/cursos.component';
import { MateriasComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/materias/materias.component';
import { NoticiasComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/noticias/noticias.component';
import { SugerenciasComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/sugerencias/sugerencias.component';
import { UsuariosComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/usuarios/usuarios.component';
import { BotonesSeccionesComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/botones-secciones/botones-secciones.component';
import { ComponenteDeRecargaComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/componente-de-recarga/componente-de-recarga.component';
import { AgregarNoticiasComponent } from './componentes/body/admin-docentes/admin/agregar-recursos/agregar-noticias/agregar-noticias.component';
import { AgregarUsuariosComponent } from './componentes/body/admin-docentes/admin/agregar-recursos/agregar-usuarios/agregar-usuarios.component';
import { VigilanteGuard } from './vigilante.guard';

const routes: Routes = [
  { path: 'mision', component: MisionComponent },
  { path: 'vision', component: VisionComponent },
  { path: 'objetivos', component: ObjetivosComponent },
  { path: 'historia', component: HistoriaComponent },
  { path: 'himno', component: HimnoComponent },
  { path: 'inicio', component: InicioComponent },
  { path: 'contactenos', component: ContactenosComponent },
  { path: 'docentes', component: DocentesComponent },
  { path: 'agregar-recurso-docentes', component: AgregarRecursoComponentDocentes, canActivate:[VigilanteGuard] },
  { path: 'seccion-recursos-docentes', component: SeccionRecursosComponentDocentes , canActivate:[VigilanteGuard] },
  { path: 'seccion-recursos-curso-admin', component: CursosComponent },
  { path: 'seccion-recursos-materias-admin', component: MateriasComponent },
  { path: 'seccion-recursos-noticias-admin', component: NoticiasComponent },
  { path: 'seccion-recursos-sugerencias-admin', component: SugerenciasComponent },
  { path: 'seccion-recursos-usuarios-admin', component: UsuariosComponent },
  { path: 'seccion-recursos-botones-admin', component: BotonesSeccionesComponent },
  { path: 'recarga', component: ComponenteDeRecargaComponent },
  { path: 'agregar-noticias', component: AgregarNoticiasComponent },
  { path:  'agregar-usuario', component: AgregarUsuariosComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
