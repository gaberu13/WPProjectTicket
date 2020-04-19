import { CategoryService } from './../../../service/category.service';
import { LocationService } from './../../../service/location.service';
import { EventsService } from './../../../service/events.service';
import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-update-event-admin',
  templateUrl: './update-event-admin.component.html',
  styleUrls: ['./update-event-admin.component.less'],
})
export class UpdateEventAdminComponent implements OnInit {
  @Input() id: any;
  event: any = {};
  lookup: any = {
    location: [],
  };
  categories: any;

  error: any;
  constructor(
    private service: EventsService,
    private modal: NgbActiveModal,
    private locationService: LocationService,
    private categoryService: CategoryService,
    private eventService: EventsService
  ) {}

  ngOnInit(): void {
    this.getLocations();
    this.getCategories();
    if (!!this.id) {
    this.getEventById(this.id);
    }
  }

  add() {
    this.service.createEvent(this.event).subscribe(
      (res) => {
        this.cancel();
      },
      (err) => {
        this.error = err.error.errors;
      }
    );
  }
  update() {
    this.service.update(this.event).subscribe(
      (res) => {
        this.cancel();
      },
      (err) => {
        this.error = err.error.errors;
      }
    );
  }

  cancel() {
    this.modal.close();
  }

  getLocations() {
    this.locationService.getLocation().subscribe((res) => {
      this.lookup.location = res;
    });
  }
  getCategories() {
    this.categoryService.getCategories().subscribe((res) => {
      this.categories = res;
    });
  }
  getEventById(id) {
    this.eventService.getEventById(id).subscribe((res) => {
      this.event = res;
    });
  }
}
