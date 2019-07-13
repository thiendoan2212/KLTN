import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, ActivationEnd, NavigationEnd, Router} from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-title-page',
  templateUrl: 'title-page.component.html',
  styleUrls: ['title-page.component.less']
})
export class TitlePageComponent implements OnInit {

  @Input() hasSetting = false;

  title = '';

  showSetting = false;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private location: Location) {
    this.router.events.subscribe((event) => {
      if (event instanceof ActivationEnd) {
        this.title = this.route.snapshot.data['title'] || '';
      }
    });
  }

  ngOnInit() {
  }

  goBack(){
     this.location.back();
  }
}
