import { LocationService } from './../../service/location.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.less'],
})
export class LocationComponent implements OnInit {
  locations: any;
  constructor(private service: LocationService) {}

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
}
