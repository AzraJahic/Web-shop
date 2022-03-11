import { DiscountProducts } from './../discountProducts.model';
import { ProductsService } from './../products.service';
import { Component, OnInit, SecurityContext } from '@angular/core';
import { Product } from './../products.model';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.css']
})
export class StartComponent implements OnInit {

  product: Product;
  newProducts: Product[] = [];
  discountProducts: DiscountProducts[] = []; 

  constructor(
    private productsService: ProductsService
    ) { }

  ngOnInit(): void {
    this.getNewProducts();
    this.getDiscountedProducts();
  }

  getNewProducts(){
    this.productsService.getNewProducts().subscribe(response => (this.newProducts=response.body));
  }

  getDiscountedProducts(){
    this.productsService.getAllDiscountProducts().subscribe(response => (this.discountProducts=response.body));
  }

    
  }

