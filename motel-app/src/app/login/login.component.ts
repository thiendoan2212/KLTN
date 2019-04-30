import {ChangeDetectorRef, Component, Inject, Input, OnInit} from '@angular/core';
import {MatDialog, MatDialogRef} from '@angular/material';
import {NB_AUTH_OPTIONS, NbAuthService, NbLoginComponent} from '@nebular/auth';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {RegisterComponent} from '../register/register.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent extends NbLoginComponent {
  errorEmail = false;
  dialogRegister: MatDialogRef<RegisterComponent>;

  constructor(private dialog: MatDialog, authService: NbAuthService,
              @Inject(NB_AUTH_OPTIONS) options: {},
              cd: ChangeDetectorRef, router: Router) {
    super(authService, options, cd, router);
  }

  forgot() {
    if (this.user.email === '' || !this.user.email) {
      this.errorEmail = true;
      console.log(this.errorEmail);
    }
  }

  submitLogin(signIn: NgForm) {
    if (signIn.valid) {
      this.login();
    }
  }

  submitRegister() {
    this.dialog.closeAll();
    this.dialogRegister = this.dialog.open(RegisterComponent, {
      hasBackdrop: true,
      height: '430px',
      width: '500px',
    });
  }

  close() {
    this.dialog.closeAll();
  }
}
