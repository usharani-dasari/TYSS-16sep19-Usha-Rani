import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { StockmanagerComponent } from './stockmanager/stockmanager.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { ModifyproductComponent } from './modifyproduct/modifyproduct.component';
import { ShowallproductsComponent } from './showallproducts/showallproducts.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    StockmanagerComponent,
    ModifyproductComponent,
    AddproductComponent,
    ShowallproductsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
