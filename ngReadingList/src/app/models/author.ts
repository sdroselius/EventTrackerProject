export class Author {
  id: number;
  fullName: string;
  imageUrl: string;

  constructor(
    id: number = 0,
    fullName: string = '',
    imageUrl: string = ''
  ) {
    this.id = id;
    this.fullName = fullName;
    this.imageUrl = imageUrl;
  }
}
