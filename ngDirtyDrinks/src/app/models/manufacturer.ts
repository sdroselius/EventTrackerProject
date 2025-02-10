export class Manufacturer {
  id: number;
  name: string;
  logoImageUrl: string;
  websiteUrl: string;

  constructor(
    id: number = 0,
    name: string = '',
    logoImageUrl: string = '',
    websiteUrl: string = '',
  ){
    this.id = id;
    this.name = name;
    this.logoImageUrl = logoImageUrl;
    this.websiteUrl = websiteUrl;
  }
}
