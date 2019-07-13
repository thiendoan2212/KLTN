import {Component} from '@angular/core';
import {NbAuthResult, NbLogoutComponent} from '@nebular/auth';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent extends NbLogoutComponent {

  logout(strategy: string): void {
    this.service.logout(strategy).subscribe((result: NbAuthResult) => {

      setTimeout(() => {
        return this.router.navigateByUrl('/login');
      }, this.redirectDelay);

    });
  }

}
