import {Component, ViewChild} from '@angular/core';
import {SessionDetail} from './models/SessionDetail';
import {Md5} from 'ts-md5/dist/md5';
import {CountdownComponent} from 'ngx-countdown';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isGenerated = false;
  sessionDetail: SessionDetail = new SessionDetail();
  @ViewChild(CountdownComponent) counter: CountdownComponent;
  timeLeft;

  constructor(){}

  generateQRCode(){
    this.sessionDetail.qrCodeId = Md5.hashStr(`${this.sessionDetail.facilitatorName}-${this.sessionDetail.sessionName}-${this.sessionDetail.qrCodeExpiration}`).toString();
    console.log(this.sessionDetail.qrCodeId)
    this.isGenerated = true;
    const tmp = this.sessionDetail.qrCodeExpiration.split(":");
    this.timeLeft = (parseInt(tmp[0])*3600)+(parseInt(tmp[1])*60)+(parseInt(tmp[2]))
  }

  onStart() {

  }

  onResume(){
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
