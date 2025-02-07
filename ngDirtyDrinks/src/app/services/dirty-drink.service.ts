import { Injectable } from "@angular/core";
import { environment } from "../../environments/environment";
import { HttpClient } from "@angular/common/http";
import { DirtyDrink } from "../models/dirty-drink";
import { Observable, catchError, throwError } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class DirtyDrinkService {
  private url = environment.baseUrl + "api/dirtyDrinks";

  constructor(
    private http: HttpClient,
  ) {}

  index(): Observable<DirtyDrink[]> {
    return this.http.get<DirtyDrink[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
            new Error(
              "DirtyDrinkService.index(): error retrieving drink list: " + err
            )
        );
      })
    );
  }


}
