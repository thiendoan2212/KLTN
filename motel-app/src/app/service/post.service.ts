import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {URLSearchParams} from '@angular/http';
import {PostDTO} from '../model/postDTO';
import {SearchForm} from '../model/searchForm';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private apiUrl = '/api';
  params = new URLSearchParams();

  constructor(private http: HttpClient) {
  }

  searchPost(searchForm: SearchForm): Observable<PostDTO[]> {
    // for (const key in searchForm) {
    //   this.params.set(key, searchForm[key]);
    // }
    return this.http.get<PostDTO[]>(this.apiUrl + '/posts/search');
  }

  getPostById(id: number): Observable<PostDTO> {
    return this.http.get<PostDTO>(this.apiUrl + '/post/' + id);
  }

  getAllPost(): Observable<PostDTO[]> {
    return this.http.get<PostDTO[]>(this.apiUrl + '/posts');
  }

  getAllPostApproved(): Observable<PostDTO[]> {
    return this.http.get<PostDTO[]>(this.apiUrl + '/posts/approved/true');
  }

  getMotelPost(): Observable<PostDTO[]> {
    return this.http.get<PostDTO[]>(this.apiUrl + '/posts/motel/true');
  }

  getHousePost(): Observable<PostDTO[]> {
    return this.http.get<PostDTO[]>(this.apiUrl + '/posts/motel/false');
  }
}
