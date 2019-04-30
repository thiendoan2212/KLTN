import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {PostService} from '../service/post.service';
import {PostDTO} from '../model/postDTO';
import {ToiletName} from '../model/ToiletName';
import {AccomodationDTO} from '../model/accomodationDTO';
import {CommentDTO} from '../model/commentDTO';
import {CommentService} from '../service/comment.service';
import {PaginationDTO} from '../model/paginationDTO';

@Component({
  selector: 'app-detail-post',
  templateUrl: './detail-post.component.html',
  styleUrls: ['./detail-post.component.scss']
})
export class DetailPostComponent implements OnInit {
  postDTO: PostDTO = new PostDTO();
  accomodationDTO: AccomodationDTO = new AccomodationDTO();
  paginationDTO = new PaginationDTO();
  commentDTOs: CommentDTO[];
  errorMessage: '';
  ToiletName = ToiletName;
  util = ' ';
  zoom = 15;
  idPost: number;
  page = 1;
  totalElements: number;
  commentDTO: CommentDTO = new CommentDTO();

  constructor(private activatedRoute: ActivatedRoute,
              private postService: PostService,
              private commentService: CommentService) {
  }

  ngOnInit() {
    this.getPostById();
  }

  getPostById() {
    this.activatedRoute.queryParams.subscribe(params => {
      this.idPost = params.id;
    });
    this.postDTO.accomodationDTO = this.accomodationDTO;
    this.postService.getPostById(this.idPost).subscribe(
      data => {
        this.postDTO = data;
      },
      error => {
        this.errorMessage = error.error.message;
      }
    );
    this.getComment();
    if (this.postDTO.accomodationDTO.parking) {
      this.util += 'Chỗ để xe';
    }
    if (this.postDTO.accomodationDTO.internet) {
      this.util += ', Internet';
    }
    if (this.postDTO.accomodationDTO.airConditioner) {
      this.util += ', Điều hòa';
    }
    if (this.postDTO.accomodationDTO.cableTV) {
      this.util += ', Truyền hình cáp';
    }
    if (this.postDTO.accomodationDTO.tv) {
      this.util += ', Tivi';
    }
    if (this.postDTO.accomodationDTO.heater) {
      this.util += ', Máy nước nóng';
    }
    if (this.util.startsWith(' , ')) {
      this.util = this.util.substring(2);
    }
  }

  getComment() {
    this.commentService.getComment(this.idPost, this.page - 1).subscribe(
      data => {
        this.paginationDTO.content = data;
        this.commentDTOs = this.paginationDTO.content.content;
        this.totalElements = this.paginationDTO.content.totalElements;
        console.log(data);
      },
      error => {
        this.errorMessage = error.error.message;
      }
    );
  }

  getPage(page: number) {
    this.page = page;
    this.getComment();
  }

  createComment() {
    this.commentDTO.idPost = this.idPost;
    // this.commentDTO.idUser = this.user.id;
    this.commentService.createComment(this.commentDTO);
  }
}
