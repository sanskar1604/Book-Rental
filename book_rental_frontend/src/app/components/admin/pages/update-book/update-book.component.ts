import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, RouteConfigLoadStart, Router } from '@angular/router';
import { BookService } from 'src/app/service/book.service';
import { CategoryService } from 'src/app/service/category.service';
import { LanguageService } from 'src/app/service/language.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  bookId:any;
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
  constructor(
    private _book:BookService,
    private _route:ActivatedRoute,
    private _snack:MatSnackBar,
    private _category:CategoryService,
    private _language:LanguageService,
    private _router:Router,
  ) { }

  ngOnInit(): void {
    this.bookId = this._route.snapshot.params['bookId'];
    console.log(this.bookId);
    this._book.getBook(this.bookId).subscribe(
      (data:any) => {
        this.book = data;
        console.log(this.book);
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
    }
    // else if(this.book.bookPrice.trim() == ''){
    //   this._snack.open('Book Price required','',{duration:3000,});
    //   return;
    // }
    // else if(this.book.bookPages.trim() == ''){
    //   this._snack.open('No. of Pages are required','',{duration:3000,});
    //   return;
    // }
    else if(this.book.bookTitle.trim() == ''){
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
    this._book.updateBook(this.book, this.bookId).subscribe(
      (data:any) => {
        Swal.fire("Succes ",'Book is Update successfully','success');
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
        this._router.navigate(['/admin/book']);
      },(error) => {
        console.log(error);
      }
    )
  }

}
