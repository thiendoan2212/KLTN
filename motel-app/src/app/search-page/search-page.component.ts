import {Component, HostListener, OnInit} from '@angular/core';
import {SearchStorageService} from '../service/search-storage.service';
import {SearchForm} from '../model/searchForm';
import {PostService} from '../service/post.service';
import {PostDTO} from '../model/postDTO';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.scss']
})
export class SearchPageComponent implements OnInit {
  searchForm: SearchForm = new SearchForm();
  postDTOs: PostDTO[];
  errorMessage = '';
  public innerWidth: any;
  zoom = 14;
  lat: number;
  lng: number;
  radius: number;

  constructor(private searchStorageService: SearchStorageService,
              private postService: PostService,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.queryParams.subscribe(_ => {
      this.getParamSearchForm();
      this.searchPost();
    });
  }

  ngOnInit() {
    this.innerWidth = window.innerWidth;
    this.getParamSearchForm();
    this.searchPost();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event) {
    this.innerWidth = window.innerWidth;
  }

  searchPost() {
    if (this.searchForm.xCoordinate) {
      this.postService.searchPostByMaps(this.searchForm).subscribe(
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

    if (!this.searchForm.xCoordinate) {
      this.postService.searchPost(this.searchForm).subscribe(
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

  getParamSearchForm() {
    this.activatedRoute.queryParams.subscribe(params => {
      // @ts-ignore
      this.searchForm = params;
      this.lat = parseFloat(String(this.searchForm.xCoordinate));
      this.lng = parseFloat(String(this.searchForm.yCoordinate));
      this.radius = parseFloat(String(this.searchForm.radius));
    });
  }
}

