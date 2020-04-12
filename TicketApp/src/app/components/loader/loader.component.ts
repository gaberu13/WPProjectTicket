import { LoaderService } from './../../service/loader.service';
import {
  Component,
  OnInit,
  AfterViewInit,
  Input,
  ChangeDetectorRef,
} from '@angular/core';

@Component({
  selector: 'app-loader',
  templateUrl: './loader.component.html',
  styleUrls: ['./loader.component.less'],
})
export class LoaderComponent implements OnInit, AfterViewInit {
  @Input() isLogged;
  loading: boolean;
  loaderHide: boolean;
  constructor(private service: LoaderService, private cd: ChangeDetectorRef) {
    this.loaderHide = true;
  }

  ngOnInit() {
    this.service.getNotification().subscribe((res) => {
      this.loaderHide = res.notification;
    });
  }

  ngAfterViewInit() {
    this.service.isLoading.subscribe((res) => {
      this.loading = res;
      this.cd.detectChanges();
    });
  }
}
