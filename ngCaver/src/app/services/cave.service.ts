import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Cave } from '../models/cave';

@Injectable({
  providedIn: 'root'
})
export class CaveService {

  url = environment.baseUrl + "api/caves";

  constructor(
    private http: HttpClient
  ) { }

  index(): Observable<Cave[]> {
    return this.http.get<Cave[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('CaveService.index(): error retrieving caves: ' + err)
        );
      })
    );
  }

  // TODO: retrieve, create, update, destroy methods
}
