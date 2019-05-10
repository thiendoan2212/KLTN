import {Component, HostListener, OnInit} from '@angular/core';
import {SearchForm} from '../model/searchForm';
import {PostService} from '../service/post.service';
import {PostDTO} from '../model/postDTO';
import {ActivatedRoute, Router} from '@angular/router';
import {PaginationDTO} from '../model/paginationDTO';


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
  paginationDTO = new PaginationDTO();
  totalElements: number;
  page = 1;
  sort = 1;

  constructor(private postService: PostService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
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
    this.postDTOs = null;
    if (this.searchForm.xCoordinate) {
      this.postService.searchPostByMaps(this.searchForm).subscribe(
        data => {
          this.postDTOs = data;
        },
        error => {
          this.errorMessage = error.error.message;
          console.log(this.errorMessage);
        }
      );
    }

    if (!this.searchForm.xCoordinate) {
      this.postService.searchPost(this.searchForm, this.page - 1, this.sort).subscribe(
        data => {
          this.paginationDTO.content = data;
          this.postDTOs = this.paginationDTO.content.content;
          this.totalElements = this.paginationDTO.content.totalElements;
        },
        error => {
          this.errorMessage = error.error.message;
          console.log(error);
        }
      );
    }
  }

  getPage(page: number) {
    this.page = page;
    this.searchPost();
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

  navigateToDetail(postDTO) {
    this.router.navigate(['/post'], {queryParams: { id: postDTO.id, title: postDTO.title}, skipLocationChange: false});
  }
}

