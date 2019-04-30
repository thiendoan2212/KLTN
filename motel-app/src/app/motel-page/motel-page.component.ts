import {Component, HostListener, OnInit} from '@angular/core';
import {PostService} from '../service/post.service';
import {PostDTO} from '../model/postDTO';
import {ToiletName} from '../model/ToiletName';
import {Router} from '@angular/router';
import {PaginationDTO} from '../model/paginationDTO';


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
  paginationDTO = new PaginationDTO();
  totalElements: number;
  page = 1;

  constructor(private postService: PostService,
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
    // this.paginationDTO.content = this.postDTOs;
    this.postService.getMotelPost(this.page - 1).subscribe(
      data => {
        this.paginationDTO.content = data;
        this.postDTOs = this.paginationDTO.content.content;
        this.totalElements = this.paginationDTO.content.totalElements;
      },
      error => {
        this.errorMessage = error.error.message;
        console.log(this.errorMessage);
      }
    );
  }

  getPage(page: number) {
    this.page = page;
    this.getMotelPost();
  }

  navigateToDetail(postDTO: PostDTO) {
    this.router.navigate(['/post'], {queryParams: {id: postDTO.id, title: postDTO.title}, skipLocationChange: false});
  }
}
