import { Subject, BehaviorSubject, Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoaderService {
  private subject = new Subject<any>();
  public isLoading = new BehaviorSubject(false);

  constructor() {}
  notify(notification: any) {
    this.subject.next({ notification });
  }

  getNotification(): Observable<any> {
    return this.subject.asObservable();
  }
}
