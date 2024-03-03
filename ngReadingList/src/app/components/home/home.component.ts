import { Component, OnInit } from '@angular/core';
import { Book } from '../../models/book';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BookService } from '../../services/book.service';
import { SortPipe } from '../../pipes/sort.pipe';
import { FilterPipe } from '../../pipes/filter.pipe';
import { TitlePipe } from '../../pipes/title.pipe';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    SortPipe,
    FilterPipe,
    TitlePipe
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {

  books: Book[] = [];
  sortParam: string | null = 'author';
  filterType: string | null = null;
  filterParam: string | null = null;
  titleParam: string | null = null;
  selectedBook: Book | null = null;
  newBook: Book = new Book();
  editBook: Book | null = null;
  addingBook: boolean = false;

  constructor(
    private bookService: BookService
  ) {}

  ngOnInit(): void {
    this.loadBooks();
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
