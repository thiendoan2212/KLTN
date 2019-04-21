import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CommentDTO} from '../model/commentDTO';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private apiUrl = '/api';

  constructor(private http: HttpClient) {
  }

  getComment(idPost: number, page: number): Observable<CommentDTO[]> {
    return this.http.get<CommentDTO[]>(this.apiUrl + '/comments/post/' + idPost + '?page=' + page);
  }

}
