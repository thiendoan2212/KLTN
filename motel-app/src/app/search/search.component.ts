import {Component, HostListener, OnInit, ViewEncapsulation} from '@angular/core';
import {SearchForm} from '../model/searchForm';
import {Options} from 'ng5-slider';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss'],
  encapsulation: ViewEncapsulation.None
})
export class SearchComponent implements OnInit {
  searchForm: SearchForm = new SearchForm();
  myRadio: number;
  priceMin = 0;
  priceMax = 50;
  priceOptions: Options = {
    floor: 0,
    ceil: 50,
    step: 0.5,
    noSwitching: true,
    hideLimitLabels: true,
    hidePointerLabels: true
  };

  priceMin1 = 0;
  priceMax1 = 50;
  priceOptions1: Options = {
    floor: 0,
    ceil: 50,
    step: 0.5,
    noSwitching: true,
    hideLimitLabels: true,
    hidePointerLabels: true
  };

  acreageMin = 0;
  acreageMax = 1000;
  acreageOptions: Options = {
    floor: 0,
    ceil: 1000,
    step: 5,
    noSwitching: true,
    hideLimitLabels: true,
    hidePointerLabels: true
  };

  acreageMin1 = 0;
  acreageMax1 = 1000;
  acreageOptions1: Options = {
    floor: 0,
    ceil: 1000,
    step: 5,
    noSwitching: true,
    hideLimitLabels: true,
    hidePointerLabels: true
  };
  radius: number;
  address: string;
  zoom = 13;
  lat = 10.776111;
  lng = 106.695833;

  public innerWidth: any;

  display = 'none';

  constructor() {
  }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
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
}
