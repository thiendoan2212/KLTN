import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {MDBBootstrapModule} from 'angular-bootstrap-md';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavBarComponent} from './nav-bar/nav-bar.component';
import {HomePageComponent} from './home-page/home-page.component';
import {TruncatePipe} from './pipe/TruncatePipe';
import {SearchComponent} from './search/search.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule, MatCheckboxModule, MatFormFieldModule, MatInputModule, MatRippleModule} from '@angular/material';
import {MatTabsModule} from '@angular/material';
import {Ng5SliderModule} from 'ng5-slider';
import {OnlynumberDirective} from './directive/onlynumber.directive';
import {FooterComponent} from './footer/footer.component';
import {CreatePostComponent} from './create-post/create-post.component';
import {AngularEditorModule} from '@kolkov/angular-editor';
import {AgmCoreModule} from '@agm/core';
import {DetailPostComponent} from './detail-post/detail-post.component';
import {MotelPageComponent} from './motel-page/motel-page.component';
import {HousePageComponent} from './house-page/house-page.component';
import {SearchPageComponent} from './search-page/search-page.component';
import {FileSelectDirective} from 'ng2-file-upload';
import {MediaPreviewDirective} from './directive/MediaPreview.directive';
import {UpdatePostComponent} from './update-post/update-post.component';
import {CounterDirective} from './directive/Counter.directive';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomePageComponent,
    TruncatePipe,
    SearchComponent,
    OnlynumberDirective,
    MediaPreviewDirective,
    CounterDirective,
    FileSelectDirective,
    FooterComponent,
    CreatePostComponent,
    DetailPostComponent,
    MotelPageComponent,
    HousePageComponent,
    SearchPageComponent,
    UpdatePostComponent,
  ],
  imports: [
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyBKKUL9LFa4guJTQbouBA75Ypkd6G4DdD8'
    }),
    NgxPaginationModule,
    AngularEditorModule,
    MatFormFieldModule,
    MatInputModule,
    MatRippleModule,
    Ng5SliderModule,
    MatTabsModule,
    MatButtonModule,
    MatCheckboxModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot()
  ],
  exports: [
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatRippleModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
