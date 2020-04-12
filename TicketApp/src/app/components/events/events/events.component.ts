import { CategoryService } from './../../../service/category.service';
import { Component, OnInit } from '@angular/core';
import { EventsService } from 'src/app/service/events.service';

@Component({
  selector: 'app-events',
  templateUrl: './events.component.html',
  styleUrls: ['./events.component.less'],
})
export class EventsComponent implements OnInit {
  events: any;
  allEvents: any;
  categories: any;
  Id: any;

  images = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14].map(
    () => `https://picsum.photos/1600/600?random&t=${Math.random()}`
  );

  constructor(
    private service: EventsService,
    private categoryService: CategoryService
  ) {}

  ngOnInit(): void {
    this.getEvents();
    this.getCategories();
  }

  getEvents() {
    this.service.getEvents().subscribe((res) => {
      this.events = res;
      this.allEvents = res;
    });
  }
  getEventById(id) {
    this.service.getEventById(id).subscribe((res) => {
      this.events = res;
    });
  }
  createEvent(model) {
    this.service.createEvent(model).subscribe((res) => {});
  }
  getCategories() {
    this.categoryService.getCategories().subscribe((res) => {
      this.categories = res;
    });
  }
  getCategoryId(id) {
    this.categoryService.getCategoryId(id).subscribe((res) => {
      this.events = res.events;
    });
  }
}
