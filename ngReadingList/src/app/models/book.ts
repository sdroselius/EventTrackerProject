import { Author } from "./author";

export class Book {

  id: number;
  title: string;
  description: string;
  pages: number;
  coverImageUrl: string;
  lastFinished: string;
  authors: Author[];

  constructor(
    id: number = 0,
    title: string = '',
    description: string = '',
    pages: number = 0,
    coverImageUrl: string = '',
    lastFinished: string = '',
    authors: Author[] = []
  )  {
    this.id = id;
    this.title = title;
    this.description = description;
    this.pages = pages;
    this.coverImageUrl = coverImageUrl;
    this.lastFinished = lastFinished;
    this.authors = authors;
  }
}
