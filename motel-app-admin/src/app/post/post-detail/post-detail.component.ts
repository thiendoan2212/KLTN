import {Component, OnInit} from '@angular/core';
import * as ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import {NzNotificationService} from 'ng-zorro-antd';
import {PostService} from '../../api/service/post.service';
import {Post} from '../../api/model/Post';
import {ActivatedRoute, Router} from '@angular/router';
import {Accomodation} from '../../api/model/Accomodation';
import {tap} from 'rxjs/operators';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.less']
})
export class PostDetailComponent implements OnInit {

  contentHTML = '';

  CKEditorConfig = {
    extraPlugins: 'divarea',
    htmlEncodeOutput: false,
    entities: false,
    height: '200px',
    width: '100%',
    removePlugins: ['Bold', 'Italic']
  };

  post = new Post();

  public Editor = ClassicEditor;

  showMap = false;

  disableBtnAction = false;

  fileList = [
    {
      uid: -1,
      name: 'can-ho.png',
      status: 'done',
      url: 'http://localhost:8080/api/image/064e893a-1d69-47c5-8e07-d74a283106db'
    }
  ];

  constructor(private postService: PostService,
              private route: ActivatedRoute,
              private router: Router,
              private notification: NzNotificationService) {
    this.post.accomodationDTO = new Accomodation();
    this.post.approved = true;
    this.post.notApproved = true;
  }

  ngOnInit() {
    this.route.url.subscribe(url => {
      const {id} = this.route.snapshot.params;
      this.postService.getPostById(id)
        .pipe(tap((value: Post) => {
          value.imageStrings.map((img, i) => {
            this.fileList.push({
              uid: i,
              name: 'a' + i + '.png',
              status: 'done',
              url: img
            });
          });
        }))
        .subscribe((value: Post) => {
          this.post = value;
        });
    });
  }

  blockPost() {
    this.disableBtnAction = true;
    this.postService.blockPostById(this.post.id)
      .subscribe((value: Post) => {
        this.notification.success('Khóa bài', `Bài viết "${value.title}" đã được khóa.`);
        this.router.navigateByUrl('/posts?tab=1');
      }, error => {
        this.disableBtnAction = false;
      });
  }

  approvePost() {
    this.disableBtnAction = true;
    this.postService.approvePostById(this.post.id)
      .subscribe((value: Post) => {
        this.notification.success('Duyệt bài', `Bài viết "${value.title}" đã được kiểm duyệt.`);
        this.router.navigateByUrl('/posts?tab=1');
      }, error => {
        this.disableBtnAction = false;
      });
  }
}
