import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ButtonComponent} from './components/button/button.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import { InputComponent } from './components/input/input.component';
import {MatIconModule} from "@angular/material/icon";
import {MatButtonModule} from "@angular/material/button";
import { ToolbarComponent } from './components/toolbar/toolbar.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {RouterLink, RouterOutlet} from "@angular/router";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import { CnpjMaskPipe } from './pipes/cnpj-mask.pipe';
import { CepMaskPipe } from './pipes/cep-mask.pipe';


@NgModule({
  declarations: [
    ButtonComponent,
    InputComponent,
    ToolbarComponent,
    CnpjMaskPipe,
    CepMaskPipe
  ],
  exports: [
    ButtonComponent,
    InputComponent,
    CnpjMaskPipe,
    CepMaskPipe,
    ToolbarComponent
  ],
  imports: [
    CommonModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatToolbarModule,
    RouterLink,
    MatSidenavModule,
    MatListModule,
    RouterOutlet
  ],
  providers: []
})
export class SharedModule {
}
