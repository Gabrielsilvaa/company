import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ScopedComponentAComponent} from "./components/scoped-component-a/scoped-component-a.component";
import {SharedModule} from "../shared/shared.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { SuppliersComponent } from './pages/suppliers/suppliers.component';
import {CompaniesEditFormComponent} from './pages/companies/companies-edit-form/edit-form.component';
import {SuppliersEditFormComponent} from "./pages/suppliers/suppliers-edit-form/edit-form.component";
import {CompaniesComponent} from "./pages/companies/companies.component";
import {MatTableModule} from "@angular/material/table";
import { MatInputModule } from '@angular/material/input';
import {MatFormFieldModule} from "@angular/material/form-field";
import {NgxMaskDirective, NgxMaskPipe, provideNgxMask} from "ngx-mask";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from '@angular/material/button';
import {RouterLink, RouterOutlet} from "@angular/router";
import {CepMaskPipe} from "../shared/pipes/cep-mask.pipe";
import {documentNumberMaskPipe} from "../shared/pipes/cnpj-mask.pipe";
import {CustomDatePipe} from "../shared/pipes/date-pipe.pipe";



@NgModule({
  declarations: [
    ScopedComponentAComponent,
    CompaniesComponent,
    SuppliersComponent,
    CompaniesEditFormComponent,
    SuppliersEditFormComponent
  ],
  imports: [
    CommonModule,
    SharedModule,
    ReactiveFormsModule,
    MatTableModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    NgxMaskDirective,
    MatPaginatorModule,
    MatIconModule,
    MatButtonModule,
    RouterLink,
    RouterOutlet,
    NgxMaskPipe
  ],
  providers: [provideNgxMask(), documentNumberMaskPipe, CepMaskPipe, CustomDatePipe]
})
export class FeaturesModule { }
