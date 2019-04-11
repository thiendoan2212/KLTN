import {Component, OnInit} from '@angular/core';
import {SearchStorageService} from '../service/search-storage.service';
import {SearchForm} from '../model/searchForm';
import {PostService} from '../service/post.service';
import {PostDTO} from '../model/postDTO';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.scss']
})
export class SearchPageComponent implements OnInit {
  searchForm: SearchForm = new SearchForm();
  postDTOs: PostDTO[];
  errorMessage = '';

  constructor(private searchStorageService: SearchStorageService,
              private postService: PostService) {
  }

  ngOnInit() {
    // this.searchPost();
  }

  // searchPost() {
  //   this.searchForm = this.searchStorageService.getSearchForm();
  //   this.postService.searchPost(this.searchForm).subscribe(
  //     data => {
  //       this.postDTOs = data;
  //       console.log('aaa' + this.postDTOs);
  //     },
  //     error => {
  //       this.errorMessage = error.error.message;
  //       console.log(this.errorMessage);
  //     }
  //   );
  // }
}
