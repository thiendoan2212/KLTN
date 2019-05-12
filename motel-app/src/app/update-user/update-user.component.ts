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
  loading = false;
  disableSubmit = false;

  constructor(private accountService: AccountService,
              private activatedRoute: ActivatedRoute,
              private dialog: MatDialog) {
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
    this.loading = true;
    this.disableSubmit = true;
    this.accountService.updateProfile(this.user.id, this.user).subscribe(data => {
        this.dialog.closeAll();
      },
      error => {
        console.log(error.error.message);
      });
  }

  close() {
    this.dialog.closeAll();
  }
}
