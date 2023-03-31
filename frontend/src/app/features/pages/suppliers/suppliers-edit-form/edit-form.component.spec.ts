import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuppliersEditFormComponent } from './edit-form.component';

describe('EditFormComponent', () => {
  let component: SuppliersEditFormComponent;
  let fixture: ComponentFixture<SuppliersEditFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SuppliersEditFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SuppliersEditFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
