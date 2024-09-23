import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaveEditComponent } from './cave-edit.component';

describe('CaveEditComponent', () => {
  let component: CaveEditComponent;
  let fixture: ComponentFixture<CaveEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CaveEditComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaveEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
