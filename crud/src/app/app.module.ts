import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { StoreModule } from '@ngrx/store';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {SharedModule} from "./shared/shared.module";
import {FeaturesModule} from "./features/features.module";
import {CoreModule} from "./core/core.module";
import { AppRoutingModule } from './app-routing.module';
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {MatSortModule} from "@angular/material/sort";
import {NgxMaskDirective, NgxMaskPipe} from "ngx-mask";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    CoreModule,
    FeaturesModule,
    SharedModule,
    StoreModule.forRoot({}, {}),
    ReactiveFormsModule,
    HttpClientModule,
    MatSortModule,
    NgxMaskPipe
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
