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
import { UsedAddInsPipe } from "../../pipes/used-add-ins.pipe";

@Component({
  selector: 'app-home',
  imports: [
    CommonModule,
    FormsModule,
    UsedAddInsPipe
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
    this.dirtyDrinkService.update(drink.id, drink).subscribe({
      next: (updatedDrink) => {
        this.loadDirtyDrinks();
        this.selectedDrink = updatedDrink;
        this.editDrink = updatedDrink;
      },
      error: (fail) => {
        console.error('HomeComponent.updatedDrink: error updating');
        console.error(fail);
      }
    });
  }

  deleteDrink(drinkId: number) {
    console.log(drinkId);
    this.dirtyDrinkService.delete(drinkId).subscribe({
      next: (updatedDrink) => {
        this.loadDirtyDrinks();
        this.selectedDrink = null;
        this.editDrink = null;
      },
      error: (fail) => {
        console.error('HomeComponent.updatedDrink: error updating');
        console.error(fail);
      }
    });
   }

   refreshEditDrink(drinkId: number) {
    this.dirtyDrinkService.retrieve(drinkId).subscribe({
      next: (updatedDrink) => {
        this.loadDirtyDrinks();
        this.selectedDrink = updatedDrink;
        this.editDrink = updatedDrink;
      },
      error: (fail) => {
        console.error('HomeComponent.updatedDrink: error updating');
        console.error(fail);
      }
    });
   }

  addDirtyDrinkAddIn(ddAddIn: DirtyDrinkAddIn) {
    this.dirtyDrinkAddInService.addToDirtyDrink(this.editDrink!.id, ddAddIn.addIn.id, ddAddIn).subscribe({
      next: (addedAddin) => {
        this.refreshEditDrink(addedAddin.dirtyDrink.id);
      },
      error: (fail) => {
        console.error('HomeComponent.addDirtyDrinkAddIn: error adding addin');
        console.error(fail);
      }
    });
  }

  updateDirtyDrinkAddIn(ddAddIn: DirtyDrinkAddIn) {
    this.dirtyDrinkAddInService.update(ddAddIn.dirtyDrink.id, ddAddIn.addIn.id, ddAddIn).subscribe({
      next: (addedAddin) => {
        this.refreshEditDrink(ddAddIn.dirtyDrink.id);
      },
      error: (fail) => {
        console.error('HomeComponent.updateDirtyDrinkAddIn: error updating addin');
        console.error(fail);
      }
    });
  }


  removeDirtyDrinkAddIn(drinkId: number, addInId: number) {
    this.dirtyDrinkAddInService.removeFromDirtyDrink(drinkId, addInId).subscribe({
      next: () => {
        this.refreshEditDrink(this.editDrink!.id);
      },
      error: (fail) => {
        console.error('HomeComponent.removeDirtyDrinkAddIn: error removing addin');
        console.error(fail);
      }
    });
  }
}

