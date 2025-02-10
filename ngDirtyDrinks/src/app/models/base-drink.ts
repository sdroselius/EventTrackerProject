import { Manufacturer } from "./manufacturer";

export class BaseDrink {
  id: number;
  name: string;
  brand: string;
  imageUrl: string;
  manufacturer: Manufacturer | null;

  constructor(
    id: number = 0,
    name: string = '',
    brand: string = '',
    imageUrl: string = '',
    manufacturer: Manufacturer = new Manufacturer(),
  ){
    this.id = id;
    this.name = name;
    this.brand = brand;
    this.imageUrl = imageUrl;
    this.manufacturer = manufacturer;
  }
}
