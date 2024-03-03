import { Pipe, PipeTransform } from '@angular/core';
import { Book } from '../models/book';

@Pipe({
  name: 'author',
  standalone: true
})
export class AuthorPipe implements PipeTransform {

  transform(books: Book[], authorId: number | null): Book[] {
    if (!authorId) { return books; }
    return books.filter((b) => b.authors.some((a)=> a.id === authorId));
  }

}
