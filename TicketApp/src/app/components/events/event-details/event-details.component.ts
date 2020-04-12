
import { CartService } from './../../../service/cart.service';
import { TicketService } from './../../../service/ticket.service';
import { Component, OnInit } from '@angular/core';
import { EventsService } from 'src/app/service/events.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-event-details',
  templateUrl: './event-details.component.html',
  styleUrls: ['./event-details.component.less'],
})
export class EventDetailsComponent implements OnInit {
  events: any;
  Id;
  cart: any;
  quantity = 1;

  images = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14].map(
    () => `https://picsum.photos/1600/600?random&t=${Math.random()}`
  );
  constructor(
    private service: EventsService,
    private route: ActivatedRoute,
    private router: Router,
    private cartService: CartService,
  ) {}

  ngOnInit() {
    this.sendId();
    if (isNaN(this.Id)) {
      this.router.navigate(['/']);
    } else {
      this.getEventById();
      // this.getCart();
    }
  }
  getEventById() {
    this.Id = this.route.snapshot.paramMap.get('id');
    this.service.getEventById(this.Id).subscribe((res) => {
      this.events = res;
    });
  }

  sendId() {
    this.route.paramMap.subscribe((params) => {
      this.Id = params.get('id');
      this.router.routeReuseStrategy.shouldReuseRoute = () => false;
    });
  }
  // getCart() {
  //   this.cartService.getCart().subscribe((res) => {
  //     this.cart = res;
  //   });
  // }

  increment(id, ticketId, quantity) {
    this.cartService.addToCart(id, ticketId, quantity).subscribe((result) => {
      this.cart = result;
    });
  }

  removeFromCard(username, id, ticketId) {
    this.cartService.removeCart(username, id, ticketId).subscribe((res) => {
      this.cart = res;
      // this.sharedEmitter.notify(this.cart);
    });
  }
  decrement(username, id, ticketId, quantity) {
    this.cartService
      .removeFromCart(username, id, ticketId, quantity)
      .subscribe((res) => {
        this.cart = res;
      });
  }
}
