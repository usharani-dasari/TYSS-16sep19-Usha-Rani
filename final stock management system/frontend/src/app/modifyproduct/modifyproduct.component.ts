import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-modifyproduct',
  templateUrl: './modifyproduct.component.html',
  styleUrls: ['./modifyproduct.component.css']
})
export class ModifyproductComponent implements OnInit , OnDestroy {
  error: string;
  constructor(private http: HttpClient) { }

  ngOnInit() {
  }
  modifyProduct(form) {
    this.http.put<any>('http://localhost:8080/modifyproduct', form.value).subscribe(response => {
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
