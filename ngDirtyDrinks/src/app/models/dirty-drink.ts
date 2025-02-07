import { BaseDrink } from "./base-drink";

export class DirtyDrink {
  id: number;
  name: string;
  createDate: string;
  lastUpdate: string;
  imageUrl: string;
  brand: string;
  enabled: boolean;
  baseDrink: BaseDrink;

  constructor(
    id: number = 0,
    name: string = '',
    createDate: string = '',
    lastUpdate: string = '',
    imageUrl: string = '',
    brand: string = '',
    enabled: boolean = true,
    baseDrink: BaseDrink = new BaseDrink(),
  ) {
    this.id = id;
    this.name = name;
    this.createDate = createDate;
    this.lastUpdate = lastUpdate;
    this.imageUrl = imageUrl;
    this.brand = brand;
    this.enabled = enabled;
    this.baseDrink = baseDrink;
  }
}
