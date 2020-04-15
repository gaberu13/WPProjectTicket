import { LocationService } from './../../service/location.service';
import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-edit-location',
  templateUrl: './edit-location.component.html',
  styleUrls: ['./edit-location.component.less'],
})
export class EditLocationComponent implements OnInit {
  @Input() id: any;
  location: any = {
    id: null,
    name: null,
    description: null,
    capacity: null,
  };
  error: any;
  constructor(
    private service: LocationService,
    private modal: NgbActiveModal
  ) {}

  ngOnInit(): void {
    this.getByLocationId(this.id);
  }

  add() {
    this.service.addLocation(this.location).subscribe(
      (res) => {
        this.cancel();
      },
      (err) => {
        this.error = err.error.errors;
      }
    );
  }

  getByLocationId(id) {
    this.service.getById(id).subscribe((res) => {
      this.location = res;
    });
  }

  cancel() {
    this.modal.close();
  }
}
