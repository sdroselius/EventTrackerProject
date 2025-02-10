import { TestBed } from '@angular/core/testing';

import { BaseDrinkService } from './base-drink.service';

describe('BaseDrinkService', () => {
  let service: BaseDrinkService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BaseDrinkService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
