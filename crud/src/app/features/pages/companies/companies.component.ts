import {AfterViewChecked, AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {CompanyModel} from "../../../core/models/company.model";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {CompanyService} from "../../../core/services/company.service";
import {catchError, map, of} from "rxjs";

@Component({
  selector: 'app-companies',
  templateUrl: 'companies.component.html',
  styleUrls: ['companies.component.scss']
})
export class CompaniesComponent implements AfterViewInit, OnInit {
  displayedColumns: string[] = ['cnpj', 'fantasyName', 'cep', 'edit'];
  companiesList! : CompanyModel[];
  dataSource = new MatTableDataSource(this.companiesList);
  searchText: any;
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private companyService : CompanyService) {

  }

  ngOnInit() {
    this.companyService.checkCEP('0000000').subscribe(result => console.log(result));
  }

  ngAfterViewInit() {
        this.companyService.listCompanies().pipe(catchError(() => of(null)),
        map(data => {
          if (data === null) {
            return [];
          }
          return data;
        })).subscribe(data => this.companiesList = data);

    this.dataSource.paginator = this.paginator;

  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  deleteCompany(cnpj : string) {
    console.log(cnpj);
    this.companyService.deleteCompany(cnpj).subscribe();
  }
}
