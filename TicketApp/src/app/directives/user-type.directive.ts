import { element } from 'protractor';
import { AuthenticationService } from './../authentication/authentication.service';
import { tap } from 'rxjs/operators';
import { UsersService } from 'src/app/service/users.service';
import { Directive, ElementRef, OnInit, Input } from '@angular/core';

@Directive({
  selector: '[appUserType]',
})
export class UserTypeDirective implements OnInit {
  @Input() appUserType: any[];

  constructor(private el: ElementRef) {}
  ngOnInit() {
    const role = localStorage.getItem('user');
    if (
      !!this.appUserType &&
      !!this.appUserType.length &&
      !this.appUserType.includes(role)
    ) {
      this.el.nativeElement.style.display = 'none';
    }
  }
}
