import { Component, OnInit } from '@angular/core';
import { UsersService } from 'src/app/service/users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.less'],
})
export class RegisterComponent implements OnInit {
  constructor(private service: UsersService, private router: Router) {}

  model: any = {
    username: null,
    password: null,
    email: null,
    phone: null,
    address: null,
  };
  error: any;
  ngOnInit() {}

  register() {
    this.service.register(this.model).subscribe(
      (res) => {
        this.router.navigateByUrl('login');
      },
      (err) => {
        this.error = err.error.errors;
      }
    );
  }
}
