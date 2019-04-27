import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {MatDialogRef} from '@angular/material';
import {NbAuthService, NbLoginComponent} from '@nebular/auth';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent extends NbLoginComponent {
  errorEmail = false;

  // constructor(service: NbAuthService, options: {}, cd: ChangeDetectorRef, router: Router) {
  //   super(service, options, cd, router);
  // }

  forgot() {
    if (this.user.email === '' || !this.user.email) {
      this.errorEmail = true;
      console.log(this.errorEmail);
    }
  }

  submitLogin(signIn: NgForm) {
    if (signIn.valid) {
      this.login();
    } else {
      console.log('no');
    }
  }

}
