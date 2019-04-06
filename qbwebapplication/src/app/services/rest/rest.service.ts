import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {SessionDetail} from '../../models/SessionDetail';
import {SocialUser} from 'angularx-social-login';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  readonly api = 'api';
  readonly v1 = 'v1';
  readonly endpoint = `${this.api}/${this.v1}`;

  constructor(private http: HttpClient) {
  }
  static headerWithCredentials(): object {
    return {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'withCredentials': 'true',
        'Authorization': `Bearer ${window.sessionStorage.getItem('token')}`
      })
    };
  }

  static header(): object {
    return {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    };
  }

  postSession(sessionDetail: SessionDetail): Observable<any> {
    return this.http.post(this.endpoint+'/session',{},RestService.header()).pipe(
      tap(data => console.log(`posted SessionDetails`)),
      catchError(this.handleError('postSession', []))
    );
  }

  getAttendance(qrCodeId: String): Observable<any> {
    return this.http.get(this.endpoint+'/attendance',RestService.header()).pipe(
      tap(data => console.log(`posted SessionDetails`)),
      catchError(this.handleError('postSession', []))
    );
  }

  login(user: SocialUser): Observable<any> {
    return this.http.post(this.endpoint,{},RestService.header()).pipe(
      tap(data => console.log(`posted login`)),
      catchError(this.handleError('login', []))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      console.log(`${operation} failed: ${error.message}`);
      return of(result as T);
    };
  }
}
