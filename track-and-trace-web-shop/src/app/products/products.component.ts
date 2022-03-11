import { ProductsService } from './../products.service';
import { Product } from './../products.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  
  product: Product;
  products: Product[] = [];

  constructor(private productsService: ProductsService) { }



  ngOnInit(): void {
    this.getAllProducts();
  }

  getAllProducts(){
    this.productsService.getAll().subscribe(response => (this.products=response.body));
  }

}
