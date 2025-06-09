import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { environment } from '../../environments/environment';
import { Destination } from '../models/destination';
import { DiveSite } from '../models/dive-site';

@Injectable({
  providedIn: 'root'
})
export class DiveSiteService {
  private url = environment.baseUrl + 'api/diveSites';
  private destUrl = environment.baseUrl + 'api/destinations';

  constructor(
    private http: HttpClient,
  ) { }

  index(): Observable<DiveSite[]> {
    return this.http.get<DiveSite[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        throw new Error("DestinationService.index(): error retrieving destinations: " + err);
      })
    );
  }

  indexForDestination(destId: number): Observable<DiveSite[]> {
    return this.http.get<DiveSite[]>(`${this.destUrl}/${destId}`).pipe(
      catchError((err: any) => {
        console.log(err);
        throw new Error("DestinationService.indexForDestination(): error retrieving destinations: " + err);
      })
    );
  }


}
