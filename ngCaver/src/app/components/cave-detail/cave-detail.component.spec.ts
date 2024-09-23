import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaveDetailComponent } from './cave-detail.component';

describe('CaveDetailComponent', () => {
  let component: CaveDetailComponent;
  let fixture: ComponentFixture<CaveDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CaveDetailComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaveDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
