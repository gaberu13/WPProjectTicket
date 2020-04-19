import { TicketService } from './../../../service/ticket.service';
import { UpdateTicketAdminComponent } from './../update-ticket-admin/update-ticket-admin.component';
import { EventsService } from 'src/app/service/events.service';
import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/service/category.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { UiModalService } from 'src/app/service/ui-modal.service';
import { UpdateCateogryAdminComponent } from '../update-cateogry-admin/update-cateogry-admin.component';

@Component({
  selector: 'app-ticket-admin',
  templateUrl: './ticket-admin.component.html',
  styleUrls: ['./ticket-admin.component.less']
})
export class TicketAdminComponent implements OnInit {
  events: any;
  constructor(
    private service: EventsService,
    private modalService: NgbModal,
    private ticketService: TicketService,
    private uiService: UiModalService
  ) {}

  ngOnInit(): void {
    this.getEvents();
  }

  getEvents() {
    this.service.getEvents().subscribe((res) => {
      this.events = res;
    });
  }

  open(itm?) {
    const instance = this.modalService.open(UpdateTicketAdminComponent, {
      backdrop: 'static',
      size: 'lg',
    });

    if (!!itm) {
      instance.componentInstance.id = itm.id;
    }
    instance.result.then((res) => {
      this.getEvents();
    });
  }
  delete(id) {
    this.uiService
      .confirmDialog('Do you want to delete this ticket?')
      .then(() => {
        this.ticketService.deleteById(id).subscribe(() => {
          this.getEvents();
        });
      });
  }

}
