import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { StockmanagerComponent } from './stockmanager/stockmanager.component';
import { AddproductComponent } from './addproduct/addproduct.component';
import { ModifyproductComponent } from './modifyproduct/modifyproduct.component';
import { ShowallproductsComponent } from './showallproducts/showallproducts.component';


const routes: Routes = [
  {path : 'stockmanager' , component : StockmanagerComponent},
  {path : 'addproduct' , component : AddproductComponent},
  {path : 'modifyproduct' , component : ModifyproductComponent},
  {path : 'showallproducts' , component : ShowallproductsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
