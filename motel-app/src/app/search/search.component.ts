import {Component, HostListener, OnInit, ViewEncapsulation} from '@angular/core';
import {SearchForm} from '../model/searchForm';
import {Options} from 'ng5-slider';
import {SearchStorageService} from '../service/search-storage.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class SearchComponent implements OnInit {
  searchForm: SearchForm = new SearchForm();
  searchForm1: SearchForm = new SearchForm();
  myRadio1: number;

  priceOptions: Options = {
    floor: 0,
    ceil: 50,
    step: 0.5,
    noSwitching: true,
    hideLimitLabels: true,
    hidePointerLabels: true
  };

  priceOptions1: Options = {
    floor: 0,
    ceil: 50,
    step: 0.5,
    noSwitching: true,
    hideLimitLabels: true,
    hidePointerLabels: true
  };

  acreageOptions: Options = {
    floor: 0,
    ceil: 1000,
    step: 5,
    noSwitching: true,
    hideLimitLabels: true,
    hidePointerLabels: true
  };

  acreageOptions1: Options = {
    floor: 0,
    ceil: 1000,
    step: 5,
    noSwitching: true,
    hideLimitLabels: true,
    hidePointerLabels: true
  };
  address: string;
  zoom = 13;
  lat = 10.776111;
  lng = 106.695833;

  public innerWidth: any;

  display = 'none';

  constructor(private searchStorageService: SearchStorageService) {
  }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
    this.setValueSearchForm();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
  }

  ClickedOut(event) {
    if (event.target.className === 'modal') {
      this.display = 'none';
    }
  }

  openSearchMaps() {
    this.display = 'block';
  }

  closeSearchMaps() {
    this.display = 'none';
  }

  setValueSearchForm() {
    this.searchForm.priceStart = 0;
    this.searchForm.priceEnd = 50;
    this.searchForm.acreageStart = 0;
    this.searchForm.acreageEnd = 1000;
  }

  storageSearchForm() {
    this.searchStorageService.storageSearchForm(this.searchForm);
  }
}
