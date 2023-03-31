import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CompanyService} from "../../../../core/services/company.service";
import {documentNumberMaskPipe} from "../../../../shared/pipes/cnpj-mask.pipe";
import {first} from "rxjs";

@Component({
  selector: 'app-suppliers-companies-edit-form',
  templateUrl: './edit-form.component.html',
  styleUrls: ['./edit-form.component.scss']
})
export class CompaniesEditFormComponent implements OnInit {
  actionLabel: string = 'Adicionar';
  action!: string;
  editForm!: FormGroup;
  cnpj!: string;

  validCEP: boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private activeRoute: ActivatedRoute,
    private companyService: CompanyService,
    private documentNumberMaskPipe: documentNumberMaskPipe) {
  }

  ngOnInit() {
    this.activeRoute.params.subscribe(params => {
      this.action = params['action'];
      this.cnpj = params['id'];

    });
    if (this.cnpj) {
      this.actionLabel = 'Salvar';
    }
    this.editForm = this.formBuilder.group({
      cnpj: ['', Validators.required],
      fantasyName: ['', Validators.required],
      cep: ['', Validators.required]
    });

    if (this.action === "edit") {
      this.companyService.getCompanyByCNPJ(this.cnpj).subscribe(result => {
        this.editForm.setValue({
          cnpj: this.documentNumberMaskPipe.transform(result[0].cnpj),
          fantasyName: result[0].fantasyName,
          cep: result[0].cep
        })
      });
    }
  }
  checkCEP() {
    this.companyService.checkCEP(this.editForm.get('cep')?.value).subscribe(res => {
      if (res.length === 0) {
        this.editForm.controls['cep'].setErrors({'incorrect': true});
      } else if (res.logradouro) {
        this.validCEP = true;
      } else {
        this.editForm.controls['cep'].setErrors({'incorrect': false});
      }
    });
  }
  onSubmit() {
    const body = {
      cnpj: this.editForm.value['cnpj'].match(/\d/g).join(""),
      fantasyName: this.editForm.value['fantasyName'],
      cep: this.editForm.value['cep']
    }
    if (this.action === "add") {
      this.companyService.saveCompany(body)
        .pipe(first())
        .subscribe();
    } else if (this.action === "edit") {
      this.companyService.updateCompany(body)
        .pipe(first())
        .subscribe();
    }
    this.router.navigateByUrl('/companies')
  }
}
