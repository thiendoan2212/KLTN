import {ChangeDetectorRef, Component, Inject, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Signup} from '../model/signup';
import {Signin} from '../model/signin';
import {NB_AUTH_OPTIONS, NbAuthOAuth2JWTToken, NbAuthService, NbLoginComponent, NbLogoutComponent} from '@nebular/auth';
import {MatDialog, MatDialogRef} from '@angular/material';
import {LoginComponent} from '../login/login.component';
import {User} from '../model/user';
import {LogoComponent} from 'angular-bootstrap-md';
import {RegisterComponent} from '../register/register.component';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {
  errorLogin = false;
  dialogLogin: MatDialogRef<LoginComponent>;
  dialogRegister: MatDialogRef<RegisterComponent>;
  user: User;

  constructor(public dialog: MatDialog,
              private authService: NbAuthService,
              private router: Router
  ) {
    // super(authService, options, router);
  }

  ngOnInit() {
    this.authService.onTokenChange().subscribe((token: NbAuthOAuth2JWTToken) => {
      if (token.isValid()) {
        this.user = token.getPayload().account;
        this.dialog.closeAll();
        // this.dialogRef.close();
      } else {
        this.errorLogin = true;
      }
    });
  }

  navigateToCreatePost() {
    if (this.user) {
      this.router.navigate(['/create-post']);
    } else {
      this.dialogLogin = this.dialog.open(LoginComponent, {
        hasBackdrop: true,
        height: '370px',
        width: '500px',
      });
    }
  }

  navigateToUser(idUser: number) {
    this.router.navigate(['/user'], {queryParams: {id: idUser}, skipLocationChange: false});
  }

  login() {
    this.dialogLogin = this.dialog.open(LoginComponent, {
      hasBackdrop: true,
      height: '370px',
      width: '500px',
    });
  }

  register() {
    this.dialogRegister = this.dialog.open(RegisterComponent, {
      hasBackdrop: true,
      height: '430px',
      width: '500px',
    });
  }
}
