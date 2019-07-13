import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {en_US, NgZorroAntdModule, NZ_I18N, NZ_ICONS, NzLayoutModule} from 'ng-zorro-antd';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {APP_BASE_HREF, registerLocaleData} from '@angular/common';
import en from '@angular/common/locales/en';
import {PostListComponent} from './post/post-list/post-list.component';
import {PostManagementComponent} from './post/post-management/post-management.component';
import {IconDefinition} from '@ant-design/icons-angular';
import * as AllIcons from '@ant-design/icons-angular/icons';
import {UserListComponent} from './user/user-list/user-list.component';
import {PostDetailComponent} from './post/post-detail/post-detail.component';
// import {CKEditorModule} from 'ngx-ckeditor';
import {CKEditorModule} from '@ckeditor/ckeditor5-angular';
import {AgmCoreModule} from '@agm/core';
import {UserEditProfileComponent} from './user/user-edit-profile/user-edit-profile.component';
import {UserDetailComponent} from './user/user-detail/user-detail.component';
import {UserCreateNewComponent} from './user/create-new/user-create-new.component';
import {UserSecurityComponent} from './user/user-security/user-security.component';
import {NB_AUTH_TOKEN_INTERCEPTOR_FILTER, NbAuthJWTInterceptor, NbAuthModule, NbOAuth2AuthStrategy} from '@nebular/auth';
import {NB_WINDOW, NbLayoutRulerService} from '@nebular/theme';
import {aclConfig, authConfig, filterRefreshTokenReq, formLoginConfig} from './config';
import {HomeComponent} from './layout/home/home.component';
import {LoginComponent} from './layout/login/login.component';
import {HeaderComponent} from './layout/header/header.component';
import {LogoutComponent} from './layout/logout/logout.component';
import {TitlePageComponent} from './layout/title-page/title-page.component';
import {NbRoleProvider, NbSecurityModule} from '@nebular/security';
import {RoleProvider} from './api/util/role.provider';
import {AuthGuard} from './api/util/auth-guard.service';
import {RoleGuard} from './api/util/role-guard.service';

registerLocaleData(en);
const antDesignIcons = AllIcons as {
  [key: string]: IconDefinition;
};
const icons: IconDefinition[] = Object.keys(antDesignIcons).map(key => antDesignIcons[key]);


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    TitlePageComponent,
    LoginComponent,
    HeaderComponent,
    LogoutComponent,

    PostListComponent,
    PostManagementComponent,
    PostDetailComponent,

    UserListComponent,
    UserDetailComponent,
    UserEditProfileComponent,
    UserCreateNewComponent,
    UserSecurityComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NgZorroAntdModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    CKEditorModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBKKUL9LFa4guJTQbouBA75Ypkd6G4DdD8'
    }),
    AppRoutingModule,
    NbAuthModule.forRoot({
      strategies: [NbOAuth2AuthStrategy.setup(authConfig)],
      forms: formLoginConfig
    }),
    NbSecurityModule.forRoot(aclConfig),
    NzLayoutModule
  ],
  providers: [
    {provide: NZ_I18N, useValue: en_US},
    {provide: NZ_ICONS, useValue: icons},
    {provide: APP_BASE_HREF, useValue: '/'},
    {provide: NB_WINDOW, useValue: window},
    {provide: HTTP_INTERCEPTORS, useClass: NbAuthJWTInterceptor, multi: true},
    {provide: NB_AUTH_TOKEN_INTERCEPTOR_FILTER, useValue: (req) => filterRefreshTokenReq(req)},
    {provide: NbRoleProvider, useClass: RoleProvider},
    AuthGuard, RoleGuard

  ],
  bootstrap: [AppComponent]
})

export class AppModule {


  // constructor(private _iconService: NzIconService) {
  //   this._iconService.fetchFromIconfont({
  //     scriptUrl: 'https://at.alicdn.com/t/font_8d5l8fzk5b87iudi.js'
  //   });
  // }
}
