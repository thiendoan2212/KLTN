import { TestBed } from '@angular/core/testing';

import { SearchStorageService } from './search-storage.service';

describe('SearchStorageService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SearchStorageService = TestBed.get(SearchStorageService);
    expect(service).toBeTruthy();
  });
});
