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
    searchForm.priceStart *= 1000000;
    searchForm.priceEnd *= 1000000;
    console.log(this.searchForm);
  }

  getSearchForm(): SearchForm {
    return this.searchForm;
  }
}
