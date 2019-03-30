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


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomePageComponent,
    TruncatePipe
  ],
  imports: [
    FormsModule,
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    MDBBootstrapModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
