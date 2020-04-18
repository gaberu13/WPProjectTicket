import { UiModalService } from './../../service/ui-modal.service';
import { EditLocationComponent } from './../edit-location/edit-location.component';
import { LocationService } from './../../service/location.service';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.less'],
})
export class LocationComponent implements OnInit {
  // locations: any;
  locations: any;
  constructor(
    private service: LocationService,
    private modalService: NgbModal,
    private uiService: UiModalService
  ) {}

  images = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14].map(
    () => `https://picsum.photos/1600/600?random&t=${Math.random()}`
  );

  ngOnInit() {
    this.getLocations();
  }

  getLocations() {
    this.service.getLocation().subscribe((res) => {
      this.locations = res;
    });
  }

  open(itm?) {
    const instance = this.modalService.open(EditLocationComponent, {
      backdrop: 'static',
      size: 'lg',
    });

    if (!!itm) {
      instance.componentInstance.id = itm.id;
    }
    instance.result.then((res) => {
      this.getLocations();
    });
  }

  delete(id) {
    this.uiService
      .confirmDialog('Do you want to delete this location?')
      .then((res) => {
        if (!!res) {
          this.service.delete(id).subscribe(() => {
            this.getLocations();
          });
        }
      });
  }
}
