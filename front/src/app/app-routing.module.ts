import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from "./views/home/home.component";
import { ResponsaveisCrudComponent } from "./views/responsaveis-crud/responsaveis-crud.component";
import { ResponsaveisCreateComponent } from "./components/responsaveis/responsaveis-create/responsaveis-create.component";
import { TarefasCrudComponent } from "./views/tarefas-crud/tarefas-crud.component";
import { TarefasCreateComponent } from "./components/tarefas/tarefas-create/tarefas-create.component";

const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "responsaveis",
    component: ResponsaveisCrudComponent
  },
  {
    path: "tarefas",
    component: TarefasCrudComponent
  },
  {
    path: "responsaveis/create",
    component: ResponsaveisCreateComponent
  },
  {
    path: "tarefas/create",
    component: TarefasCreateComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
