import { Component, OnInit } from '@angular/core';
import {TarefasService} from "../tarefas.service";
import { Router } from "@angular/router";
import {Tarefas} from "../tarefas.model";

@Component({
  selector: 'app-tarefas-create',
  templateUrl: './tarefas-create.component.html',
  styleUrls: ['./tarefas-create.component.css']
})
export class TarefasCreateComponent implements OnInit {

  tarefa: Tarefas = {
    titulo: '',
    descricao: '',
    status: '',
    dtInicio: '',
    dtTerminoPrevisto: '',
    dtTerminoEfetivo: ''
  }

  constructor(private tarefasService: TarefasService,
              private router: Router) { }

  ngOnInit(): void {
  }

  createTarefas(): void{
    this.tarefasService.create(this.tarefa).subscribe(() =>{
      this.tarefasService.showMessage('Tarefa Criada!')
      this.router.navigate(['tarefas'])
    })
  }

  cancel(): void{
    this.router.navigate(['tarefas'])
  }
}

