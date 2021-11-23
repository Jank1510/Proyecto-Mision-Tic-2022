import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ContactenosComponent } from './componentes/body/contactenos/contactenos.component';
import { DocentesComponent } from './componentes/body/docentes/docentes.component';
import { InicioComponent } from './componentes/body/inicio/inicio.component';
import { HimnoComponent } from './componentes/body/quienes-somos/himno/himno.component';
import { HistoriaComponent } from './componentes/body/quienes-somos/historia/historia.component';
import { MisionComponent } from './componentes/body/quienes-somos/mision/mision.component';
import { ObjetivosComponent } from './componentes/body/quienes-somos/objetivos/objetivos.component';
import { VisionComponent } from './componentes/body/quienes-somos/vision/vision.component';

const routes: Routes = [
  { path: 'mision', component: MisionComponent },
  { path: 'vision', component: VisionComponent },
  { path: 'objetivos', component: ObjetivosComponent },
  { path: 'historia', component: HistoriaComponent },
  { path: 'himno', component: HimnoComponent },
  { path: 'inicio', component: InicioComponent},
  { path: 'contactenos', component: ContactenosComponent},
  { path: 'docentes', component: DocentesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
