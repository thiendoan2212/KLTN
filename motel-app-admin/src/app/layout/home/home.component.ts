import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {LoginComponent} from '../login/login.component';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {NbRoleProvider} from '@nebular/security';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeComponent implements OnInit {


  title = '';
  LOGO = 'XómTrọHCM';
  isCollapsed = false;
  triggerTemplate: TemplateRef<void> | null = null;
  @ViewChild('trigger') customTrigger: TemplateRef<void>;

  isVisible = false;
  temp: TemplateRef<LoginComponent> | null = null;


  constructor(private router: Router,
              private route: ActivatedRoute,
              private roleService: NbRoleProvider) {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.title = this.route.root.firstChild.snapshot.data['title'];
      }
    });
  }


  ngOnInit(): void {
  }

  showLoginBox() {
    this.isVisible = true;
  }

  collapse($event) {
    this.isCollapsed = $event;
    this.LOGO = (this.isCollapsed) ? '' : 'XómTrọHCM';
  }

}
