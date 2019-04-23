import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Signup} from '../model/signup';
import {Signin} from '../model/signin';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.scss']
})
export class NavBarComponent implements OnInit {
  isLoggedIn = false;
  showModal = false;
  showSignup = false;
  signUpForm: Signup = new Signup();
  signInForm: Signin = new Signin();

  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  ClickedOut(event) {
    if (event.target.className === 'modal fade show') {
      this.showModal = false;
      this.showSignup = false;
    }
  }

  navigateToCreatePost() {
    // Nếu đã đăng nhập
    this.router.navigate(['/dang-tin']);
    // Nếu chưa đăng nhập => showModal = true;
  }

  onSubmit() {
  }
}
