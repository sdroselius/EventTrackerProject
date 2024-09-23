import { Component, inject, OnInit } from '@angular/core';
import { CaveService } from '../../services/cave.service';
import { errorContext } from 'rxjs/internal/util/errorContext';
import { Cave } from '../../models/cave';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { FormationType } from '../../models/formation-type';
import { FormationTypeService } from '../../services/formation-type.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  private formationTypeService = inject(FormationTypeService);
  caves: Cave[] = [];
  formationTypes: FormationType[] = [];
  selected: Cave | null = null;
  newCave: Cave = new Cave();
  editCave: Cave | null = null;

  constructor(
    private caveService: CaveService
  ) {}

  ngOnInit(): void {
    this.loadFormationTypes();
    this.reloadCaves();
  }

  loadFormationTypes(): void {
    this.formationTypeService.index().subscribe( {
      next: (types) => {
        this.formationTypes = types;
      },
      error: (fail) => {
        console.error('HomeComponent.loadFormationTypes: error retrieving cave list');
        console.error(fail);
      }
    } );
  }

  reloadCaves(): void {
    this.caveService.index().subscribe( {
      next: (caveList) => {
        this.caves = caveList;
      },
      error: (fail) => {
        console.error('HomeComponent.reloadCaves: error retrieving cave list');
        console.error(fail);
      }
    } );
  }

  displayCave(cave: Cave):void {

  }

  //TODO detail div with selected cave
  //TODO form to create new cave
  //TODO update form
  //TODO delete button - where? in list or detail view?
  //TODO Models for FormationType, CaveVisit, User

  deleteCave(caveId: number): void {

  }
}
