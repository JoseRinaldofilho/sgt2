import {Injectable} from "@angular/core";
import {MatSnackBar} from "@angular/material/snack-bar";
import {HttpClient} from "@angular/common/http";
import {Tarefas} from "../tarefas/tarefas.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TarefasService {

  baseUrl = "http://localhost:8080/tarefas"

  constructor(private snackBar: MatSnackBar, private http: HttpClient) { }

  showMessage(msg: string): void{
    this.snackBar.open(msg, 'X',{
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top"
    })
  }

  create(tarefas : Tarefas): Observable<Tarefas>{
    return this.http.post<Tarefas>(this.baseUrl, tarefas)
  }

  read(): Observable<Tarefas[]> {
    return this.http.get<Tarefas[]>(this.baseUrl)
  }
}
