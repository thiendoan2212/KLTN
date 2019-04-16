import {Component, HostListener, OnInit} from '@angular/core';
import {PostDTO} from '../model/postDTO';
import {PostService} from '../service/post.service';
import {ToiletName} from '../model/ToiletName';
import {Router} from '@angular/router';
import {StoragepostService} from '../service/storagepost.service';

@Component({
  selector: 'app-house-page',
  templateUrl: './house-page.component.html',
  styleUrls: ['./house-page.component.scss']
})
export class HousePageComponent implements OnInit {
  public innerWidth: any;
  postDTOs: PostDTO[];
  errorMessage: '';
  KHEP_KIN = ToiletName.KHEP_KIN;

  constructor(private postService: PostService,
              private storagepostService: StoragepostService,
              private router: Router) {
  }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
    this.getHousePost();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
  }

  getHousePost() {
    this.postService.getHousePost().subscribe(
      data => {
        this.postDTOs = data;
      },
      error => {
        this.errorMessage = error.error.message;
        console.log(this.errorMessage);
      }
    );
  }

  navigateToDetail(postDTO: PostDTO) {
    this.storagepostService.storagePostDTO(postDTO);
    this.router.navigate(['/bai-viet'], {queryParams: {title: postDTO.title}, skipLocationChange: false});
  }

  navigateToUpdate(postDTO: PostDTO) {
    this.storagepostService.storagePostDTO(postDTO);
    this.router.navigate(['/cap-nhat'], {queryParams: {title: postDTO.title}, skipLocationChange: false});
  }
}
