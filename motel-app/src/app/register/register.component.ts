import {Component, OnInit} from '@angular/core';
import {User} from '../model/user';
import {MatDialog} from '@angular/material';
import {LoginComponent} from '../login/login.component';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  user: User = new User();
  errorEmail = false;

  constructor(private dialog: MatDialog) {
  }

  ngOnInit() {
  }

  submitRegister() {
    if (this.user.email === '' || !this.user.email) {
      this.errorEmail = true;
    }
  }

  login() {
    this.dialog.closeAll();
    this.dialog.open(LoginComponent, {
      hasBackdrop: true,
      height: '370px',
      width: '500px',
    });
  }

  close() {
    this.dialog.closeAll();
  }
}
