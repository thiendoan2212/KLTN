import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PostDTO} from '../model/postDTO';
import {SearchForm} from '../model/searchForm';

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private apiUrl = '/api';
  private searchUrl: string;

  constructor(private http: HttpClient) {
  }

  searchPost(searchForm: SearchForm): Observable<PostDTO[]> {
    this.searchUrl = 'acreageStart=' + searchForm.acreageStart + '&acreageEnd=' + searchForm.acreageEnd
      + '&priceStart=' + searchForm.priceStart + '&priceEnd=' + searchForm.priceEnd;
    if (searchForm.idDistrict) {
      this.searchUrl += '&idDistrict=' + searchForm.idDistrict;
    }
    if (searchForm.motel) {
      this.searchUrl += '&motel=' + searchForm.motel;
    }

    console.log(this.searchUrl);
    return this.http.get<PostDTO[]>(this.apiUrl + '/posts/search?' + this.searchUrl);
  }

  searchPostByMaps(searchForm: SearchForm): Observable<PostDTO[]> {
    this.searchUrl = 'acreageStart=' + searchForm.acreageStart + '&acreageEnd=' + searchForm.acreageEnd
      + '&priceStart=' + searchForm.priceStart + '&priceEnd=' + searchForm.priceEnd;
    if (searchForm.idDistrict) {
      this.searchUrl += '&idDistrict=' + searchForm.idDistrict;
    }
    if (searchForm.motel) {
      this.searchUrl += '&motel=' + searchForm.motel;
    }
    if (searchForm.xCoordinate && searchForm.yCoordinate && searchForm.radius) {
      this.searchUrl += '&xCoordinate=' + searchForm.xCoordinate + '&yCoordinate='
        + searchForm.yCoordinate + '&radius=' + searchForm.radius;
    }
    return this.http.get<PostDTO[]>(this.apiUrl + '/posts/searchbymaps?' + this.searchUrl);
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
