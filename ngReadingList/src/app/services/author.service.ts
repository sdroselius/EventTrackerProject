import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { Observable, catchError, throwError } from 'rxjs';
import { Author } from '../models/author';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  private url = environment.baseUrl + 'api/authors';

  constructor(
    private http: HttpClient
  ) { }

  index(): Observable<Author[]> {
    return this.http.get<Author[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('AuthorService.index(): error retrieving authors: ' + err)
        );
      })
    );
  }
}
