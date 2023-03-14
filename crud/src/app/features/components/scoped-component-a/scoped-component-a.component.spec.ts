import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ScopedComponentAComponent } from './scoped-component-a.component';

describe('ScopedComponentAComponent', () => {
  let component: ScopedComponentAComponent;
  let fixture: ComponentFixture<ScopedComponentAComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ScopedComponentAComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ScopedComponentAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
