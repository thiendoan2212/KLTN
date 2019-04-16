import {Component, OnInit} from '@angular/core';
import {PostService} from '../service/post.service';
import {PostDTO} from '../model/postDTO';
import {StoragepostService} from '../service/storagepost.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  postDTOs: PostDTO[];
  errorMessage: '';

  constructor(private postService: PostService,
              private storagepostService: StoragepostService,
              private router: Router) {
  }

  ngOnInit() {
    this.getAllPost();
  }

  getAllPost() {
    this.postService.getAllPostApproved().subscribe(
      data => {
        this.postDTOs = data;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      }
    );
  }

  navigateToDetail(postDTO: PostDTO) {
    this.storagepostService.storagePostDTO(postDTO);
    this.router.navigate(['/bai-viet'], {queryParams: {title: postDTO.title}, skipLocationChange: false});
  }
}
