import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class TicketService {
  url = 'http://localhost:8080/ticket';
  constructor(private http: HttpClient) {}
  getTicketId(id): Observable<any> {
    return this.http.get(this.url + '/' + id);
  }
  createTicket(model): Observable<any> {
    return this.http.post(this.url, model);
  }
  deleteById(id): Observable<any> {
    return this.http.post(`${this.url}/delete?id=${id}`, {});
  }
  find(id): Observable<any> {
    return this.http.get(`${this.url}/id/${id}`);
  }
  update(model): Observable<any> {
    return this.http.post(this.url + '/update', model);
  }
}
