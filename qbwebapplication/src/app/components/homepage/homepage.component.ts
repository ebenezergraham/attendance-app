import {Component, OnInit, ViewChild} from '@angular/core';
import {SessionDetail} from '../../models/SessionDetail';
import {CountdownComponent} from 'ngx-countdown';
import {SpreadsheetService} from '../../services/file/spreadsheet.service';
import {RestService} from '../../services/rest/rest.service';
import {Md5} from 'ts-md5';
import {AuthenticationService} from '../../services/authentication.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  isGenerated = false;
  sessionDetail: SessionDetail = new SessionDetail();
  @ViewChild(CountdownComponent) counter: CountdownComponent;
  timeLeft;
  user;
  constructor(private auth: AuthenticationService, private spreadsheetService: SpreadsheetService, private restService: RestService) {
  }

  ngOnInit(): void {
    this.user = this.auth.user;
  }

  exportToSpreadsheet() {
    this.restService.getAttendance('test').subscribe((response) => {
      this.spreadsheetService.exportAsExcelFile(response, 'test');
    });
  }

  generateQRCode() {
    this.sessionDetail.qrCodeId = Md5.hashStr(`${this.sessionDetail.facilitatorName}-${this.sessionDetail.sessionName}-${this.sessionDetail.qrCodeExpiration}`).toString();
    console.log(this.sessionDetail.qrCodeId);
    this.isGenerated = true;
    const tmp = this.sessionDetail.qrCodeExpiration.split(':');
    this.timeLeft = (parseInt(tmp[0]) * 3600) + (parseInt(tmp[1]) * 60) + (parseInt(tmp[2]));
  }

  onStart() {

  }

  onResume() {
    this.counter.resume();
  }

  onStop() {
    this.isGenerated = false;
    this.counter.stop();
  }

  onRestart() {
    this.counter.restart();
  }

  onPause() {
    this.counter.pause();
  }

  onNotify(event) {

  }

  onFinished() {
    this.isGenerated = false;

  }

}
