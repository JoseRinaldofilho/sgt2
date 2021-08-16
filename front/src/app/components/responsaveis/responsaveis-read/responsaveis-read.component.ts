import { Component, OnInit } from '@angular/core';
import {Responsaveis} from "../responsaveis.model";
import {ResponsaveisService} from "../responsaveis.service";

@Component({
  selector: 'app-responsaveis-read',
  templateUrl: './responsaveis-read.component.html',
  styleUrls: ['./responsaveis-read.component.css']
})
  export class ResponsaveisReadComponent implements OnInit {

    responsaveis: Responsaveis[] = []

    constructor(private responsaveisService: ResponsaveisService) {}

    ngOnInit(): void {
      this.responsaveisService.read().subscribe(responsaveis =>{
        this.responsaveis = responsaveis
        console.log(responsaveis)
      })
    }
  }
