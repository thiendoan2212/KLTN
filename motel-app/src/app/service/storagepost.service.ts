import {Injectable} from '@angular/core';
import {PostDTO} from '../model/postDTO';

@Injectable({
  providedIn: 'root'
})
export class StoragepostService {
  // postDTO: PostDTO;
  key = 'postDTO';
  constructor() {
  }

  storagePostDTO(postDTO: PostDTO) {
    localStorage.removeItem(this.key);
    localStorage.setItem(this.key, JSON.stringify(postDTO));
    // this.postDTO = postDTO;
  }

  getStoragePostDTO() {
    return JSON.parse(localStorage.getItem(this.key));
  }
}
