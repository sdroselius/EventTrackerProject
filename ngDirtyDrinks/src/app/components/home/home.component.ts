import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DirtyDrink } from '../../models/dirty-drink';
import { DirtyDrinkService } from '../../services/dirty-drink.service';
import { AddIn } from '../../models/add-in';
import { BaseDrink } from '../../models/base-drink';
import { AddInService } from '../../services/add-in.service';
import { BaseDrinkService } from '../../services/base-drink.service';
import { DirtyDrinkAddIn } from '../../models/dirty-drink-add-in';
import { DirtyDrinkAddInService } from '../../services/dirty-drink-add-in.service';

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
  baseDrinks: BaseDrink[] = [];
  addIns: AddIn[] = [];
  selectedDrink: DirtyDrink | null = null;
  editDrink: DirtyDrink | null = null;
  newDrink: DirtyDrink = new DirtyDrink();
  newDrinkAddIn: DirtyDrinkAddIn = new DirtyDrinkAddIn();
  newDirtyDrinkAddIn: DirtyDrinkAddIn = new DirtyDrinkAddIn();

  constructor(
    private dirtyDrinkService: DirtyDrinkService,
    private baseDrinkService: BaseDrinkService,
    private addInService: AddInService,
    private dirtyDrinkAddInService: DirtyDrinkAddInService,
  ) {}

  ngOnInit(): void {
    this.loadDirtyDrinks();
    this.loadBaseDrinks();
    this.loadAddIns();
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

  loadBaseDrinks(): void {
    this.baseDrinkService.index().subscribe( {
      next: (data) => {
        this.baseDrinks = data;
      },
      error: (someError) => {
        console.error('HomeComponent.loadBaseDrinks: error');
        console.error(someError);
      }
    } );
  }

  loadAddIns(): void {
    this.addInService.index().subscribe( {
      next: (data) => {
        this.addIns = data;
      },
      error: (someError) => {
        console.error('HomeComponent.loadAddIns: error');
        console.error(someError);
      }
    } );
  }

  goToDetails(drink: DirtyDrink): void {
    this.selectedDrink = drink;
  }

  goToEditDrink(drinkToEdit: DirtyDrink):void {
    this.editDrink = Object.assign({}, drinkToEdit);
  }

  displayTable() {
    this.selectedDrink = null;
    this.editDrink = null;
  }

  addNewDrink(newDrink: DirtyDrink):void {
    console.log(newDrink)
    this.dirtyDrinkService.create(newDrink).subscribe( {
      next: (data) => {
        this.goToEditDrink(data);
        this.loadDirtyDrinks();
      },
      error: (someError) => {
        console.error('HomeComponent.addNewDrink: error');
        console.error(someError);
      }
    } );
  }

  updateDrink(drink: DirtyDrink) {
    console.log(drink);
    //TODO
    //TODO re-retrieve drink after updating
  }

  deleteDrink(drinkId: number) {
    console.log(drinkId);
    //TODO
    //TODO re-retrieve drink after updating
  }

  addDirtyDrinkAddIn(ddAddIn: DirtyDrinkAddIn) {
    //TODO
    //TODO re-retrieve drink after adding
  }

  updateDirtyDrinkAddIn(ddAddIn: DirtyDrinkAddIn) {
    //TODO
    //TODO re-retrieve drink after updating
  }


  removeDirtyDrinkAddIn(ddAddIn: DirtyDrinkAddIn) {
    //TODO
    //TODO re-retrieve drink after removing
  }
}

