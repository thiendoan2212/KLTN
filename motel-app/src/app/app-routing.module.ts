import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomePageComponent} from './home-page/home-page.component';
import {CreatePostComponent} from './create-post/create-post.component';
import {DetailPostComponent} from './detail-post/detail-post.component';
import {MotelPageComponent} from './motel-page/motel-page.component';

const routes: Routes = [
  {path: 'phong-tro', component: MotelPageComponent},
  {path: 'bai-viet', component: DetailPostComponent},
  {path: 'dang-bai', component: CreatePostComponent},
  {path: '', redirectTo: '/phong-tro', pathMatch: 'full'},
  {path: 'trang-chu', component: HomePageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
