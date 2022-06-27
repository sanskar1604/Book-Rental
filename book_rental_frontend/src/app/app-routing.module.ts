import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryComponent } from './components/admin/pages/category/category.component';
import { DashboardComponent } from './components/admin/pages/dashboard/dashboard.component';
import { LanguageComponent } from './components/admin/pages/language/language.component';

const routes: Routes = [
  {
    path:'admin',
    component:DashboardComponent,
    children:[
      {
        path:'language',
        component:LanguageComponent
      },
      {
        path:'category',
        component:CategoryComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
