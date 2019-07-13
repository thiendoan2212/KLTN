import {Component, OnInit} from '@angular/core';
import {NzMessageService, NzNotificationService} from 'ng-zorro-antd';
import {UserService} from '../../api/service/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-new',
  templateUrl: './user-create-new.component.html',
  styleUrls: ['./user-create-new.component.less']
})
export class UserCreateNewComponent implements OnInit {

  loading = false;
  avatarUrl: string;

  existEmail = false;

  clicked = false;

  fileUpload: File;

  user = {
    email: '',
    password: '',
    confirmPassword: '',
    fullName: '',
    address: '',
    phone: '',
    role: 'ROLE_USER'
  };

  constructor(private msg: NzMessageService,
              private userService: UserService,
              private router: Router,
              private notification: NzNotificationService) {
  }

  ngOnInit() {
  }


  beforeUpload = (file: File) => {
    this.fileUpload = null;
    this.avatarUrl = '';
    // console.log(file);
    const isJPG = (file.type === 'image/jpeg' || file.type === 'image/jpg' || file.type === 'image/png');
    if (!isJPG) {
      this.msg.error('Ảnh đại diện phải thuộc định dạng PNG/JPG/JPEG');
      return false;
    }
    const isLt2M = file.size / 1024 / 1024 < 2;
    if (!isLt2M) {
      this.msg.error('Ảnh đại diện phải nhỏ hơn 2MB!');
      return false;
    }
    // check height
    this.checkImageDimension(file).then(dimensionRes => {
      if (!dimensionRes) {
        this.msg.error('Kích thước ảnh quá nhỏ!');
        return false;
      }
    });

    this.getBase64(file, (img: string) => {
      this.loading = false;
      this.avatarUrl = img;
    });

    this.fileUpload = file;

    return false;
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

  checkEmail() {
    this.existEmail = false;
    if (/.+@.+..+/.test(this.user.email))
      this.userService.checkExistEmail(this.user.email)
        .subscribe(value => {
          this.existEmail = value;
          // console.log(this.existEmail);
        });
  }

  submitCreate() {
    this.clicked = true;
    this.userService.registerAccount({
      email: this.user.email,
      password: this.user.password,
      fullName: this.user.fullName,
      address: this.user.address,
      phone: this.user.phone,
      role: [this.user.role]
    }).subscribe(value => {
        this.clicked = false;
        this.notification.success('Tạo mới tài khoản', `Tài khoản "${value.email}" đã được tạo.`);
        if (this.fileUpload) {
          const formData = new FormData();
          formData.append('avatar', this.fileUpload);
          this.userService.uploadAvatar(value.id, formData).subscribe(value1 => {
            // console.log(value1);
          });
        }

        this.router.navigateByUrl('/users')
      },
      error => {
        this.clicked = false;
        this.notification.error('Tạo mới tài khoản', `Đã có lỗi xảy ra. Tài khoản chưa dược tạo.`);
      });
  }
}
