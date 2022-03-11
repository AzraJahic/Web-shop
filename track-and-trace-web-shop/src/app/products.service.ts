import { Product } from './products.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DiscountProducts } from './discountProducts.model';
import { Client } from './client.model';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  constructor(private http: HttpClient) { }

  productsUrl="http://localhost:8080/WebShopApp/"
  
  getAll(): Observable<HttpResponse<Product[]>>{
    return this.http.get<Product[]>(
      `${this.productsUrl}allProducts`, {observe:'response'}
    );
  }

  getNewProducts(): Observable<HttpResponse<Product[]>>{
    return this.http.get<Product[]>(
      `${this.productsUrl}allProducts?onlyNewProducts=true`, {observe: 'response'}
    );
  }

  getAllDiscountProducts(): Observable<HttpResponse<DiscountProducts[]>>{
    return this.http.get<DiscountProducts[]>(
      `${this.productsUrl}AllCouponsServlet`, {observe: 'response'}
    );
  }

  sendMessageToServer(clientMessage:Client):Observable<Client>{
    return this.http.post<Client>(
      `${this.productsUrl}ClienMessageServlet`, clientMessage
    );
  } 

}
