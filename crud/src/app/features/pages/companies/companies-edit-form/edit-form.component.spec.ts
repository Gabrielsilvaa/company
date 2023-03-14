import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompaniesEditFormComponent } from './edit-form.component';

describe('EditFormComponent', () => {
  let component: CompaniesEditFormComponent;
  let fixture: ComponentFixture<CompaniesEditFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompaniesEditFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CompaniesEditFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
