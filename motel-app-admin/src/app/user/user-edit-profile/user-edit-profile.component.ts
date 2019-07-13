import {Component, OnInit} from '@angular/core';
import {NzMessageService, NzNotificationService, UploadFile} from 'ng-zorro-antd';
import {Observable, Observer} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../../api/service/user.service';
import {User} from '../../api/model/User';
import {NbAuthService} from '@nebular/auth';
import {defaultAvatar} from '../../config';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './user-edit-profile.component.html',
  styleUrls: ['./user-edit-profile.component.less']
})
export class UserEditProfileComponent implements OnInit {

  loading = false;
  user: User;
  disableBtnAction = false;

  avatarUrl: any;

  constructor(private msg: NzMessageService,
              private userService: UserService,
              private authService: NbAuthService,
              private notification: NzNotificationService,
              private route: ActivatedRoute,
              private router: Router,
              private _sanitizer: DomSanitizer) {
    this.user = new User();
  }

  ngOnInit() {
    const {id} = this.route.snapshot.params;
    this.userService.getAccountById(id)
      .subscribe(value => {
        this.user = value;
        this.userService.getAvatar(id)
          .subscribe(avatar => {
            if (avatar.data != null && avatar.data != '')
              this.avatarUrl = this._sanitizer.bypassSecurityTrustResourceUrl('data:image/jpeg;base64, ' + avatar.data);
          });
      });
  }

  saveChangeProfile() {
    this.disableBtnAction = true;
    let prepareUser = new User();
    prepareUser.phone = this.user.phone;
    prepareUser.fullName = this.user.fullName;
    prepareUser.address = this.user.address;

    this.userService.updateProfile(this.user.id, prepareUser)
      .subscribe(value => {
        this.notification.success('Thay đổi thông tin', 'Thông tin cá nhân đã được thay đổi');
        this.router.navigate(['users', this.user.id, 'detail']);
      });
  }

  beforeUpload = (file: File) => {
    return new Observable((observer: Observer<boolean>) => {
      const isJPG = (file.type === 'image/jpeg' || file.type === 'image/jpg' || file.type === 'image/png');
      if (!isJPG) {
        this.msg.error('Ảnh đại diện phải thuộc định dạng PNG/JPG/JPEG');
        observer.complete();
        return;
      }
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isLt2M) {
        this.msg.error('Ảnh đại diện phải nhỏ hơn 2MB!');
        observer.complete();
        return;
      }
      // check height
      this.checkImageDimension(file).then(dimensionRes => {
        if (!dimensionRes) {
          this.msg.error('Kích thước ảnh quá nhỏ!');
          observer.complete();
          return;
        }

        observer.next(isJPG && isLt2M && dimensionRes);
        observer.complete();
      });
    });
  };

  private getBase64(img: File, callback: (img: string) => void): void {
    const reader = new FileReader();
    reader.addEventListener('load', () => callback(reader.result!.toString()));
    reader.readAsDataURL(img);
  }

  private checkImageDimension(file: File): Promise<boolean> {
    return new Promise(resolve => {
      const img = new Image(); // create image
      img.src = window.URL.createObjectURL(file);
      img.onload = () => {
        const width = img.naturalWidth;
        const height = img.naturalHeight;
        window.URL.revokeObjectURL(img.src!);
        resolve(height >= 10 && width >= 10);
      };
    });
  }

  handleChange(info: { file: UploadFile }): void {
    switch (info.file.status) {
      case 'uploading':
        this.loading = true;
        break;
      case 'done':
        // Get this url from response in real world.
        this.getBase64(info.file!.originFileObj!, (img: string) => {
          this.loading = false;
          this.avatarUrl = img;
        });
        this.msg.success('Ảnh đại điện đã được thay đổi');
        break;
      case 'error':
        this.msg.error('Đã xảy ra lỗi. Ảnh đại điện chưa được thay đổi');
        this.loading = false;
        break;
    }
  }

  deleteAvatar() {
    this.avatarUrl = null;
    this.userService.removeAvatar(this.user.id)
      .subscribe(value => {
        this.avatarUrl = null;
        // console.log(value);
      });
  }
}
