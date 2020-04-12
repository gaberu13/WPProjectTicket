import { Router } from '@angular/router';
import { OrderService } from './../../service/order.service';
import { UsersService } from 'src/app/service/users.service';
import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.less'],
})
export class CheckoutComponent implements OnInit {
  model: any = {
    phone: null,
    email: null,
    address: null,
  };
  error: any;
  constructor(
    private userService: UsersService,
    private modal: NgbActiveModal,
    private orderService: OrderService,
    private route: Router
  ) {}

  ngOnInit() {
    this.getuser();
  }
  checkout() {
    this.orderService.checkout().subscribe((res) => {
      this.route.navigate(['/orders']);
    });
  }

  update() {
    this.userService.updateUser(this.model).subscribe(
      (res) => {
        this.cancel();
        this.checkout();
      },
      (err) => {
        this.error = err.error.errors;
      }
    );
  }
  getuser() {
    this.userService.getUser().subscribe((res) => {
      this.model = res;
    });
  }
  cancel() {
    this.modal.close();
  }
}
