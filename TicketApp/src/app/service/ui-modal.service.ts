import { ConfirmDialogComponent } from './../components/confirm-dialog/confirm-dialog.component';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class UiModalService {
  constructor(private modalService: NgbModal) {}

  confirmDialog(question: string) {
    const instance = this.modalService.open(ConfirmDialogComponent, {
      backdrop: 'static',
      size: 'md',
    });
    instance.componentInstance.message = question;
    return instance.result;
  }
}
