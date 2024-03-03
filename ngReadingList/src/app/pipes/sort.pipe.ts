import { Pipe, PipeTransform } from '@angular/core';
import { Book } from '../models/book';

@Pipe({
  name: 'sort',
  standalone: true
})
export class SortPipe implements PipeTransform {
  transform(books: Book[], sortParam: string|null): Book[] {
    if (! sortParam) {
      return books;
    }
    let sorted: Book[] = [...books];
    sorted.sort( (a,b) => {
      if (sortParam === 'author') {
        return 0;
        // return a.author.fullName.localeCompare(b.author.fullName);
      }
      else {
        let result: number = 0;
        switch (typeof a[sortParam as keyof Book]) {
          case 'string':
            let astr:string = <string>a[sortParam as keyof Book];
            let bstr:string = <string>b[sortParam as keyof Book];
            result = astr.localeCompare(bstr);
            break;
          case 'number':
            result = <number>a[sortParam as keyof Book] - <number>b[sortParam as keyof Book];
            break;
        }
        return result;
      }
    });
    return sorted;
  }

}
