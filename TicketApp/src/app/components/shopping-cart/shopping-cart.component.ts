import { AuthenticationService } from './../../authentication/authentication.service';
import { OrderService } from './../../service/order.service';
import { CheckoutComponent } from './../checkout/checkout.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CartService } from 'src/app/service/cart.service';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.less'],
})
export class ShoppingCartComponent implements OnInit {
  // tslint:disable-next-line:no-input-rename
  @Input('cart') cart;
  showbtns: any;
  show: any;
  isLogged: any;
  constructor(
    private cartService: CartService,
    private modalService: NgbModal,
    private orderService: OrderService,
    private route: Router,
    private authService: AuthenticationService
  ) {}

  ngOnInit() {
    this.isLoggedIn();
  }
  isLoggedIn() {
    this.authService.contextChange.subscribe((res) => {
      this.isLogged = this.authService.isAuthenticated();
      this.getCart();
    });
    this.isLogged = this.authService.isAuthenticated();
  }

  getCart() {
    this.cartService.getCart().subscribe((res) => {
      this.cart = res;
    });
  }
  removeFromCard(id, ticketId) {
    this.cartService.removeCart(id, ticketId).subscribe((res) => {
      this.cart = res;
    });
  }

  checkout() {
    this.orderService.checkout().subscribe((res) => {
      this.route.navigate(['/orders']);
    });
  }

  open() {
    const instance = this.modalService.open(CheckoutComponent, {
      backdrop: 'static',
      size: 'lg',
    });
    instance.result.then((res) => {});
  }
}
