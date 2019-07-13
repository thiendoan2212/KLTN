import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PostManagementComponent} from './post/post-management/post-management.component';
import {UserListComponent} from './user/user-list/user-list.component';
import {PostDetailComponent} from './post/post-detail/post-detail.component';
import {UserDetailComponent} from './user/user-detail/user-detail.component';
import {UserEditProfileComponent} from './user/user-edit-profile/user-edit-profile.component';
import {UserCreateNewComponent} from './user/create-new/user-create-new.component';
import {UserSecurityComponent} from './user/user-security/user-security.component';
import {HomeComponent} from './layout/home/home.component';
import {LoginComponent} from './layout/login/login.component';
import {LogoutComponent} from './layout/logout/logout.component';
import {AuthGuard} from './api/util/auth-guard.service';
import {RoleGuard} from './api/util/role-guard.service';

const routes: Routes = [
  {path: '', component: HomeComponent, canActivate: [AuthGuard], data: {breadcrumb: 'Trang chính', title: 'Trang chính'},
    children:[

      {path: 'users', component: UserListComponent, canActivate: [RoleGuard],
        data: {breadcrumb: 'Quản lý người dùng', title: 'Danh sách người dùng'}},
      {path: 'users', canActivateChild: [RoleGuard],
        data: {breadcrumb: 'Quản lý người dùng', title: 'Danh sách người dùng'},
        children: [
          {path: ':id/detail', component: UserDetailComponent, data: {breadcrumb: 'Thông tin cá nhân', title: 'Thông tin người dùng'}},
          {path: ':id/detail', data: {breadcrumb: 'Thông tin cá nhân', title: 'Thông tin người dùng'},
            children: [
              {path: 'edit', component: UserEditProfileComponent, data: {breadcrumb: 'Chỉnh sửa thông tin', title: 'Chỉnh sửa thông tin người dùng'}},
              {path: 'security', component: UserSecurityComponent, data: {breadcrumb: 'Bảo mật tài khoản', title: 'Thay đổi mật khẩu'}}
            ]},
          {path: 'add', component: UserCreateNewComponent, data: {breadcrumb: 'Tạo mới người dùng', title: 'Tạo mới người dùng'}}
        ]
      },

      {path: 'posts', component: PostManagementComponent, data: {breadcrumb: 'Quản lý bài đăng', title: 'Danh sách bài đăng'}},
      {path: 'posts', data: {breadcrumb: 'Quản lý bài đăng', title: 'Danh sách bài đăng'},
        children: [
          {path: ':id/detail', component: PostDetailComponent, data: {breadcrumb: 'Chi tiết bài đăng', title: 'Chi tiết bài đăng'}}
        ]},
      {path: '', redirectTo: '/posts', pathMatch: 'full'}
    ]
  },

  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
