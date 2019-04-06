import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {CountdownModule} from 'ngx-countdown';
import {FormsModule} from '@angular/forms';
import {QRCodeModule} from 'angularx-qrcode';
import {LoginComponent} from './components/login/login.component';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';
import {AuthenticationGuard} from './services/guards/authentication.guard';
import {HomepageComponent} from './components/homepage/homepage.component';
import {NavBarComponent} from './shared/nav-bar/nav-bar.component';
import {NotFoundComponent} from './shared/not-found/not-found.component';
import {AuthenticationService} from './services/authentication.service';
import {AuthServiceConfig, GoogleLoginProvider, LoginOpt, SocialLoginModule} from 'angularx-social-login';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomepageComponent, canActivate: [AuthenticationGuard]},
  {path: '**', component: NotFoundComponent}
];

let config = new AuthServiceConfig([
  {
    id: GoogleLoginProvider.PROVIDER_ID,
    provider: new GoogleLoginProvider("880022680743-j8666ot40ivhs805t5ak2jfukebrc0p3.apps.googleusercontent.com")
  }
]);

export function provideConfig() {
  return config;
}

const googleLoginOptions: LoginOpt = {
  scope: 'profile email'
};

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomepageComponent,
    NavBarComponent,
    NotFoundComponent
  ],
  imports: [
    BrowserModule,
    NgbModule,
    CountdownModule,
    FormsModule,
    QRCodeModule,
    HttpClientModule,
    SocialLoginModule,
    RouterModule.forRoot(routes)
  ],
  providers: [
    AuthenticationGuard, AuthenticationService,
    {
      provide: AuthServiceConfig,
      useFactory: provideConfig
    }
  ],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule {

}
