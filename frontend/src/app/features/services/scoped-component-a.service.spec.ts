import { TestBed } from '@angular/core/testing';

import { ScopedComponentAService } from './scoped-component-a.service';

describe('ScopedComponentAService', () => {
  let service: ScopedComponentAService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ScopedComponentAService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
