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

}
