import {Component, HostListener, OnInit} from '@angular/core';
import {AccountService} from '../service/account.service';
import {ActivatedRoute, Router} from '@angular/router';
import {User} from '../model/user';
import {PostDTO} from '../model/postDTO';
import {PostService} from '../service/post.service';
import {PaginationDTO} from '../model/paginationDTO';
import {MatDialog, MatDialogRef} from '@angular/material';
import {UpdateUserComponent} from '../update-user/update-user.component';
import {NbAuthOAuth2JWTToken, NbAuthService} from '@nebular/auth';
import {ChangePassComponent} from '../change-pass/change-pass.component';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.scss']
})
export class UserPageComponent implements OnInit {
  public innerWidth: any;
  idUser: number;
  user: User;
  auth: User;
  paginationDTO = new PaginationDTO();
  postDTOs: PostDTO[];
  totalElements: number;
  page = 1;
  errorMessage = '';
  updateDialog: MatDialogRef<UpdateUserComponent>;
  changePassDialog: MatDialogRef<ChangePassComponent>;

  constructor(private accountService: AccountService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private postService: PostService,
              private authService: NbAuthService,
              private dialog: MatDialog) {
  }

  ngOnInit() {
    this.authService.onTokenChange().subscribe((token: NbAuthOAuth2JWTToken) => {
      if (token.isValid()) {
        this.auth = token.getPayload().account;
      }
    });
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
        this.totalElements = this.paginationDTO.content.totalElements;
      },
      error => {
        this.errorMessage = error.error.message;
        console.log(this.errorMessage);
      }
    );
  }

  navigateToDetail(postDTO: PostDTO) {
    this.router.navigate(['/post'], {queryParams: {id: postDTO.id}, skipLocationChange: false});
  }

  openModalUpdateUser() {
    this.updateDialog = this.dialog.open(UpdateUserComponent, {
      hasBackdrop: true,
      maxHeight: '400px',
      width: '500px',
    });
    this.updateDialog.afterClosed().subscribe(a => {
      this.getUserById();
    });
  }

  openModalChangePass() {
    this.changePassDialog = this.dialog.open(ChangePassComponent, {
      hasBackdrop: true,
      maxHeight: '450px',
      width: '500px'
    });
  }
}
