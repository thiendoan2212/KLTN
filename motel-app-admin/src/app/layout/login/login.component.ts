import {Component, OnInit} from '@angular/core';
import {NbAuthResult, NbLoginComponent} from '@nebular/auth';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent extends NbLoginComponent implements OnInit {
  // validateForm: FormGroup;
  //
  // submitForm(): void {
  //   for (const i in this.validateForm.controls) {
  //     this.validateForm.controls[i].markAsDirty();
  //     this.validateForm.controls[i].updateValueAndValidity();
  //   }
  // }
  //
  // constructor(private fb: FormBuilder) {}
  //
  showTip = false;

  hasError = false;

  errorMsg = 'Email hoặc mật khẩu không đúng';

  ngOnInit(): void {
    this.user.email = '';
    this.user.password = '';
  }

  login(): void {
    this.errors = [];
    this.messages = [];
    this.submitted = true;
    this.hasError = false;

    this.service.authenticate(this.strategy, this.user).subscribe((result: NbAuthResult) => {
      this.submitted = false;
      let redirect = result.getRedirect();

      if (result.isSuccess()) {
        this.messages = result.getMessages();
        let roles = result.getToken().getPayload()['account'].role;
        if (roles.includes('ROLE_MODERATOR')) redirect = '/posts';
        else if (roles.includes('ROLE_ADMIN')) redirect = '/users';
      } else {
        this.errors = result.getErrors();
        this.hasError = true;
        switch (result.getErrors().join()) {
          case 'Bad credentials':
            this.errorMsg = 'Email hoặc mật khẩu không đúng';
            break;
          case 'User account is locked':
            this.errorMsg = 'Tài khoản đã bị khóa';
            break;
          default:
            this.errorMsg = 'Đăng nhập không thành công';
        }
      }

      if (redirect) {
        setTimeout(() => {
          return this.router.navigateByUrl(redirect);
        }, this.redirectDelay);
      }
      this.cd.detectChanges();
    });
  }

}
