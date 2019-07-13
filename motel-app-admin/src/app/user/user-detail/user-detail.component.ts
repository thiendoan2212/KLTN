import {Component, OnInit, TemplateRef, ViewChild} from '@angular/core';
import {UserService} from '../../api/service/user.service';
import {ActivatedRoute} from '@angular/router';
import {User} from '../../api/model/User';
import {NzModalService, NzNotificationService} from 'ng-zorro-antd';
import {NbAccessChecker} from '@nebular/security';
import {PostService} from '../../api/service/post.service';
import {Action} from '../../api/model/Action';
import {tap} from 'rxjs/operators';
import {Page} from '../../api/model/Page';
import {NbAuthOAuth2JWTToken, NbTokenService} from '@nebular/auth';
import {DomSanitizer} from '@angular/platform-browser';
import {defaultAvatar} from '../../config';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.less']
})
export class UserDetailComponent implements OnInit {

  user: User;

  actions: Action[] = [];

  ACTION_COLOR = {
    APPROVE: 'green',
    CREATE: 'blue',
    BLOCK: 'red'
  };

  ROLE_NAME = {
    ROLE_USER: 'Khách hàng',
    ROLE_ADMIN: 'Quản trị viên',
    ROLE_MODERATOR: 'Kiểm duyệt viên'
  };

  @ViewChild('more')
  pendingTemp: TemplateRef<any>;

  pending: any;

  currentPage = 0;

  canBlock = false;

  role = 'ROLE_USER';

  avatar: any = defaultAvatar;

  id: number;

  constructor(private userService: UserService,
              private postService: PostService,
              private modal: NzModalService,
              private notification: NzNotificationService,
              private accessChecker: NbAccessChecker,
              private tokenService: NbTokenService,
              private route: ActivatedRoute,
              private _sanitizer: DomSanitizer) {
    this.user = new User();
    this.tokenService.get().subscribe((token: NbAuthOAuth2JWTToken) => {
      this.canBlock = (token.getAccessTokenPayload()['account'].id != this.route.snapshot.params.id);
    });
  }

  ngOnInit() {
    this.route.url.subscribe(url => {
      this.id = this.route.snapshot.params.id;
      this.userService.getAccountById(this.id)
        .subscribe(value => {
          this.user = value;
          this.role = (this.user.role.length <= 0) ? 'ROLE_USER' : this.user.role[0];
          this.userService.getAvatar(this.id)
            .subscribe(avatar => {
              if (avatar.data != null && avatar.data != '')
                this.avatar = this._sanitizer.bypassSecurityTrustResourceUrl('data:image/jpeg;base64, ' + avatar.data);
              else
                this.avatar = defaultAvatar;
            });
        });
      this.loadAction(this.id);
    })
  }

  loadAction(id: number) {
    this.postService.getActions(this.currentPage, id)
      .pipe(tap((value: any) => {
        if (value.last) this.pending = false;
        else {
          this.currentPage++;
          this.pending = this.pendingTemp;
        }
      }))
      .subscribe((value: Page<Action>) => {
        this.actions.push(...value.content);
      });
  }

  confirmBlockAccount() {
    this.modal.confirm({
      nzTitle: 'Khóa tài khoản',
      nzContent: `Bạn có muốn khóa tài khoản ${this.user.email}?`,
      nzOkText: 'Khóa',
      nzOkType: 'danger',
      nzOnOk: () => this.blockAccount(true),
      nzCancelText: 'Hủy'
    });
  }

  confirmUnBlockAccount() {
    this.modal.confirm({
      nzTitle: 'Mở khóa tài khoản',
      nzContent: `Bạn có muốn mở khóa cho tài khoản ${this.user.email}?`,
      nzOkText: 'Mở khóa',
      nzCancelText: 'Hủy',
      nzOnOk: () => this.blockAccount(false),
    });
  }

  blockAccount(block: boolean) {
    if (block)
      this.userService.blockAccount(this.user.id).subscribe(value => {
        this.notification.success('Khóa tài khoản', `Tài khoản ${this.user.email} đã bị khóa`);
        this.user = value;
      });
    else
      this.userService.unBlockAccount(this.user.id).subscribe(value => {
        this.notification.success('Mở khóa tài khoản', `Tài khoản ${this.user.email} đã được mở khóa`);
        this.user = value;
      });
  }

  fomatDateTime(dt: number[]) {
    return `${dt[3]}:${dt[4]} ${dt[2]}/${dt[1]}/${dt[0]}`;
  }

}
