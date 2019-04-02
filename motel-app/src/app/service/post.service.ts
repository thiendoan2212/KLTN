import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PostDTO} from '../model/postDTO';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private apiUrl = '/api';

  constructor(private http: HttpClient) {
  }

  getAllPost(): Observable<PostDTO[]> {
    return this.http.get<PostDTO[]>(this.apiUrl + '/posts');
  }

  getAllPostApproved(): Observable<PostDTO[]> {
    return this.http.get<PostDTO[]>(this.apiUrl + '/posts/approved/true');
  }
}
