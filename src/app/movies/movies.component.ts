import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  selectedMovie:string;

  constructor() { }

  ngOnInit() {
  }
getMovie(event){
  this.selectedMovie=event.target.value;
}
}
