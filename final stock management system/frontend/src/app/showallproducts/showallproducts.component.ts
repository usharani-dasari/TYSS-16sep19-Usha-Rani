import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-showallproducts',
  templateUrl: './showallproducts.component.html',
  styleUrls: ['./showallproducts.component.css']
})
export class ShowallproductsComponent implements OnInit {
  orderedPros: any[] = [];
  orderInfo: object;
  returnedOrderDetails;
  numOfProducts;
  products;
  constructor(private http: HttpClient) {
    http.get<any>('http://localhost:8080/getallproducts').subscribe(response => {
      console.log(response);
      this.products = response.products;
    });
  }
  clicked(product) {
    console.log(product);
    this.orderedPros.push(product);
  }
  getBill() {
    this.orderInfo = {
      orderedProducts: this.orderedPros
    };
    this.http.post<any>('http://localhost:8080/addtocart', this.orderInfo).subscribe(response => {
      console.log(response);
      this. returnedOrderDetails = response.orderInfo;
      this.numOfProducts = response.orderInfo.orderedProducts.length;
    });
  }

  ngOnInit() {
  }

}
