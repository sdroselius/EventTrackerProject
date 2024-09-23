import { TestBed } from '@angular/core/testing';

import { FormationTypeService } from './formation-type.service';

describe('FormationTypeService', () => {
  let service: FormationTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FormationTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
