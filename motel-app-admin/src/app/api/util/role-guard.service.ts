import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, CanActivateChild, Router, RouterStateSnapshot} from '@angular/router';
import {NbAuthOAuth2JWTToken, NbAuthService} from '@nebular/auth';
import {map, mergeMap, tap} from 'rxjs/operators';
import {NbAccessChecker} from '@nebular/security';
import {Observable} from 'rxjs/internal/Observable';
import {of} from 'rxjs/internal/observable/of';
import {NzMessageService} from 'ng-zorro-antd';

@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate, CanActivateChild {

  constructor(private authService: NbAuthService,
              private checker: NbAccessChecker,
              private message: NzMessageService,
              private router: Router) {
  }

  canActivate() {
    return this.authService.isAuthenticatedOrRefresh()
      .pipe(
        tap(auth => {
          if (!auth) {
            this.message.error('Hết phiên đăng nhập');
            this.router.navigate(['logout']);
          }
        }),
        mergeMap(auth => this.checker.isGranted('view', 'user')),
        tap(auth => {
          if (!auth) {
            this.message.error('Không có quyền truy cập');
            this.router.navigate(['/']);
          }
        }));
  }

  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
    return this.authService.isAuthenticatedOrRefresh()
      .pipe(
        tap(auth => {
          if (!auth) {
            this.message.error('Hết phiên đăng nhập');
            this.router.navigate(['logout']);
          }
        }),
        mergeMap(auth => this.checker.isGranted('view', 'user')),
        mergeMap(auth => {
          if (auth) return of(true);
          else return this.authService.getToken()
            .pipe(map((token: NbAuthOAuth2JWTToken) => {
              if (token.isValid()) {
                if (token.getPayload()['account'].id != childRoute.params.id) {
                  this.message.error('Không có quyền truy cập');
                  this.router.navigate(['/']);
                }
                return (token.getPayload()['account'].id == childRoute.params.id);
              }
              return false;
            }));
        }));
  }
}
