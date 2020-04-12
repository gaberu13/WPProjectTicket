import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  url = 'http://localhost:8080/';
  constructor(private http: HttpClient) {}
  login(model): Observable<any> {
    return this.http.post(this.url + 'login', model, { observe: 'response' });
  }

  register(model): Observable<any> {
    return this.http.post(this.url + 'user/sign-up', model);
  }

  getUser(): Observable<any> {
    return this.http.get(`${this.url}user`);
  }

  updateUser(model): Observable<any> {
    return this.http.post(this.url + 'user/update', model);
  }
}
