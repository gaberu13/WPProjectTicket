import { UiModalService } from './../../service/ui-modal.service';
import { OrderService } from './../../service/order.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.less'],
})
export class OrdersComponent implements OnInit {
  orders: any;
  constructor(
    private service: OrderService,
    private uiService: UiModalService
  ) {}

  ngOnInit() {
    this.getOrders();
  }

  getOrders() {
    this.service.orders().subscribe((res) => {
      this.orders = res;
    });
  }

  delete(id) {
    this.uiService
      .confirmDialog('Do you want to delete this order?')
      .then((res) => {
        this.service.delete(id).subscribe(() => {
          this.getOrders();
        });
      });
  }
}
