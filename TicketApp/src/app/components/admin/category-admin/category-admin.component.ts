import { UiModalService } from './../../../service/ui-modal.service';
import { UpdateCateogryAdminComponent } from './../update-cateogry-admin/update-cateogry-admin.component';
import { CategoryService } from './../../../service/category.service';
import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-category-admin',
  templateUrl: './category-admin.component.html',
  styleUrls: ['./category-admin.component.less'],
})
export class CategoryAdminComponent implements OnInit {
  categories: any;
  constructor(
    private categoryService: CategoryService,
    private modalService: NgbModal,
    private uiService: UiModalService
  ) {}

  ngOnInit(): void {
    this.getCategories();
  }

  getCategories() {
    this.categoryService.getCategories().subscribe((res) => {
      this.categories = res;
    });
  }

  open(itm?) {
    const instance = this.modalService.open(UpdateCateogryAdminComponent, {
      backdrop: 'static',
      size: 'lg',
    });

    if (!!itm) {
      instance.componentInstance.id = itm.id;
    }
    instance.result.then((res) => {
      this.getCategories();
    });
  }
  deleteEvent(id) {
    this.uiService
      .confirmDialog('Do you want to delete this category?')
      .then(() => {
        this.categoryService.deleteById(id).subscribe(() => {
          this.getCategories();
        });
      });
  }
}
