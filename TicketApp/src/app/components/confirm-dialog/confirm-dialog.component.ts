import { NgbModal, NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-confirm-dialog',
  templateUrl: './confirm-dialog.component.html',
  styleUrls: ['./confirm-dialog.component.less'],
})
export class ConfirmDialogComponent implements OnInit {
  constructor(private modalService: NgbActiveModal) {}
  @Input() title: string;
  @Input() message: string;
  ngOnInit(): void {}

  public decline() {
    this.modalService.close(false);
  }
  public accept() {
    this.modalService.close(true);
  }
  public dismiss() {
    this.modalService.dismiss();
  }
}
