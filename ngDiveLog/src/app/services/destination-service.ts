import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable } from 'rxjs';
import { Destination } from '../models/destination';

@Injectable({
  providedIn: 'root'
})
export class DestinationService {

  private url = environment.baseUrl + 'api/destinations';

  constructor(
    private http: HttpClient,
  ) { }

  index(): Observable<Destination[]> {
    return this.http.get<Destination[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        throw new Error("DestinationService.index(): error retrieving destinations: " + err);
      })
    );
  }


}
