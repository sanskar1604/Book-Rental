import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import base_url from './base_url';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private _http:HttpClient) { }

  //get all books
  public getAllBooks(){
    return this._http.get(`${base_url}/book`);
  }

  //add books
  public addBook(book:any){
    return this._http.post(`${base_url}/book`, book);
  }

  //Get one book
  public getBook(bookId:any){
    return this._http.get(`${base_url}/book/${bookId}`);
  }

  //update book
  public updateBook(book:any, bookId:any){
    return this._http.put(`${base_url}/book/${bookId}`, book);
  }

  //delete book
  public deleteBook(bookId:any){
    return this._http.delete(`${base_url}/book/${bookId}`);
  }
}
