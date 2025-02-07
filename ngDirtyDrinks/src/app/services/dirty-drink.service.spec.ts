import { TestBed } from '@angular/core/testing';

import { DirtyDrinkService } from './dirty-drink.service';

describe('DirtyDrinkService', () => {
  let service: DirtyDrinkService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DirtyDrinkService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
