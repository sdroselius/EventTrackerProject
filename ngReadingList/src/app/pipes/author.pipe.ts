import { Pipe, PipeTransform } from '@angular/core';
import { Book } from '../models/book';

@Pipe({
  name: 'author',
  standalone: true
})
export class AuthorPipe implements PipeTransform {

  transform(books: Book[], authorId: number | null): Book[] {
    if (!authorId || ''+authorId == 'null') {
      return books;
    }
    return books.filter((b) => {return b.authors.some((a) => {return a.id == authorId})});
  }

}
