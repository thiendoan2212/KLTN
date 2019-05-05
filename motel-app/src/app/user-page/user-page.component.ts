import {Component, HostListener, OnInit} from '@angular/core';
import {AccountService} from '../service/account.service';
import {ActivatedRoute} from '@angular/router';
import {User} from '../model/user';
import {PostDTO} from '../model/postDTO';
import {PostService} from '../service/post.service';
import {PaginationDTO} from '../model/paginationDTO';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.scss']
})
export class UserPageComponent implements OnInit {
  public innerWidth: any;
  idUser: number;
  user: User;
  paginationDTO = new PaginationDTO();
  postDTOs: PostDTO[];
  totalElements: number;
  page = 1;
  errorMessage = '';

  constructor(private accountService: AccountService,
              private activatedRoute: ActivatedRoute,
              private postService: PostService) {
  }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
    this.getUserById();
    this.getPostByIdUser();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
  }

  getUserById() {
    this.activatedRoute.queryParams.subscribe(params => {
      this.idUser = params.id;
    });
    this.accountService.getUserById(this.idUser).subscribe(res => {
      this.user = res;
    });
  }

  getPage(page: number) {
    this.page = page;
    this.getPostByIdUser();
  }

  getPostByIdUser() {
    this.activatedRoute.queryParams.subscribe(params => {
      this.idUser = params.id;
    });
    this.postService.getPostByIdUser(this.idUser, this.page - 1).subscribe(data => {
        this.paginationDTO.content = data;
        this.postDTOs = this.paginationDTO.content.content;
        console.log(data);
        this.totalElements = this.paginationDTO.content.totalElements;
      },
      error => {
        this.errorMessage = error.message;
      }
    );
  }

}
