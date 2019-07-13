import {Component, EventEmitter, HostListener, OnInit, Output} from '@angular/core';
import {NbAuthOAuth2JWTToken, NbAuthService} from '@nebular/auth';
import {DomSanitizer} from '@angular/platform-browser';
import {defaultAvatar} from '../../config';
import {UserService} from '../../api/service/user.service';
import {User} from '../../api/model/User';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.less']
})
export class HeaderComponent implements OnInit {

  inputSearch = '';
  user: User;
  isCollapsed = false;

  @Output('collapse')
  changeCollapse = new EventEmitter<boolean>();

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    if (window.innerWidth < 992) {
      this.isCollapsed = true;
      this.changeCollapse.emit(this.isCollapsed);
    }
  }

  avatar: any = defaultAvatar;

  constructor(private authService: NbAuthService,
              private  userService: UserService,
              private _sanitizer: DomSanitizer) {

    this.authService.onTokenChange()
      .subscribe((token: NbAuthOAuth2JWTToken) => {
        if (token.isValid()) {
          this.user = token.getPayload()['account'];

          this.userService.getAvatar(this.user.id)
            .subscribe(avatar => {
              if (avatar.data != null && avatar.data != '')
                this.avatar = this._sanitizer.bypassSecurityTrustResourceUrl('data:image/jpeg;base64, ' + avatar.data);
              else
                this.avatar = defaultAvatar;
            });
        }
      });
  }

  ngOnInit() {
  }

  /** custom trigger can be TemplateRef **/
  changeTrigger(): void {
    this.isCollapsed = !this.isCollapsed;
    this.changeCollapse.emit(this.isCollapsed);
  }
}
