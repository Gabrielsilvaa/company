import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {CompanyModel} from "../../../core/models/company.model";

const ELEMENT_DATA: any[] = [
  {documentNumber: '445.898.558-28', fantasyName: 'Hydrogen', cep: 'H'},
  {documentNumber: '13.339.532/0001-09', fantasyName: 'Helium', cep: 'He'},
  {documentNumber: '445.898.558-28', fantasyName: 'Lithium', cep: 'Li'},
  {documentNumber: '445.898.558-28', fantasyName: 'Hydrogen', cep: 'H'},
  {documentNumber: '13.339.532/0001-09', fantasyName: 'Helium', cep: 'He'},
  {documentNumber: '445.898.558-28', fantasyName: 'Lithium', cep: 'Li'},
  {documentNumber: '445.898.558-28', fantasyfantasyName: 'Hydrogen', cep: 'H'},
  {documentNumber: '13.339.532/0001-09', fantasyName: 'Helium', cep: 'He'},
  {documentNumber: '445.898.558-28', fantasyName: 'Lithium', cep: 'Li'},
];

@Component({
  selector: 'app-suppliers',
  templateUrl: './suppliers.component.html',
  styleUrls: ['./suppliers.component.scss']
})
export class SuppliersComponent implements AfterViewInit {
  displayedColumns: string[] = ['cnpj', 'fantasyName', 'cep', 'edit'];
  dataSource = new MatTableDataSource(ELEMENT_DATA);
  searchText: any;

  @ViewChild(MatPaginator) paginator!: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
