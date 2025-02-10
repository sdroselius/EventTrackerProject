import { BaseDrink } from "./base-drink";
import { DirtyDrinkAddIn } from "./dirty-drink-add-in";

export class DirtyDrink {
  id: number;
  name: string;
  createDate: string;
  lastUpdate: string;
  imageUrl: string;
  description: string;
  brand: string;
  enabled: boolean;
  baseDrink: BaseDrink;
  dirtyDrinkAddIns: DirtyDrinkAddIn[];

  constructor(
    id: number = 0,
    name: string = '',
    createDate: string = '',
    lastUpdate: string = '',
    imageUrl: string = '',
    description: string = '',
    brand: string = '',
    enabled: boolean = true,
    baseDrink: BaseDrink = new BaseDrink(),
    dirtyDrinkAddIns: DirtyDrinkAddIn[] = [],
  ) {
    this.id = id;
    this.name = name;
    this.createDate = createDate;
    this.lastUpdate = lastUpdate;
    this.imageUrl = imageUrl;
    this.description = description;
    this.brand = brand;
    this.enabled = enabled;
    this.baseDrink = baseDrink;
    this.dirtyDrinkAddIns = dirtyDrinkAddIns;
  }
}
