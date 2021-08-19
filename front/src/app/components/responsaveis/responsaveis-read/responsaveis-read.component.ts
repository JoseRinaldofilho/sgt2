import {Component, OnInit, ViewChild} from '@angular/core';
import {Responsaveis} from "../responsaveis.model";
import {ResponsaveisService} from "../responsaveis.service";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {Router} from "@angular/router";



@Component({
  selector: 'app-responsaveis-read',
  templateUrl: './responsaveis-read.component.html',
  styleUrls: ['./responsaveis-read.component.css']
})
  export class ResponsaveisReadComponent implements OnInit {

    responsaveis: Responsaveis[] = []

    constructor(private responsaveisService: ResponsaveisService,
                private router: Router) {}

  displayedColumns: String[] = ["id", "nome", "email", "cpf"];
  dataSource = new MatTableDataSource<Responsaveis>(this.responsaveis);

  @ViewChild(MatPaginator) paginator!: MatPaginator;

    ngOnInit(): void {
      this.responsaveisService.read().subscribe(responsaveis =>{
        this.responsaveis = responsaveis
        console.log(responsaveis)
      })
    }


  }
// import { Component, OnInit } from '@angular/core';
// import { Product } from '../../domain/product';
// import { ProductService } from '../../service/productservice';

// @Component({
//     templateUrl: './tablebasicdemo.html'
// })
// export class TableBasicDemo implements OnInit {

//     products: Product[];

//     constructor(private productService: ProductService) { }

//     ngOnInit() {
//         this.productService.getProductsSmall().then(data => this.products = data);
//     }
// }

