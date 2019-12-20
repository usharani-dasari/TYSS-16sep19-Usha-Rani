import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-showallproducts',
  templateUrl: './showallproducts.component.html',
  styleUrls: ['./showallproducts.component.css']
})
export class ShowallproductsComponent implements OnInit {
  check = false;
  products;
  constructor(private http: HttpClient) {
    http.get<any>('http://localhost:8080/getallproducts').subscribe(response => {
      console.log(response);
      this.products = response.products;
    });
  }
  clicked() {
    this.check = true;
  }

  ngOnInit() {
  }

}
