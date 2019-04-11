import {Component, HostListener, OnInit} from '@angular/core';
import {PostService} from '../service/post.service';
import {PostDTO} from '../model/postDTO';
import {ToiletName} from '../model/ToiletName';

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

  constructor(private postService: PostService) {
  }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
    this.getMotelPost();
    console.log(this.KHEP_KIN);
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
  }

  getMotelPost() {
    this.postService.getMotelPost().subscribe(
      data => {
        this.postDTOs = data;
        console.log(this.postDTOs);
      },
      error => {
        this.errorMessage = error.error.message;
        console.log(this.errorMessage);
      }
    );
  }
}
