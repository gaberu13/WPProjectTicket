import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  url = 'http://localhost:8080/order';
  constructor(private http: HttpClient) {}

  orders(): Observable<any> {
    return this.http.get(this.url);
  }

  checkout(): Observable<any> {
    return this.http.post(this.url + '/checkout', {});
  }
}
