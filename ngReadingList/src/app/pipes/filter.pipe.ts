import { Pipe, PipeTransform } from '@angular/core';
import { Book } from '../models/book';

@Pipe({
  name: 'filter',
  standalone: true
})
export class FilterPipe implements PipeTransform {

  transform(books: Book[], filterType: string | null, filterParam: string | null): Book[] {
    if (!filterType) {
      return books;
    }
    let filtered: Book[] = [];

    return filtered;
  }

}
