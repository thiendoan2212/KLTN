import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Signup} from '../model/signup';
import {Signin} from '../model/signin';
import {NbAuthOAuth2JWTToken, NbAuthService, NbLoginComponent} from '@nebular/auth';
import {MatDialog, MatDialogRef} from '@angular/material';
import {LoginComponent} from '../login/login.component';
import {User} from '../model/user';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {
  isLoggedIn = false;
  // showModal = false;
  // showSignup = false;
  // signUpForm: Signup = new Signup();
  // signInForm: Signin = new Signin();
  errorLogin = false;
  dialogRef: MatDialogRef<LoginComponent>;
  user: User;

  constructor(private router: Router,
              public dialog: MatDialog,
              private authService: NbAuthService) {
  }

  ngOnInit() {
    this.authService.onTokenChange().subscribe((token: NbAuthOAuth2JWTToken) => {
      if (token.isValid()) {
        this.user = token.getPayload().account;
        this.dialog.closeAll();
        // this.dialogRef.close(LoginComponent);
      } else {
        this.errorLogin = true;
      }
    });
  }

  // ClickedOut(event) {
  //   if (event.target.className === 'modal fade show') {
  //     this.showModal = false;
  //     this.showSignup = false;
  //     this.errorEmail = false;
  //   }
  // }
  //
  navigateToCreatePost() {
    // Nếu đã đăng nhập
    this.router.navigate(['/dang-tin']);
    // Nếu chưa đăng nhập => showModal = true;
  }

  onSubmitLogin() {
  }

  onSubmitRegister() {

  }

  // forgot() {
  //   if (this.signInForm.username === '' || !this.signInForm.username) {
  //     this.errorEmail = true;
  //   }
  // }

  login() {
    this.dialogRef = this.dialog.open(LoginComponent, {
      hasBackdrop: true,
      height: '370px',
      width: '500px',
    });
  }
}
