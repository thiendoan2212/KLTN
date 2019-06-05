import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {NotificationDTO} from '../model/notificationDTO';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  private apiUrl = '/api';

  constructor(private http: HttpClient) {
  }

  getNotificationByEmail(page: number, screen: boolean): Observable<NotificationDTO[]> {
    return this.http.get<NotificationDTO[]>(this.apiUrl + '/notification?page=' + page + '&screen=' + screen);
  }

  seenNotification(id: number): Observable<NotificationDTO> {
    return this.http.put<NotificationDTO>(this.apiUrl + '/notification/' + id, null);
  }
}
