import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Post} from '../../api/model/Post';
import {PostService} from '../../api/service/post.service';
import {Page} from '../../api/model/Page';
import {NzNotificationService} from 'ng-zorro-antd';

@Component({
  selector: 'app-post-list',
  templateUrl: './post-list.component.html',
  styleUrls: ['post-list.component.less']
})
export class PostListComponent implements OnInit {

  @Input('filterBy') filterBy: any = '*';

  @Output('loadComplete') loadDataComplete = new EventEmitter<boolean>();

  page: Page<any> = new Page<any>();

  loading = false;

  data: Post[] = [];

  getData = this.postService.getAllPosts;

  disableBtnAction = false;

  userId: number = null;

  constructor(private postService: PostService,
              private notification: NzNotificationService) {

  }

  ngOnInit(): void {
    switch (this.filterBy) {
      case 'WAITING':
        this.getData = this.postService.getWaitingPosts;
        break;
      case 'APPROVED':
        this.getData = this.postService.getApprovedPosts;
        break;
      case 'BLOCKED':
        this.getData = this.postService.getBlockedPosts;
        break;
      case '*':
        this.getData = this.postService.getAllPosts;
        break;
      default:
        this.userId = +this.filterBy;
        this.getData = this.loadDataFilterUserId;
    }
    this.page.totalElements = 0;
    this.page.number = 0;

    this.loadData(1);
  }

  loadData(page) {
    this.loading = true;
    this.getData(page - 1)
      .subscribe((value: Page<Post>) => {
          this.data = value.content;
          this.loadDataComplete.emit((page == 1 && this.data.length > 0) || page > 1);
          value.content = [];
          this.page = value;
          this.loading = false;
        },
        error => {
          this.loading = false;
        });
  }

  loadDataFilterUserId(page: number) {
    return this.postService.getPostOfUser(this.userId, page);
  }

  encodeDescription(text: string): string {
    let preElement = document.createElement('pre');
    preElement.innerHTML = text;
    return preElement.innerText;
  }

  approvePost(id) {
    this.disableBtnAction = true;
    this.postService.approvePostById(id)
      .subscribe((value: Post) => {
        this.notification.success('Duyệt bài', `Bài viết "${value.title}" đã được kiểm duyệt.`);
        this.disableBtnAction = false;
        this.loadData(1);
      }, error => {
        this.disableBtnAction = false;
      });
  }
}
