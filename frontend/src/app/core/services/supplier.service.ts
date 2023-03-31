import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {CompanyModel} from "../models/company.model";
import {environment} from "../../environment";

@Injectable({
  providedIn: 'root'
})
export class SupplierService {
  finalUrl! : string;

  constructor(private http : HttpClient) { }


  listSuppliers() : Observable<CompanyModel[]> {
    return this.http.get<CompanyModel[]>(`${environment.apiRootUrl}/suppliers`);
  }
  deleteSupplier(body : Object) : Observable<any> {
    return this.http.delete(`${environment.apiRootUrl}/suppliers/`, {body});
  }
  getSupplierByDocumentNumber(documentNumber :string) : Observable<any> {
    return this.http.get(`${environment.apiRootUrl}/suppliers/supplier?documentNumber=${documentNumber}`);
  }
  updateSupplier(body : any) : Observable<any> {
    return this.http.put(`${environment.apiRootUrl}/suppliers`, body);
  }
  saveSupplier(body : any) : Observable<any> {
    return this.http.post(`${environment.apiRootUrl}/suppliers`, body);
  }

  getFilteredData(params : any) : Observable<any> {
    if(params.documentNumber) {
      this.finalUrl = `${environment.apiRootUrl}/suppliers/supplier?documentNumber=${params.documentNumber}`;
    } else if(params.name) {
      this.finalUrl = `${environment.apiRootUrl}/suppliers/supplier?name=${params.name}`;
    } else {
      this.finalUrl = `${environment.apiRootUrl}/suppliers`;
    }
    return this.http.get(this.finalUrl);

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
