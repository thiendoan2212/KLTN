import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ImageDTO} from '../model/ImageDTO';
import {Observable} from 'rxjs';

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
}
