import { AuthenticationService } from './../authentication.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/service/users.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.less'],
})
export class LoginComponent implements OnInit {
  model: any = {
    username: null,
    password: null,
  };
  constructor(
    private router: Router,
    private service: UsersService,
    private authService: AuthenticationService
  ) {}

  ngOnInit() {}

  login() {
    this.authService.logout();
    this.service.login(this.model).subscribe((res) => {
      const token = res.headers.get('Authorization');
      this.authService.setToken(token);
      this.router.navigateByUrl('');
    });
  }
}
