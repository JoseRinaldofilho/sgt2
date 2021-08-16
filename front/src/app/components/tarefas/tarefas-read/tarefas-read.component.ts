import {Component, OnInit} from "@angular/core";
import {Tarefas} from "../../tarefas/tarefas.model";
import {TarefasService} from "../tarefas.service";

@Component({
  selector: 'app-tarefas-read',
  templateUrl: './tarefas-read.component.html',
  styleUrls: ['./tarefas-read.component.css']
})
export class TarefasReadComponent implements OnInit {

  tarefas: Tarefas[] = []

  constructor(private tarefasService: TarefasService) {}

  ngOnInit(): void {
    this.tarefasService.read().subscribe(tarefas =>{
      this.tarefas = tarefas
      console.log(tarefas)
    })
  }
}
