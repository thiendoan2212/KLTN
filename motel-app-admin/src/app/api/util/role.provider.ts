import {NbRoleProvider} from '@nebular/security';
import {Injectable} from '@angular/core';
import {NbAuthOAuth2JWTToken, NbAuthService} from '@nebular/auth';
import {Observable} from 'rxjs/internal/Observable';
import {map} from 'rxjs/operators';
import {Router} from '@angular/router';

@Injectable({providedIn: 'root'})
export class RoleProvider implements NbRoleProvider {

  constructor(private authService: NbAuthService,
              private router: Router) {
  }

  getRole(): Observable<string | string[]> {
    return this.authService.onTokenChange()
      .pipe(
        map((token: NbAuthOAuth2JWTToken) => {
          if (token.isValid()) {
            let roles = token.getPayload()['account'].role;
            if (roles.includes('ROLE_MODERATOR')) return 'ROLE_MODERATOR';
            else if (roles.includes('ROLE_ADMIN')) return 'ROLE_ADMIN';
          }
          return '';
        }),
      );
  }
}
