import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit , OnDestroy {
  error: string;
  constructor(private http: HttpClient) { }

  ngOnInit() {
  }
  addProduct(form) {
    this.http.post<any>('http://localhost:8080/addproduct', form.value).subscribe(response => {
      console.log(response);
      if (response.statusCode === 'Success') {
        this.error = response.description;
      } else {
        this.error = response.description;
      }
      form.reset();
    }, err => {
        console.log(err);
    });
  }
  ngOnDestroy() {
    this.error = null;
  }

}
