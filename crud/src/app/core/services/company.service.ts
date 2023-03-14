import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environment";
import {CompanyModel} from "../models/company.model";

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  constructor(private http : HttpClient) { }


  listCompanies() : Observable<CompanyModel[]> {
    return this.http.get<CompanyModel[]>(`${environment.apiRootUrl}/company`);
  }
  deleteCompany(cnpj : string) : Observable<any> {
    return this.http.delete(`${environment.apiRootUrl}/company/${cnpj}`);
  }
  getCompanyByCNPJ(cnpj :string) : Observable<any> {
    return this.http.get(`${environment.apiRootUrl}/company/${cnpj}`);
  }
  updateCompany(body : any) : Observable<any> {
    return this.http.put(`${environment.apiRootUrl}/company`, body);
  }
  saveCompany(body : any) : Observable<any> {
    return this.http.post(`${environment.apiRootUrl}/company`, body);
  }
  checkCEP(cep: any) : Observable<any> {
    const headers : Object = {
      headers: new HttpHeaders({
        'Accept': 'application/json',
        'content-type': 'application/json'
      })
    }
    return this.http.get( `http://cep.la/${cep}`, headers);
  }
}
