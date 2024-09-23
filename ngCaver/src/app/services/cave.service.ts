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

  show(caveId: number): Observable<Cave> {
    return this.http.get<Cave>(`${this.url}/${caveId}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('CaveService.show(): error retrieving caves: ' + err)
        );
      })
    );
  }

  create(newCave: Cave): Observable<Cave> {
    return this.http.post<Cave>(this.url, newCave).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('CaveService.create(): error posting cave: ' + err)
        );
      })
    );
  }

  update(updatingCave: Cave): Observable<Cave> {
    return this.http.put<Cave>(`${this.url}/${updatingCave.id}`, updatingCave).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('CaveService.update(): error putting cave: ' + err)
        );
      })
    );
  }

  destroy(caveId: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${caveId}`).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('CaveService.destroy(): error deleting cave: ' + err)
        );
      })
    );
  }

}
