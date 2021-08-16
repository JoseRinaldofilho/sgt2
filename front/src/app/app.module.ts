import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/template/header/header.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { FooterComponent } from './components/template/footer/footer.component';
import { NavComponent } from './components/template/nav/nav.component';
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import { HomeComponent } from './views/home/home.component';
import {MatCardModule} from "@angular/material/card";
import { ResponsaveisCrudComponent } from './views/responsaveis-crud/responsaveis-crud.component';
import { ResponsaveisCreateComponent } from './components/responsaveis/responsaveis-create/responsaveis-create.component';
import { TarefasCrudComponent } from './views/tarefas-crud/tarefas-crud.component';
import { MatButtonModule} from "@angular/material/button";
import { TarefasCreateComponent } from './components/tarefas/tarefas-create/tarefas-create.component';
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { HttpClientModule} from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import {MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { ResponsaveisReadComponent } from './components/responsaveis/responsaveis-read/responsaveis-read.component';
import { TarefasReadComponent } from './components/tarefas/tarefas-read/tarefas-read.component';
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MatNativeDateModule } from "@angular/material/core";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    HomeComponent,
    ResponsaveisCrudComponent,
    ResponsaveisCreateComponent,
    TarefasCrudComponent,
    TarefasCreateComponent,
    ResponsaveisReadComponent,
    TarefasReadComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatCardModule,
    MatButtonModule,
    MatSnackBarModule,
    HttpClientModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
