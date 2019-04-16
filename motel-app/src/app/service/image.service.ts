import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ImageDTO} from '../model/ImageDTO';
import {Observable} from 'rxjs';
import {Image} from '../model/image';
import {parseHttpResponse} from 'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class ImageService {
  private apiUrl = '/api';

  constructor(private http: HttpClient) {
  }

  addImageForPost(idPost: number, formData: FormData): Observable<ImageDTO[]> {
    return this.http.post<ImageDTO[]>(this.apiUrl + '/uploadImage/post/' + idPost, formData);
  }

  getImageByteByIdPost(idPost: number): Observable<Image[]> {
    return this.http.get<Image[]>(this.apiUrl + '/imageByte/post/' + idPost);
  }

  deleteAllImage(idPost: number) {
    return this.http.delete(this.apiUrl + '/deleteImage/post/' + idPost);;
  }

}
