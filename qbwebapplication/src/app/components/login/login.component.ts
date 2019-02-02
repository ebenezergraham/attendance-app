import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {RestService} from '../../services/rest/rest.service';
import {User} from '../../models/User';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    user: User = <User>{};

    constructor(private router: Router, private restService: RestService) {
    }

    ngOnInit() {
    }

    login() {
        window.sessionStorage.setItem("user", this.user.username);
        window.sessionStorage.setItem('token', '');

        return this.restService.login(this.user).subscribe(
            (response: User) => {
                window.sessionStorage.setItem('token', response.jwt);
                this.router.navigate(['/session']);
            },
            err => {
                console.error(err);
            }
        );
    }
}
