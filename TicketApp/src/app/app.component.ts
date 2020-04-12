import { AuthenticationService } from './authentication/authentication.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.less'],
})
export class AppComponent implements OnInit {
  title = 'TicketApp';
  isLogged: boolean;

  constructor(public service: AuthenticationService) {}
  ngOnInit() {
    this.service.contextChange.subscribe((res) => {
      this.isLogged = this.service.isAuthenticated();
    });
    this.isLogged = this.service.isAuthenticated();
  }
}
