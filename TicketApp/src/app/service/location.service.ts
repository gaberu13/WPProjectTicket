import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  url = 'http://localhost:8080/location';
  constructor(private http: HttpClient) { }

  getLocation(): Observable<any> {
    return this.http.get(this.url);
  }
}
