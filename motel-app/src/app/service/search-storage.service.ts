import {Injectable} from '@angular/core';
import {SearchForm} from '../model/searchForm';

@Injectable({
  providedIn: 'root'
})
export class SearchStorageService {
  private searchForm: SearchForm;

  constructor() {
  }

  storageSearchForm(searchForm: SearchForm) {
    this.searchForm = searchForm;
  }

  getSearchForm(): SearchForm {
    return this.searchForm;
  }
}
