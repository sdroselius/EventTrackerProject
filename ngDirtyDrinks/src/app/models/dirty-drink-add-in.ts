import { AddIn } from "./add-in";
import { DirtyDrink } from "./dirty-drink";
import { DirtyDrinkAddInId } from "./dirty-drink-add-in-id";

export class DirtyDrinkAddIn {
  id: DirtyDrinkAddInId;
  addIn: AddIn;
  dirtyDrink: DirtyDrink;
  amount: number;
  amountUnit: string;

  constructor(
    id: DirtyDrinkAddInId = new DirtyDrinkAddInId(),
    addIn: AddIn = new AddIn(),
    dirtyDrink: DirtyDrink = new DirtyDrink(),
    amount: number = 0,
    amountUnit: string = '',
  ){
    this.id = id;
    this.addIn = addIn;
    this.dirtyDrink = dirtyDrink;
    this.amount = amount;
    this.amountUnit = amountUnit;
  }
}
