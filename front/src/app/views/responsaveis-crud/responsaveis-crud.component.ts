import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

@Component({
  selector: 'app-responsaveis-crud',
  templateUrl: './responsaveis-crud.component.html',
  styleUrls: ['./responsaveis-crud.component.css']
})
export class ResponsaveisCrudComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navigateToResponsaveisCreate(): void {
    this.router.navigate(['/responsaveis/create'])
  }
}
