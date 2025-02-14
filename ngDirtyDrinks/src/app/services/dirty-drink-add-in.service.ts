import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from '../../environments/environment';
import { AddIn } from '../models/add-in';
import { DirtyDrinkAddIn } from '../models/dirty-drink-add-in';

@Injectable({
  providedIn: 'root'
})
export class DirtyDrinkAddInService {

   private url = environment.baseUrl + "api/dirtyDrinks";

    constructor(
      private http: HttpClient,
    ) {}

    addToDirtyDrink(drinkId: number, addInId: number, ddAddIn: DirtyDrinkAddIn): Observable<DirtyDrinkAddIn> {
      return this.http.post<DirtyDrinkAddIn>(`${this.url}/${drinkId}/addIns/${addInId}`,ddAddIn).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () =>
              new Error(
                "DirtyDrinkAddInService.addToDirtyDrink(): error posting DirtyDrinkAddIn: " + err
              )
          );
        })
      );
    }

    update(drinkId: number, addInId: number, ddAddIn: DirtyDrinkAddIn): Observable<DirtyDrinkAddIn> {
      return this.http.put<DirtyDrinkAddIn>(`${this.url}/${drinkId}/addIns/${addInId}`,ddAddIn).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () =>
              new Error(
                "DirtyDrinkAddInService.update(): error posting DirtyDrinkAddIn: " + err
              )
          );
        })
      );
    }

    removeFromDirtyDrink(drinkId: number, addInId: number): Observable<void> {
      return this.http.delete<void>(`${this.url}/${drinkId}/addIns/${addInId}`).pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () =>
              new Error(
                "DirtyDrinkAddInService.removeFromDirtyDrink(): error posting DirtyDrinkAddIn: " + err
              )
          );
        })
      );
    }

}
