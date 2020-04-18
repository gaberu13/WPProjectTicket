import { UiModalService } from './../../../service/ui-modal.service';
import { UpdateEventAdminComponent } from './../update-event-admin/update-event-admin.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EventsService } from './../../../service/events.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-event-admin',
  templateUrl: './event-admin.component.html',
  styleUrls: ['./event-admin.component.less'],
})
export class EventAdminComponent implements OnInit {
  constructor(
    private service: EventsService,
    private modalService: NgbModal,
    private uiService: UiModalService
  ) {}
  events: any;

  ngOnInit() {
    this.getEvents();
  }

  getEvents() {
    this.service.getEvents().subscribe((res) => {
      this.events = res;
    });
  }

  open(itm?) {
    const instance = this.modalService.open(UpdateEventAdminComponent, {
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
  deleteEvent(id) {
    this.uiService
      .confirmDialog('Do you want to delete this event?')
      .then((res) => {
        this.service.deleteById(id).subscribe(() => {
          this.getEvents();
        });
      });
  }
}
