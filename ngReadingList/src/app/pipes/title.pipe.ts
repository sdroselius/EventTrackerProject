import { Pipe, PipeTransform } from '@angular/core';
import { Book } from '../models/book';

@Pipe({
  name: 'title',
  standalone: true
})
export class TitlePipe implements PipeTransform {

  transform(books: Book[], title: string | null): Book[] {
    if (! title) { return books; }
    return books.filter( (b) => {
      return b.title.match(title);
    });
  }

}
