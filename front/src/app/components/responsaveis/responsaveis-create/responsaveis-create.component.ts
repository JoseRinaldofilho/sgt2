import { Component, OnInit } from '@angular/core';
import {ResponsaveisService} from "../responsaveis.service";
import { Router } from "@angular/router";
import {Responsaveis} from "../responsaveis.model";

@Component({
  selector: 'app-responsaveis-create',
  templateUrl: './responsaveis-create.component.html',
  styleUrls: ['./responsaveis-create.component.css']
})
export class ResponsaveisCreateComponent implements OnInit {

  responsavel: Responsaveis = {
    nome: '',
    email: '',
    cpf: ''
}


  constructor(private responsaveisService: ResponsaveisService,
              private router: Router) { }

  ngOnInit(): void {
  }

  createResposaveis(): void{
    this.responsaveisService.create(this.responsavel).subscribe(() =>{
      this.responsaveisService.showMessage('Responsável Criado!')
      this.router.navigate(['responsaveis'])
    })
  }

  cancel(): void{
    this.router.navigate(['responsaveis'])
  }
}
