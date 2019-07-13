import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Action} from '../model/Action';
import {Observable} from 'rxjs/internal/Observable';
import {Page} from '../model/Page';
import {Post} from '../model/Post';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  hostApi = '';

  constructor(private  http: HttpClient) {
  }

  getActions(page: number, id: number): Observable<Page<Action>> {
    return this.http.get<Page<Action>>(`${this.hostApi}/api/actions?page=${page}&id=${id}`);
  }

  private getPostsWithApprove(page: number, approved: boolean): Observable<Page<Post>> {
    return this.http.get<Page<Post>>(`/api/posts/approved/${approved}?page=${page}`);
  }

  getWaitingPosts = (page: number): Observable<Page<Post>> => {
    return this.http.get<Page<Post>>(`/api/posts/waiting?page=${page}`);
  };

  getBlockedPosts = (page: number): Observable<Page<Post>> => {
    return this.getPostsWithApprove(page, false);
  };

  getApprovedPosts = (page: number): Observable<Page<Post>> => {
    return this.getPostsWithApprove(page, true);
  };

  getAllPosts = (page: number): Observable<Page<Post>> => {
    return this.http.get<Page<Post>>(`/api/posts?page=${page}`);
  };

  getAllPostsByUserId = (page: number, userId: number): Observable<Page<Post>> => {
    return this.http.get<Post[]>(`/api/post/user/${userId}`)
      .pipe(map((v: Post[]) => {
        let p = new Page<Post>();
        p.content = v;
        return p;
      }));
  };

  getPostById(id: number): Observable<Post> {
    return this.http.get<Post>(`/api/post/${id}`);
  }

  blockPostById(id: number){
    return this.http.put(`/api/post/${id}/approve/false`, null);
  }

  approvePostById(id: number){
    return this.http.put(`/api/post/${id}/approve/true`, null);
  }

  getPostOfUser(userId: number, page: number): Observable<Page<Post>>{
    return this.http.get<Page<Post>>(`/api/post/user/${userId}?page=${page}`);
  }
}
