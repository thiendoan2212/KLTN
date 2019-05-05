import {Component, OnInit} from '@angular/core';
import {User} from '../model/user';
import {MatDialog} from '@angular/material';
import {LoginComponent} from '../login/login.component';
import {Account} from '../model/account';
import {HttpClient} from '@angular/common/http';
import {AccountService} from '../account.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  account: Account = new Account();
  errorEmail = false;
  disableSubmit = false;
  showLoadding = false;
  alreadyEmail = false;
  success = false;

  constructor(private dialog: MatDialog,
              private accountService: AccountService) {
  }

  ngOnInit() {
  }

  submitRegister() {
    if (this.account.email === '' || !this.account.email) {
      this.errorEmail = true;
    } else {
      this.disableSubmit = true;
      this.showLoadding = true;
      this.accountService.checkExistUser(this.account.email).subscribe(res => {
        if (res) {
          this.alreadyEmail = res;
        } else {
          this.accountService.registerUserAccount(this.account).subscribe(account => {
            if (account.email) {
              this.success = true;
            }
          });
        }
      });
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
