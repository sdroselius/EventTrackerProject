import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BookService } from '../../services/book.service';
import { SortPipe } from '../../pipes/sort.pipe';
import { FilterPipe } from '../../pipes/filter.pipe';
import { TitlePipe } from '../../pipes/title.pipe';
import { AuthorService } from '../../services/author.service';
import { Author } from '../../models/author';
import { AuthorPipe } from '../../pipes/author.pipe';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    SortPipe,
    FilterPipe,
    TitlePipe,
    AuthorPipe
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  books: Book[] = [];
  authors: Author[] = [];
  sortParam: string | null = 'author';
  authorId: number | null = null;
  filterType: string | null = null;
  filterParam: string | null = null;
  titleParam: string | null = null;
  selectedBook: Book | null = null;
  newBook: Book = new Book();
  editBook: Book | null = null;
  addingBook: boolean = false;

  constructor(
    private bookService: BookService,
    private authorService: AuthorService
  ) {}

  ngOnInit(): void {
    this.loadBooks();
    this.loadAuthors();
  }

  loadBooks() {
    this.bookService.index().subscribe( {
      next: (bookList) => {
        this.books = bookList;
      },
      error: (err) => {
        console.error('BookListComponent.loadBooks: error');
        console.error(err);
      }
    } );
  }

  loadAuthors() {
    this.authorService.index().subscribe( {
      next: (authorList) => {
        this.authors = authorList;
      },
      error: (err) => {
        console.error('BookListComponent.loadAuthors: error');
        console.error(err);
      }
    } );
  }

  getBookCount() {
    return this.books.length;
  }

  displayBook(book: Book) {
    this.selectedBook = book;
  }

  displayList() {
    this.selectedBook = null;
    this.addingBook = false;
  }

  goToAddBook() {
    this.addingBook = true;
  }

}
