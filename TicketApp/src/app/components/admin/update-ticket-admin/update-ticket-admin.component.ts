import { TicketService } from './../../../service/ticket.service';
import { EventsService } from 'src/app/service/events.service';
import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-update-ticket-admin',
  templateUrl: './update-ticket-admin.component.html',
  styleUrls: ['./update-ticket-admin.component.less'],
})
export class UpdateTicketAdminComponent implements OnInit {
  @Input() id: any;
  ticket: any = {};
  error: any;
  constructor(
    private eventService: EventsService,
    private modal: NgbActiveModal,
    private service: TicketService
  ) {}
  events: any;
  ngOnInit(): void {
    this.getEvents();
    if (!!this.id) {
      this.find();
    }
  }

  getEvents() {
    this.eventService.getEvents().subscribe((res) => {
      this.events = res;
    });
  }
  cancel() {
    this.modal.close();
  }

  add() {
    this.service.createTicket(this.ticket).subscribe(
      (res) => {
        this.cancel();
      },
      (err) => {
        this.error = err.error.errors;
      }
    );
  }
  update() {
    this.service.update(this.ticket).subscribe(
      (res) => {
        this.cancel();
      },
      (err) => {
        this.error = err.error.errors;
      }
    );
  }

  find() {
    this.service.find(this.id).subscribe((res) => {
      this.ticket = res;
    });
  }
}
