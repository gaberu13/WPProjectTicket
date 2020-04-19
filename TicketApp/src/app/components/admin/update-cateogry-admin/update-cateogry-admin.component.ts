import { CategoryService } from './../../../service/category.service';
import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-update-cateogry-admin',
  templateUrl: './update-cateogry-admin.component.html',
  styleUrls: ['./update-cateogry-admin.component.less'],
})
export class UpdateCateogryAdminComponent implements OnInit {
  @Input() id: any;
  category: any = {};
  error: any;
  constructor(
    private service: CategoryService,
    private modal: NgbActiveModal
  ) {}

  ngOnInit(): void {
    if (!!this.id) {
      this.getCategoryById();
    }
  }

  add() {
    this.service.createCategory(this.category).subscribe(
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

  getCategoryById() {
    this.service.getCategoryId(this.id).subscribe((res) => {
      this.category = res;
    });
  }
}
