import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-tarefas-crud',
  templateUrl: './tarefas-crud.component.html',
  styleUrls: ['./tarefas-crud.component.css']
})
export class TarefasCrudComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navigateToTarefasCreate(): void{
    this.router.navigate(["tarefas/create"])
  }
}
