import {Component, HostListener, OnInit} from '@angular/core';
import {PostService} from '../service/post.service';
import {PostDTO} from '../model/postDTO';
import {ToiletName} from '../model/ToiletName';
import {StoragepostService} from '../service/storagepost.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-motel-page',
  templateUrl: './motel-page.component.html',
  styleUrls: ['./motel-page.component.scss']
})
export class MotelPageComponent implements OnInit {
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
    this.getMotelPost();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
  }

  getMotelPost() {
    this.postService.getMotelPost().subscribe(
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
}
