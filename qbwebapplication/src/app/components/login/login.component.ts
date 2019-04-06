import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {RestService} from '../../services/rest/rest.service';

import {AuthService, GoogleLoginProvider, SocialUser} from 'angularx-social-login';
import {AuthenticationService} from '../../services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: SocialUser;
  loggedIn: boolean;

  constructor(private authService: AuthService) {
  }


  ngOnInit() {
    this.authService.authState.subscribe((user) => {
      this.user = user;
      this.loggedIn = (user != null);
    });
  }
  signInWithGoogle(): void {
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID).then((data)=>{
      console.log(data)
    });
  }

  signOut(): void {
    this.authService.signOut();
  }
}
