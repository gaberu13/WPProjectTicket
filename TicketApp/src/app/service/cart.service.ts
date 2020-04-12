import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  url = 'http://localhost:8080/cart';
  constructor(private http: HttpClient) {}

  getCart(): Observable<any> {
    return this.http.get(this.url);
  }
  addToCart(id, ticketId, quantity): Observable<any> {
    return this.http.post(
      `${this.url}/add?id=${id}&ticketId=${ticketId}&quantity=${quantity}`,
      {}
    );
  }
  removeCart(username, id, ticketId): Observable<any> {
    return this.http.post(
      `${this.url}/remove?username=${username}&id=${id}&ticketId=${ticketId}`,
      {}
    );
  }
  removeFromCart(username, id, ticketId, quantity): Observable<any> {
    return this.http.post(
      `${this.url}/decrease?username=${username}&id=${id}&ticketId=${ticketId}&quantity=${quantity}`,
      {}
    );
  }
}
