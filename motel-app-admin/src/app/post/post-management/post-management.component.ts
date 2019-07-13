/* entryComponents: NzDemoTabContentLazyComponent,NzDemoTabContentEagerlyComponent */
import {Component, TemplateRef, ViewChild} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {PostService} from '../../api/service/post.service';
import {Action} from '../../api/model/Action';
import {Page} from '../../api/model/Page';
import {tap} from 'rxjs/operators';

@Component({
  selector: 'app-post-management',
  templateUrl: './post-management.component.html',
  styleUrls: ['post-management.component.css']
})
export class PostManagementComponent {

  @ViewChild('more')
  pendingTemp: TemplateRef<any>;

  pending: any;

  positionTop = true;

  tabIndex = 0;

  actions: Action[] = [];

  ACTION_COLOR = {
    APPROVE: 'blue',
    CREATE: 'green',
    BLOCK: 'red'
  };

  hasWaitingPosts = true;

  currentPage = 0;

  constructor(private route: ActivatedRoute, private postService: PostService) {
    this.pending = this.pendingTemp;
  }

  ngOnInit(): void {
    this.tabIndex = this.route.snapshot.queryParams.tab;
    this.loadAction();
  }

  loadAction() {
    this.postService.getActions(this.currentPage, -1)
      .pipe(tap((value: any) => {
        if (value.last) this.pending = false;
        else{
          this.currentPage++;
          this.pending = this.pendingTemp;
        }
      }))
      .subscribe((value: Page<Action>) => {
        this.actions.push(...value.content);
      });
  }

  loadWaitingPostTabComplete($event) {
    this.hasWaitingPosts = $event;
  }

  fomatDateTime(dt: number[]) {
    return `${dt[3]}:${dt[4]} ${dt[2]}/${dt[1]}/${dt[0]}`;
  }

}
