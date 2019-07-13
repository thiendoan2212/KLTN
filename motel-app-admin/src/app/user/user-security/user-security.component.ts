import {Component, OnInit} from '@angular/core';
import {UserService} from '../../api/service/user.service';
import {ActivatedRoute} from '@angular/router';
import {FormBuilder} from '@angular/forms';
import {Location} from '@angular/common';
import {User} from '../../api/model/User';

@Component({
  selector: 'app-user-security',
  templateUrl: './user-security.component.html',
  styleUrls: ['./user-security.component.css']
})
export class UserSecurityComponent implements OnInit {

  id = -1;
  newPassword = '';
  confirmPassword = '';

  // wrongPassword = false;
  noMatchPassword = false;
  user: User;

  role = 'ROLE_USER';

  preRole = 'ROLE_USER';

  canChangeRole = false;

  loading = false;

  constructor(private userService: UserService,
              private route: ActivatedRoute,
              private location: Location,
              private fb: FormBuilder) {
    this.user = new User();
  }

  ngOnInit() {
    this.loading = true;
    this.id = +this.route.snapshot.params.id;
    this.userService.getAccountById(this.id)
      .subscribe(value => {
          this.user = value;
          this.role = (this.user.role.length <= 0) ? 'ROLE_USER' : this.user.role[0];
          this.preRole = this.role;
          this.canChangeRole = this.preRole != 'ROLE_ADMIN';
          this.loading = false;
        },
        error => {
          this.loading = false;
        });
  }

  saveChange() {
    this.userService.changePassword(this.id, this.newPassword)
      .subscribe(v => {
        this.location.back();
      }, error => {
        // this.wrongPassword = true;
      });
  }

  saveChangeRole() {
    this.userService.changeRole(this.id, this.role)
      .subscribe(v => {
        this.location.back();
      }, error => {
        this.role = this.preRole;
      });
  }
}
