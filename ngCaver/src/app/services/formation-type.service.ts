import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { Cave } from '../models/cave';
import { FormationType } from '../models/formation-type';

@Injectable({
  providedIn: 'root'
})
export class FormationTypeService {

  url = environment.baseUrl + "api/formationTypes";

  constructor(
    private http: HttpClient
  ) { }

  index(): Observable<FormationType[]> {
    return this.http.get<FormationType[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('FormationTypeService.index(): error retrieving types: ' + err)
        );
      })
    );
  }

}
