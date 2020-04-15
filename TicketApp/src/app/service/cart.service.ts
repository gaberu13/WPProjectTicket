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
  removeCart(id, ticketId): Observable<any> {
    return this.http.post(
      `${this.url}/remove?id=${id}&ticketId=${ticketId}`,
      {}
    );
  }
  removeFromCart(id, ticketId, quantity): Observable<any> {
    return this.http.post(
      `${this.url}/decrease?id=${id}&ticketId=${ticketId}&quantity=${quantity}`,
      {}
    );
  }
}
