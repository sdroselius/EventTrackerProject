import { Country } from "./country";

export class Destination {
  id: number;
  name: string;
  description: string;
  imageUrl: string;
  country: Country;

  constructor(
  id: number = 0,
  name: string = '',
  description: string = '',
  imageUrl: string = '',
  country: Country = new Country(),
  ){
    this.id = id;
    this.name = name;
    this.description = description;
    this.imageUrl = imageUrl;
    this.country = country;
  }

}
