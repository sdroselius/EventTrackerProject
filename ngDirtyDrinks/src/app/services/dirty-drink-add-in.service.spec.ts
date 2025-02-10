import { TestBed } from '@angular/core/testing';

import { DirtyDrinkAddInService } from './dirty-drink-add-in.service';

describe('DirtyDrinkAddInService', () => {
  let service: DirtyDrinkAddInService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DirtyDrinkAddInService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
