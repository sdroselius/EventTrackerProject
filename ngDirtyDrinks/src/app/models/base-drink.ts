export class BaseDrink {
  id: number;
  name: string;
  brand: string;
  imageUrl: string;

  constructor(
    id: number = 0,
    name: string = '',
    brand: string = '',
    imageUrl: string = '',
  ){
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.imageUrl = imageUrl;
  }
}
