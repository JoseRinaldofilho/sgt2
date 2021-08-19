import {Component, OnInit, ViewChild} from "@angular/core";
import {Tarefas} from "../../tarefas/tarefas.model";
import {TarefasService} from "../tarefas.service";
import {Router} from "@angular/router";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";

@Component({
  selector: 'app-tarefas-read',
  templateUrl: './tarefas-read.component.html',
  styleUrls: ['./tarefas-read.component.css']
})
export class TarefasReadComponent implements OnInit {

  tarefas: Tarefas[] = []
//criando as rotas
  constructor(private tarefasService: TarefasService,
              private router: Router) {}
  displayedColumns: string[] = ["id","titulo","descricao","status","dtInicio","dtTerminoPrevisto","dtTerminoEfetivo"];
  dataSource = new MatTableDataSource<Tarefas>(this.tarefas);
  // obsevar a pagina
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngOnInit(): void {
    this.tarefasService.read().subscribe(tarefas =>{
      this.tarefas = tarefas
      console.log(tarefas)
    })
  }
}
