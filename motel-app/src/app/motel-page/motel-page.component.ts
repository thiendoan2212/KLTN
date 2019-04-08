import {Component, HostListener, OnInit} from '@angular/core';

@Component({
  selector: 'app-motel-page',
  templateUrl: './motel-page.component.html',
  styleUrls: ['./motel-page.component.scss']
})
export class MotelPageComponent implements OnInit {
  public innerWidth: any;

  constructor() {
  }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
  }
}
