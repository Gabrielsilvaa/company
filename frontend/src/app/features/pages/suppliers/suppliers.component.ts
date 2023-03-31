import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {catchError, map, of} from "rxjs";
import {SupplierService} from "../../../core/services/supplier.service";

@Component({
  selector: 'app-suppliers',
  templateUrl: './suppliers.component.html',
  styleUrls: ['./suppliers.component.scss']
})
export class SuppliersComponent implements AfterViewInit {
  displayedColumns: string[] = ['documentNumber', 'name', 'email', 'cep', 'edit'];
  dataSource: any;

  documentNumber!: string;
  name!: string;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private supplierService: SupplierService) {
  }

  ngAfterViewInit() {
    this.supplierService.listSuppliers().pipe(catchError(() => of(null)),
      map(data => {
        if (data === null) {
          return [];
        }
        return data;
      })).subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
    });
  }

  filterData() {
    const params = {
      documentNumber: this.documentNumber.match(/\d/g)?.join(""),
      name: this.name
    }
    this.supplierService.getFilteredData(params).subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
    })
  }

  deleteSupplier(documentNumber: string) {
    const body = {
      documentNumber: documentNumber
    }
    this.supplierService.deleteSupplier(body).subscribe(() => this.refresh());
  }

  refresh(): void {
    window.location.reload();
  }
}
