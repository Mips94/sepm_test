import {BrowserModule, HammerGestureConfig} from '@angular/platform-browser';
import {Injectable, NgModule} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {HomeComponent} from './components/home/home.component';
import {LoginComponent} from './components/login/login.component';
import {MessageComponent} from './components/message/message.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {httpInterceptorProviders} from './interceptors';
import { ErrorBannerComponent } from './components/error-banner/error-banner.component';
import { LocationListComponent } from './components/location-list/location-list.component';
import { LocationSwiperComponent } from './components/location-swiper/location-swiper.component';
import {DragDropModule} from '@angular/cdk/drag-drop';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HammerModule, HAMMER_GESTURE_CONFIG} from '@angular/platform-browser';
import * as Hammer from 'hammerjs';

@Injectable()
export class HammerConfigSwipecards extends HammerGestureConfig {
  // eslint-disable-next-line @typescript-eslint/consistent-type-assertions
  override overrides = <any> {
    swipe: { direction: Hammer.DIRECTION_HORIZONTAL },
  };
}

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    MessageComponent,
    ErrorBannerComponent,
    LocationListComponent,
    LocationSwiperComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    FormsModule,
    HammerModule,
    BrowserAnimationsModule
  ],
  providers: [
    httpInterceptorProviders,
    {
      provide: HAMMER_GESTURE_CONFIG,
      useClass: HammerConfigSwipecards,
    },
    HammerConfigSwipecards,
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
