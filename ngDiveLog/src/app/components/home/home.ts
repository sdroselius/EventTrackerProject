import { Component, OnInit } from '@angular/core';
import { Destination } from '../../models/destination';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DestinationService } from '../../services/destination-service';
import { DiveSite } from '../../models/dive-site';
import { DiveSiteService } from '../../services/dive-site-service';

@Component({
  selector: 'app-home',
  imports: [CommonModule, FormsModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home implements OnInit {

  destinations: Destination[] = [];
  diveSites: DiveSite[] = [];
  newDiveSite: DiveSite = new DiveSite();
  editDiveSite: DiveSite | null = null;

  showDestinations: boolean = true;
  showDiveSites: boolean = false;
  selectedDestination: Destination | null = null;
  selectedSite: DiveSite | null = null;
  showNewSiteForm: boolean = false;

  constructor(
    private destinationService: DestinationService,
    private diveSiteService: DiveSiteService,
  ) {}

  ngOnInit(): void {
    this.loadDestinations();
  }

  loadDestinations(): void {
    this.destinationService.index().subscribe({
      next: (destList) => {
        this.destinations = destList;
      },
      error: (badnews) => {
        console.error('Home.loadDestinations: error getting destinations');
        console.error(badnews);
      }
    });
  }

  loadDiveSites(destId: number): void {
    this.diveSiteService.indexForDestination(destId).subscribe({
      next: (siteList) => {
        this.diveSites = siteList;
      },
      error: (badnews) => {
        console.error('Home.loadDiveSites: error getting dive sites for destination ' + destId);
        console.error(badnews);
      }
    });
  }

  showDestinationDetails(dest: Destination): void {
    this.selectedDestination = dest;
  }

  showDiveSite(siteId: number): void {
//TODO
  }

}
