import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import base_url from './base_url';

@Injectable({
  providedIn: 'root'
})
export class LanguageService {

  constructor(private _http:HttpClient) { }

  //Load all languages
  public getLanguage() {
    return this._http.get(`${base_url}/language`);
  }

  //Add Language
  public addLanguage(language:any){
    return this._http.post(`${base_url}/language`, language);
  }

  //Delete Language
  public deleteLanguage(lang_id:any){
    return this._http.delete(`${base_url}/language/${lang_id}`);
  }

  //Update language
}
