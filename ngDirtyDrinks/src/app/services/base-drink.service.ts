import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from '../../environments/environment';
import { BaseDrink } from '../models/base-drink';

@Injectable({
  providedIn: 'root'
})
export class BaseDrinkService {

 private url = environment.baseUrl + "api/baseDrinks";

  constructor(
    private http: HttpClient,
  ) {}

  index(): Observable<BaseDrink[]> {
    return this.http.get<BaseDrink[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error(
              "BaseDrinkService.index(): error retrieving drink list: " + err
            )
        );
      })
    );
  }


}
