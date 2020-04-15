import { AuthenticationService } from './../../authentication/authentication.service';
import { UsersService } from 'src/app/service/users.service';
import { Component, OnInit, HostListener } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CheckoutComponent } from '../checkout/checkout.component';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.less'],
})
export class NavbarComponent implements OnInit {
  scrolling: boolean;
  user: any;
  isLogged: any;
  url: any;
  constructor(
    private service: UsersService,
    private authService: AuthenticationService,
    public route: Router,
    private modalService: NgbModal
  ) {
    this.scrolling = false;
  }

  getUser() {
    this.service.getUser().subscribe((res) => {
      this.user = res;
      localStorage.setItem('user', this.user.role);
    });
  }
  isLoggedIn() {
    this.authService.contextChange.subscribe((res) => {
      this.isLogged = this.authService.isAuthenticated();
      this.getUser();
    });
    this.isLogged = this.authService.isAuthenticated();
    this.getUser();
  }

  logout() {
    this.authService.logout();
    this.route.navigate(['']);
  }
  ngOnInit() {
    this.isLoggedIn();
  }
  open() {
    const instance = this.modalService.open(CheckoutComponent, {
      backdrop: 'static',
      size: 'lg',
    });

    instance.result.then((res) => {});
  }

  @HostListener('window:scroll', []) onWindowScroll() {
    // tslint:disable-next-line:variable-name
    const number =
      window.pageYOffset ||
      document.documentElement.scrollTop ||
      document.body.scrollTop ||
      0;
    if (number < 55) {
      this.scrolling = false;
    } else if (number > 55) {
      this.scrolling = true;
    }
  }
}
