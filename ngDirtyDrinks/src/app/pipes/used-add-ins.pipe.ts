import { Pipe, PipeTransform } from '@angular/core';
import { DirtyDrink } from '../models/dirty-drink';
import { AddIn } from '../models/add-in';

@Pipe({
  name: 'usedAddIns'
})
export class UsedAddInsPipe implements PipeTransform {

  transform(addIns: AddIn[], drink: DirtyDrink ): AddIn[] {
    let filtered: AddIn[] = [...addIns];
    for (let i = 0; i < filtered.length; i++) {
      if (drink.dirtyDrinkAddIns.some((a) => {
        return a.addIn.id === filtered[i].id;
      })) {
        filtered.splice(i,1);
        i--;
      }

    }
    return filtered;
  }

}
