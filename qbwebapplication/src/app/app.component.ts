import {Component, ViewChild} from '@angular/core';
import {SessionDetail} from './models/SessionDetail';
import {Md5} from 'ts-md5/dist/md5';
import {CountdownComponent} from 'ngx-countdown';
import {SpreadsheetService} from './services/file/spreadsheet.service';
import {RestService} from './services/rest/rest.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor() {
  }

}
