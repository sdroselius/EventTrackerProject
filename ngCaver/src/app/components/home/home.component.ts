import { Component, OnInit } from '@angular/core';
import { CaveService } from '../../services/cave.service';
import { errorContext } from 'rxjs/internal/util/errorContext';
import { Cave } from '../../models/cave';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

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

  caves: Cave[] = [];
  selected: Cave | null = null;
  newCave: Cave = new Cave();
  editCave: Cave | null = null;

  constructor(
    private caveService: CaveService
  ) {}

  ngOnInit(): void {
    this.reloadCaves();
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

  //TODO detail div with selected cave
  //TODO form to create new cave
  //TODO update form
  //TODO delete button - where? in list or detail view?
  //TODO Models for FormationType, CaveVisit, User
}
