import {Component, OnInit} from '@angular/core';
import {User} from '../model/user';
import {AccountService} from '../service/account.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MatDialog} from '@angular/material';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.scss']
})
export class UpdateUserComponent implements OnInit {
  user: User = new User();
  idUser: number;

  constructor(private accountService: AccountService,
              private activatedRoute: ActivatedRoute,
              private dialog: MatDialog,
              private router: Router) {
  }

  ngOnInit() {
    this.getUserById();
  }

  getUserById() {
    this.activatedRoute.queryParams.subscribe(params => {
      this.idUser = params.id;
    });
    this.accountService.getUserById(this.idUser).subscribe(res => {
        this.user = res;
      }, error => {
        console.log(error.message);
      }
    );
  }

  submit() {
    this.accountService.updateProfile(this.user.id, this.user).subscribe(data => {
      this.dialog.closeAll();
      // window.location.reload();
      // this.getUserById();
    });
  }

  close() {
    this.dialog.closeAll();
  }
}
