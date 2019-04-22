import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomePageComponent} from './home-page/home-page.component';
import {CreatePostComponent} from './create-post/create-post.component';
import {DetailPostComponent} from './detail-post/detail-post.component';
import {MotelPageComponent} from './motel-page/motel-page.component';
import {HousePageComponent} from './house-page/house-page.component';
import {SearchPageComponent} from './search-page/search-page.component';
import {UpdatePostComponent} from './update-post/update-post.component';
import {UserPageComponent} from './user-page/user-page.component';

const routes: Routes = [
  {path: 'user', component: UserPageComponent},
  {path: 'cap-nhat', component: UpdatePostComponent},
  {path: 'ket-qua', component: SearchPageComponent},
  {path: 'nha-nguyen-can', component: HousePageComponent},
  {path: 'phong-tro', component: MotelPageComponent},
  {path: 'bai-viet', component: DetailPostComponent},
  {path: 'dang-tin', component: CreatePostComponent},
  {path: '', redirectTo: '/user', pathMatch: 'full'},
  {path: 'trang-chu', component: HomePageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
