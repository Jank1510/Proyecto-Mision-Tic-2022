import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FooterComponent } from './componentes/footer/footer.component';
import { VisionComponent } from './componentes/body/quienes-somos/vision/vision.component';
import { ObjetivosComponent } from './componentes/body/quienes-somos/objetivos/objetivos.component';
import { HistoriaComponent } from './componentes/body/quienes-somos/historia/historia.component';
import { HimnoComponent } from './componentes/body/quienes-somos/himno/himno.component';
import { MisionComponent } from './componentes/body/quienes-somos/mision/mision.component';
import { HeaderComponent } from './componentes/header/header.component';
import { ContactenosComponent } from './componentes/body/contactenos/contactenos.component';
import { DocentesComponent } from './componentes/body/admin-docentes/docentes.component';
import { InicioComponent } from './componentes/body/inicio/inicio.component';
import {UloginService} from '../app/services/ulogin.service'
import  {HttpClientModule} from '@angular/common/http'
import { AgregarRecursoComponentDocentes } from './componentes/body/admin-docentes/docentes/agregar-recurso/agregar-recurso.component';
import { SeccionRecursosComponentDocentes } from './componentes/body/admin-docentes/docentes/seccion-recursos/seccion-recursos.component';
import { SugerenciasComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/sugerencias/sugerencias.component';
import { NoticiasComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/noticias/noticias.component';
import { CursosComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/cursos/cursos.component';
import { MateriasComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/materias/materias.component';
import { UsuariosComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/usuarios/usuarios.component';
import { BotonesSeccionesComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/botones-secciones/botones-secciones.component';
import { ComponenteDeRecargaComponent } from './componentes/body/admin-docentes/admin/seccion-recursos/componente-de-recarga/componente-de-recarga.component';

import { AgregarNoticiasComponent } from './componentes/body/admin-docentes/admin/agregar-recursos/agregar-noticias/agregar-noticias.component';
import { AgregarUsuariosComponent } from './componentes/body/admin-docentes/admin/agregar-recursos/agregar-usuarios/agregar-usuarios.component';
import { RecursosComponent } from './componentes/body/recursos/recursos.component';
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    VisionComponent,
    ObjetivosComponent,
    MisionComponent,
    HistoriaComponent,
    HimnoComponent,
    HeaderComponent,
    ContactenosComponent,
    DocentesComponent,
    InicioComponent,
    AgregarRecursoComponentDocentes,
    SeccionRecursosComponentDocentes,
    SugerenciasComponent,
    NoticiasComponent,
    CursosComponent,
    MateriasComponent,
    UsuariosComponent,
    BotonesSeccionesComponent,
    ComponenteDeRecargaComponent,
    AgregarNoticiasComponent,
    AgregarUsuariosComponent,
    RecursosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UloginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
