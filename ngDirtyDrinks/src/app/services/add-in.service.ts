import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from '../../environments/environment';
import { DirtyDrink } from '../models/dirty-drink';
import { AddIn } from '../models/add-in';

@Injectable({
  providedIn: 'root'
})
export class AddInService {
 private url = environment.baseUrl + "api/addIns";

  constructor(
    private http: HttpClient,
  ) {}

  index(): Observable<AddIn[]> {
    return this.http.get<AddIn[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error(
              "AddInService.index(): error retrieving AddIn list: " + err
            )
        );
      })
    );
  }


}
