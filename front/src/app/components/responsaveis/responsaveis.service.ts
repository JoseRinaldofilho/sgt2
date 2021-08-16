import { Injectable } from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import {HttpClient} from "@angular/common/http";
import {Responsaveis} from "./responsaveis.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ResponsaveisService {

  baseUrl = "http://localhost:8080/responsaveis"

  constructor(private snackBar: MatSnackBar, private http: HttpClient) { }

  showMessage(msg: string): void{
    this.snackBar.open(msg, 'X',{
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top"
    })
  }

  create(responsaveis : Responsaveis): Observable<Responsaveis>{
    return this.http.post<Responsaveis>(this.baseUrl, responsaveis)
  }

  read(): Observable<Responsaveis[]> {
      return this.http.get<Responsaveis[]>(this.baseUrl)
  }
}
