import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {User} from '../model/User';
import {Observable} from 'rxjs/internal/Observable';
import {Page} from '../model/Page';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }

  getAllApproverAccounts(page: number,  accountType: string[]): Observable<Page<User>> {
    return this.http.get<Page<User>>(`/api/users?page=${page}&role=${accountType.join(',')}`);
  }

  getAccountById(id: number): Observable<User> {
    return this.http.get<User>(`/api/users/${id}`);
  }

  updateProfile(id: number, user: User): Observable<User> {
    return this.http.put<User>(`/api/users/${id}`, user);
  }

  blockAccount(id: number): Observable<User> {
    return this.http.put<User>(`/api/users/${id}/block`, null);
  }

  unBlockAccount(id: number): Observable<User> {
    return this.http.put<User>(`/api/users/${id}/unblock`, null);
  }

  changePassword(id: number, newPassword: string): Observable<User> {
    return this.http.post<User>(`/api/users/${id}/password`, null,
      {
        params: {
          password: newPassword,
        }
      });
  }

  checkExistEmail(email: string): Observable<boolean> {
    return this.http.get<boolean>(`/api/users/check?email=${email}`);
  }

  registerAccount(account: any) {
    return this.http.post<any>(`/api/users`, account);
  }

  getAvatar(id: number): Observable<any> {
    return this.http.get<any>(`/api/users/${id}/avatar`);
  }

  uploadAvatar(id: number, avatar: any) {
    return this.http.post(`/api/users/${id}/avatar`, avatar);
  }

  removeAvatar(id: number) {
    return this.http.delete(`/api/users/${id}/avatar`);
  }

  changeRole(id: number, role: string) {
    return this.http.put(`/api/users/${id}/role`, [role]);
  }
}
