export class Country {
  countryCode: string;
  name: string;
  imageUrl: string;
  flagImageUrl: string;

  constructor(
    countryCode: string = "",
    name: string = "",
    imageUrl: string = "",
    flagImageUrl: string = ""
  ) {
    this.countryCode = countryCode;
    this.name = name;
    this.imageUrl = imageUrl;
    this.flagImageUrl = flagImageUrl;
  }
}
