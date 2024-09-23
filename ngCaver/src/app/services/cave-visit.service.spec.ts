import { TestBed } from '@angular/core/testing';

import { CaveVisitService } from './cave-visit.service';

describe('CaveVisitService', () => {
  let service: CaveVisitService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CaveVisitService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
