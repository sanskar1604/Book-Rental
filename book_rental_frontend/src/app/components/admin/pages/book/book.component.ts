import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { BookService } from 'src/app/service/book.service';
import { CategoryService } from 'src/app/service/category.service';
import { LanguageService } from 'src/app/service/language.service';
import { FileUploader, FileUploaderOptions, ParsedResponseHeaders } from 'ng2-file-upload';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  books = [
    {
      bookId:'',
      bookAuthor:'',
      bookBinding:'',
      bookDesc:'',
      bookEdition:'',
      bookImg:'',
      bookPrice:'',
      bookPages:'',
      bookPublisher:'',
      bookTitle:'',
      category : {
        catId:'',
        catTitle:'',
        catDescription:''
      },
      language : {
        langId:'',
        language:''
      }
    }
  ]

  book = {
    bookId:'',
      bookAuthor:'',
      bookBinding:'',
      bookDesc:'',
      bookEdition:'',
      bookImg:'',
      bookPrice:'',
      bookPages:'',
      bookPublisher:'',
      bookTitle:'',
      category : {
        catId:'',
        catTitle:'',
        catDescription:''
      },
      language : {
        langId:'',
        language:''
      }
  }

  categories = [
    {
      catId:'',
      catTitle:'',
      catDescription:''
    }
  ]

  languages = [
    {
      langId:'',
      language:''
    }
  ]
  constructor(private _book:BookService,
    private _category:CategoryService,
    private _language:LanguageService,
    private _snack:MatSnackBar) { }

  ngOnInit(): void {
    this._book.getAllBooks().subscribe(
      (data:any) => {
        this.books = data;
      },(error) => {
        console.log(error);
      }
    )
    this._category.getAllCategory().subscribe(
      (data:any) => {
        this.categories = data;
      },(error) => {
        console.log(error);
      }
    )
    this._language.getLanguage().subscribe(
      (data:any) => {
        this.languages = data;
      },(error) => {
        console.log(error);
      }
    )
  }

  formSubmit(){
    console.log(this.book);
    if(this.book.bookAuthor.trim() == ''){
      this._snack.open('Book Author required','',{duration:3000,});
      return;
    }else if(this.book.bookBinding.trim() == ''){
      this._snack.open('Book Binding required','',{duration:3000,});
      return;
    }else if(this.book.bookDesc.trim() == ''){
      this._snack.open('Book Description required','',{duration:3000,});
      return;
    }else if(this.book.bookEdition.trim() == ''){
      this._snack.open('Book Edition required','',{duration:3000,});
      return;
    }else if(this.book.bookPrice.trim() == ''){
      this._snack.open('Book Price required','',{duration:3000,});
      return;
    }else if(this.book.bookPages.trim() == ''){
      this._snack.open('No. of Pages are required','',{duration:3000,});
      return;
    }else if(this.book.bookTitle.trim() == ''){
      this._snack.open('Book Title required','',{duration:3000,});
      return;
    }
    // else if(this.book.category.catId.trim() == ''){
    //   this._snack.open('Book Category required','',{duration:3000,});
    //   return;
    // }else if(this.book.language.language.trim() == ''){
    //   this._snack.open('Book Language required','',{duration:3000,});
    //   return;
    // }
    this._book.addBook(this.book).subscribe(
      (data:any) => {
        Swal.fire("Succes ",'Book is Added successfully','success');
        this.book = {
          bookId:'',
          bookAuthor:'',
          bookBinding:'',
          bookDesc:'',
          bookEdition:'',
          bookImg:'',
          bookPrice:'',
          bookPages:'',
          bookPublisher:'',
          bookTitle:'',
          category:{
            catId:'',
            catTitle:'',
            catDescription:''
          },
          language:{
            langId:'',
            language:''
          },
        };
      },(error) => {
        console.log(error);
      }
    )
  }

  deleteBook(bookId:any){
    console.log("book id" + this.book.bookId);
    Swal.fire({
      title: 'Do you want to delete this book ?',
    showDenyButton: true,
    showCancelButton: true,
    confirmButtonText: 'Yes',
    denyButtonText: 'No',
    customClass: {
      actions: 'my-actions',
      cancelButton: 'order-1 right-gap',
      confirmButton: 'order-2',
      denyButton: 'order-3',
    }
    }).then((result)=>{
      if(result.isConfirmed){
        this._book.deleteBook(bookId).subscribe(
          (data:any)=>{
            console.log(data);
          },(error) => {
            console.log(error);
            Swal.fire("Error !! ","Error in deleting book","error");
          this._snack.open('something went wrong ','',{duration:3000})
          }
        )
        Swal.fire('Deleted !', '', 'success')
      }else if (result.isDenied) {
        Swal.fire('Book is not delete', '', 'info')
      }
    })
  }
}
