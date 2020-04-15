import { UsersService } from 'src/app/service/users.service';
import { Router } from '@angular/router';
import { Injectable, Output, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {
  @Output() contextChange: EventEmitter<boolean> = new EventEmitter();

  constructor(private service: UsersService) {}

  userKey = 'user';

  isAuthenticated(): boolean {
    const token = localStorage.getItem('id_token');
    return !!token;
  }

  getUser() {
    const user = localStorage.getItem('id_token');
    if (!user) {
      return false;
    }
    return true;
  }

  setToken(token) {
    localStorage.setItem('id_token', token);
    this.contextChange.emit(true);
  }

  getToken() {
    return localStorage.getItem('id_token');
  }

  logout() {
    localStorage.removeItem('id_token');
    localStorage.removeItem('user');
    this.contextChange.emit(true);
  }
  getUserRole() {
    let role: any;
    this.service.getUser().subscribe((res) => {
      role = res;
    });
    return role;
  }
}
