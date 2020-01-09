import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  products;
  constructor(private http: HttpClient) { }

  searchProduct(form: NgForm) {
    console.log(form.value);
    this.http.get<any>(`http://localhost:8080/search/${form.value.search}`).subscribe(response => {
      console.log(response);
      this.products = response.products;
    });
  }

  ngOnInit() {
  }

}
