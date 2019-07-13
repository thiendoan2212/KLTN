import {Injectable} from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import {NbAuthService} from '@nebular/auth';
import {mergeMap, tap} from 'rxjs/operators';
import {NbAccessChecker} from '@nebular/security';
import {NzMessageService} from 'ng-zorro-antd';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private authService: NbAuthService,
              private checker: NbAccessChecker,
              private message: NzMessageService,
              private router: Router) {
  }

  canActivate() {
    return this.authService.isAuthenticatedOrRefresh()
      .pipe(
        mergeMap(auth => {
          if (!auth) {
            this.message.error('Hết phiên đăng nhập');
            this.router.navigate(['/login']);
          }
          return this.checker.isGranted('view', 'list_posts');
        }), tap(auth => {
          if (!auth) {
            this.message.error('Không có quyền truy cập');
            this.router.navigate(['/login']);
          }
        }));
  }
}
