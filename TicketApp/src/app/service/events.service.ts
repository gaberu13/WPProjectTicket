import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventsService {
  url = 'http://localhost:8080/event';
  constructor(private http: HttpClient) {}
  getEvents(): Observable<any> {
    return this.http.get(this.url);
  }
  getEventById(id): Observable<any> {
    return this.http.get(this.url + '/' + id);
  }
  createEvent(model): Observable<any> {
    return this.http.post(this.url, model);
  }
  update(model): Observable<any> {
    return this.http.post(this.url + '/update', model);
  }
  deleteById(id): Observable<any> {
    return this.http.post( `${this.url}/delete?id=${id}`, {});
  }
}
