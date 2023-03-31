import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {CompanyService} from "../../../core/services/company.service";
import {catchError, map, of} from "rxjs";

@Component({
  selector: 'app-companies',
  templateUrl: 'companies.component.html',
  styleUrls: ['companies.component.scss']
})
export class CompaniesComponent implements AfterViewInit {
  displayedColumns: string[] = ['cnpj', 'fantasyName', 'cep', 'edit'];
  dataSource: any;

  documentNumber! : string;
  name!: string;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private companyService: CompanyService) {}
  ngAfterViewInit() {
    this.companyService.listCompanies().pipe(catchError(() => of(null)),
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
      cnpj: this.documentNumber.match(/\d/g)?.join(""),
      name: this.name
    }
    this.companyService.getFilteredData(params).subscribe(data => {
      this.dataSource = new MatTableDataSource(data);
    })
  }
  deleteCompany(cnpj: string) {
    this.companyService.deleteCompany(cnpj).subscribe(() => this.refresh());
  }
  refresh(): void {
    window.location.reload();
  }
}
