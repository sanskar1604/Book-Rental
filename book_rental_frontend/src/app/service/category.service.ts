import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import base_url from './base_url';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor( private _http:HttpClient) { }

  //Get All Category
  public getAllCategory(){
    return this._http.get(`${base_url}/category`);
  }

  //Add Category
  public addCategory(category:any){
    return this._http.post(`${base_url}/category`, category);
  }

  //Delete Category
  public deleteCategory(catId:any){
    return this._http.delete(`${base_url}\category\${catId}`);
  }

  //get one category
  public getCategory(catId:any){
    return this._http.get(`${base_url}/category/${catId}`);
  }

  //update category
  public updateCategory(category:any, catId:any){
    return this._http.put(`${base_url}/category/${catId}`, category);
  }
}
