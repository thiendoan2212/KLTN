import {Component, OnInit} from '@angular/core';
import {PostService} from '../service/post.service';
import {PostDTO} from '../model/postDTO';
import {forEach} from '@angular/router/src/utils/collection';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.scss']
})
export class HomePageComponent implements OnInit {
  postDTOs: PostDTO[];
  errorMessage: '';

  constructor(private postService: PostService) {
  }

  ngOnInit() {
    this.getAllPost();
  }

  getAllPost() {
    this.postService.getAllPost().subscribe(
      data => {
        this.postDTOs = data;
        console.log(this.postDTOs);
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
      }
    );
  }
}
