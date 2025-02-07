import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DirtyDrink } from '../../models/dirty-drink';
import { DirtyDrinkService } from '../../services/dirty-drink.service';

@Component({
  selector: 'app-home',
  imports: [
    CommonModule,
    FormsModule,
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  dirtyDrinks: DirtyDrink[] = [];

  constructor(
    private dirtyDrinkService: DirtyDrinkService,
  ) {}

  ngOnInit(): void {
    this.loadDirtyDrinks();
  }

  loadDirtyDrinks(): void {
    this.dirtyDrinkService.index().subscribe( {
      next: (data) => {
        this.dirtyDrinks = data;
      },
      error: (someError) => {
        console.error('HomeComponent.loadDirtyDrinks: error');
        console.error(someError);
      }
    } );
  }

}
