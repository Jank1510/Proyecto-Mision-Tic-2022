import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

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
import { DocentesComponent } from './componentes/body/docentes/docentes.component';
import { InicioComponent } from './componentes/body/inicio/inicio.component';

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
    InicioComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
