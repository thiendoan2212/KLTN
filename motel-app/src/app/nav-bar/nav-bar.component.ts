import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {
  isLoggedIn = false;
  showModal = false;
  showSignup = false;

  constructor() {
  }

  ngOnInit() {
  }

  ClickedOut(event) {
    if (event.target.className === 'modal fade show') {
      this.showModal = false;
      this.showSignup = false;
    }
  }
}
