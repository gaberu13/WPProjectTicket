import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  url = 'http://localhost:8080/categories';
  constructor(private http: HttpClient) {}

  getCategories(): Observable<any> {
    return this.http.get(this.url);
  }
  getCategoryId(id): Observable<any> {
    return this.http.get(this.url + '/' + id);
  }
}
