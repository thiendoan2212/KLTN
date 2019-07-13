import {Component, OnInit} from '@angular/core';
import {UserService} from '../../api/service/user.service';
import {Page} from '../../api/model/Page';
import {User} from '../../api/model/User';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['user-list.component.less']
})
export class UserListComponent implements OnInit {

  page: Page<any> = new Page<any>();

  ROLE_NAME = {
    ROLE_USER: 'Khách hàng',
    ROLE_ADMIN: 'Quản trị viên',
    ROLE_MODERATOR: 'Kiểm duyệt viên'
  };

  loading = false;

  constructor(private userSerive: UserService) {
    this.page.content = [];
    this.page.totalElements = 0;
    this.page.size = 0;
    this.page.totalPages = 0;
  }

  ngOnInit(): void {
    this.loadData(1);
  }

  loadData(page: number) {
    this.loading = true;
    let filterBy = this.accountOptions.filter(item => item.checked).map(item => item.value);
    this.userSerive.getAllApproverAccounts(page - 1, filterBy)
      .subscribe((data: Page<User>) => {
          this.page = data;
          this.loading = false;
        },
        error => {
          this.loading = false;
        });
  }

  // filter account
  allChecked = true;
  indeterminate = false;
  accountOptions = [
    { label: 'Khách hàng', value: 'ROLE_USER', checked: true },
    { label: 'Kiểm duyệt viên', value: 'ROLE_MODERATOR', checked: true },
    { label: 'Quản trị viên', value: 'ROLE_ADMIN', checked: true }
  ];

  updateAllChecked(): void {
    this.indeterminate = false;
    if (this.allChecked) {
      this.accountOptions = this.accountOptions.map(item => {
        return {
          ...item,
          checked: true
        };
      });
    } else {
      this.accountOptions = this.accountOptions.map(item => {
        return {
          ...item,
          checked: false
        };
      });
    }

    this.loadData(1);
  }

  updateSingleChecked(): void {
    this.loadData(1);
    if (this.accountOptions.every(item => item.checked === false)) {
      this.allChecked = false;
      this.indeterminate = false;
    } else if (this.accountOptions.every(item => item.checked === true)) {
      this.allChecked = true;
      this.indeterminate = false;
    } else {
      this.indeterminate = true;
    }
  }
}
