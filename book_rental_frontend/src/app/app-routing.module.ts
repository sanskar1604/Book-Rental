import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookComponent } from './components/admin/pages/book/book.component';
import { CategoryComponent } from './components/admin/pages/category/category.component';
import { DashboardComponent } from './components/admin/pages/dashboard/dashboard.component';
import { LanguageComponent } from './components/admin/pages/language/language.component';
import { UpdateBookComponent } from './components/admin/pages/update-book/update-book.component';
import { UpdateCategoryComponent } from './components/admin/pages/update-category/update-category.component';
import { ViewBookComponent } from './components/admin/pages/view-book/view-book.component';

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
      },
      {
        path:'update-category/:catId',
        component:UpdateCategoryComponent
      },
      {
        path:'book',
        component:BookComponent
      },
      {
        path:'view-book/:bookId',
        component:ViewBookComponent
      },
      {
        path:"update-book/:bookId",
        component:UpdateBookComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
