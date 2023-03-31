import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {documentNumberMaskPipe} from "../../../../shared/pipes/cnpj-mask.pipe";
import {filter, first, map} from "rxjs";
import {SupplierService} from "../../../../core/services/supplier.service";
import * as moment from 'moment';
import { DatePipe } from "@angular/common";
import {CustomDatePipe} from "../../../../shared/pipes/date-pipe.pipe";

@Component({
  selector: 'app-suppliers-companies-edit-form',
  templateUrl: './edit-form.component.html',
  styleUrls: ['./edit-form.component.scss']
})
export class SuppliersEditFormComponent implements OnInit {
  actionLabel: string = 'Adicionar';
  action!: string;
  editForm!: FormGroup;
  documentNumber!: string;

  validCEP: boolean = false;

  isPR: boolean = false;

  // set isDisabled(value: boolean) {
  //   this._isDisabled = value;
  //   if(value) {
  //     this.editForm.controls['rg'].disable();
  //   } else {
  //     this.editForm.controls['rg'].enable();
  //   }
  // }
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private activeRoute: ActivatedRoute,
    private supplierService: SupplierService,
    private documentNumberMaskPipe: documentNumberMaskPipe,
    private customDatePipe: CustomDatePipe) {
  }

  ngOnInit() {
    this.activeRoute.params.subscribe(params => {
      this.action = params['action'];
      this.documentNumber = params['id'];

    });
    if (this.documentNumber) {
      this.actionLabel = 'Salvar';
    }
    this.editForm = this.formBuilder.group({
      documentNumber: ['', Validators.required],
      name: ['', Validators.required],
      email: ['', Validators.required],
      birthdate: [{value: '', disabled: true}],
      rg: [{value: '', disabled: true}],
      cep: ['', Validators.required]
    });
    this.editForm.controls['documentNumber'].valueChanges.pipe(filter(value => value.length >= 11)).subscribe(value => {
      if(value.length === 11){
        this.editForm.get('birthdate')?.enable();
        this.editForm.get('rg')?.enable();
      } else if(value.length > 11){
        this.editForm.get('birthdate')?.disable();
        this.editForm.get('rg')?.disable();
      }
    });

    this.editForm.controls['birthdate'].valueChanges.pipe(filter(value => value.length >= 6)).subscribe(value => {
        if(this.isPR && this.ageFromDateOfBirthday(value) < 18) {
          this.editForm.controls['birthdate'].setErrors({'minor': true});
        }
    });

    if (this.action === "edit") {
      this.supplierService.getSupplierByDocumentNumber(this.documentNumber).subscribe(result => {
        this.editForm.setValue({
          documentNumber: this.documentNumberMaskPipe.transform(result[0].documentNumber),
          name: result[0].name,
          email: result[0].email,
          birthdate: result[0].dateOfBirth ? this.formatDate(result[0].dateOfBirth, 'edit') : '',
          rg: result[0].rg ? result[0].rg : '',
          cep: result[0].cep
        })
      });
    }
  }

  checkCEP() {
    this.supplierService.checkCEP(this.editForm.get('cep')?.value).subscribe(res => {
      if (res.length === 0) {
        this.editForm.controls['cep'].setErrors({'incorrect': true});
      } else if (res.logradouro) {
        this.validCEP = true;
        this.isPR = false;
        if (res.uf === "PR") {
          this.isPR = true;
          let birthdate = this.editForm.get('birthdate')?.value;
            if(birthdate && this.ageFromDateOfBirthday(birthdate) < 18) {
              this.editForm.controls['birthdate'].setErrors({'minor': true});
            } else {
              this.editForm.controls['birthdate'].setErrors({'minor': null});
            }
          }
      } else {
        this.editForm.controls['cep'].setErrors({'incorrect': false});
      }
    });
  }

  onSubmit() {
    const body = {
      typeDocument: this.editForm.value['documentNumber'].length === 11 ? 'cpf' : 'cnpj',
      documentNumber: this.editForm.value['documentNumber'].match(/\d/g).join(""),
      name: this.editForm.value['name'],
      email: this.editForm.value['email'],
      dateOfBirth: this.editForm.value['birthdate'],
      rg: this.editForm.value['rg'],
      cep: this.editForm.value['cep']
    }
    if (this.action === "add") {
      this.supplierService.saveSupplier(body)
        .pipe(first())
        .subscribe();
    } else if (this.action === "edit") {
      this.supplierService.updateSupplier(body)
        .pipe(first())
        .subscribe();
    }
    this.router.navigateByUrl('/suppliers')
  }

  ageFromDateOfBirthday(dateOfBirth: any): number {
    return moment().diff(this.formatDate(dateOfBirth), 'years');
  }

  formatDate(date: string, event?: string) {
    if(event === 'edit'){
      const [year, month, day] = date.split('-');
      return `${day}/${month}/${year}`;
    }
    const [day, month, year] = this.customDatePipe.transform(date).split('-');
    return `${year}-${month}-${day}`;
  }
}
