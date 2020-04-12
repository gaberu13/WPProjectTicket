import { OrderService } from './../../service/order.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.less'],
})
export class OrdersComponent implements OnInit {
  orders: any;
  constructor(private service: OrderService) {}

  ngOnInit() {
    this.getOrders();
  }

  getOrders() {
    this.service.orders().subscribe((res) => {
      this.orders = res;
    });
  }
}
