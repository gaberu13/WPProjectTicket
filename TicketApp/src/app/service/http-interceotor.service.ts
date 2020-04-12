import { LoaderService } from './loader.service';
import { Observable } from 'rxjs';
import { AuthenticationService } from './../authentication/authentication.service';
import { Injectable } from '@angular/core';
import { filter, tap } from 'rxjs/operators';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpResponse,
  HttpErrorResponse,
} from '@angular/common/http';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class HttpInterceotorService implements HttpInterceptor {
  constructor(
    private router: Router,
    private service: AuthenticationService,
    private loaderService: LoaderService
  ) {}

  tokenKey = 'id_token';

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    req = req.clone({
      withCredentials: false,
    });

    let token = '';

    if (this.service.isAuthenticated()) {
      token = this.service.getToken();
    }
    this.loaderService.isLoading.next(true);

    req = req.clone({
      setHeaders: {
        Authorization: token,
      },
    });

    return next.handle(req).pipe(
      filter((event) => event instanceof HttpResponse),
      tap(
        (event: HttpResponse<any>) => {
          this.loaderService.isLoading.next(false);
        },
        (err: any) => {
          if (err instanceof HttpErrorResponse) {
            if (err.status === 401) {
              this.service.logout();
              this.router.navigateByUrl('/login');
            } else if (err.status === 403) {
              // tslint:disable-next-line:no-debugger
              this.router.navigateByUrl('/login');
            }
          }
          this.loaderService.isLoading.next(false);
        }
      )
    );
  }
}
