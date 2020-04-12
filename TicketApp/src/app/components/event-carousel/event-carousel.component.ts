import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-event-carousel',
  templateUrl: './event-carousel.component.html',
  styleUrls: ['./event-carousel.component.less']
})
export class EventCarouselComponent implements OnInit {
  @Input() events;
  @Input() images;
  constructor() {}

  ngOnInit(): void {}
}
