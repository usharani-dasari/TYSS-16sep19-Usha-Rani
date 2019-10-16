import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-addmovie',
  templateUrl: './addmovie.component.html',
  styleUrls: ['./addmovie.component.css']
})
export class AddmovieComponent implements OnInit {
  get addmovie() {
    return this.form.get('addmovie');
  } 
  get movietitle() {
    return this.form.get('movietitle');
  }
  get movieimgurl() {
    return this.form.get('movieimgurl');
  }
  get moviedescription() {
    return this.form.get('moviedescription');
  }


  form = new FormGroup({
    addmovie : new FormControl('' , [Validators.required]),
    movietitle : new FormControl('' , [Validators.required]),
    movieimgurl : new FormControl('' , [Validators.required]),
    moviedescription : new FormControl('' , [Validators.required])
  });

  constructor() { }

  ngOnInit() {
  }
  loginData(form) {
    console.log(form);
  }

}












