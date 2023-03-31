import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {PageNotFoundComponent} from "./core/components/page-not-found/page-not-found.component";
import {CompaniesComponent} from "./features/pages/companies/companies.component";
import {SuppliersComponent} from "./features/pages/suppliers/suppliers.component";
import {CompaniesEditFormComponent} from "./features/pages/companies/companies-edit-form/edit-form.component";
import {SuppliersEditFormComponent} from "./features/pages/suppliers/suppliers-edit-form/edit-form.component";

const routes: Routes = [
  { path: '', redirectTo: '/companies', pathMatch: 'full' },
  { path: 'companies', component: CompaniesComponent },
  { path: 'suppliers', component: SuppliersComponent },
  { path: 'company-form/:action', component: CompaniesEditFormComponent},
  { path: 'company-form/:action/:id', component: CompaniesEditFormComponent},
  { path: 'supplier-form/:action', component: SuppliersEditFormComponent},
  { path: 'supplier-form/:action/:id', component: SuppliersEditFormComponent},
  { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports : [
    RouterModule
  ]
})
export class AppRoutingModule { }
