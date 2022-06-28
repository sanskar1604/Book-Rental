import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { BookService } from 'src/app/service/book.service';

@Component({
  selector: 'app-view-book',
  templateUrl: './view-book.component.html',
  styleUrls: ['./view-book.component.css']
})
export class ViewBookComponent implements OnInit {

  bookId:any;

  books = 
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
  constructor(
    private _book:BookService,
    private _route:ActivatedRoute,
    private _snack:MatSnackBar
  ) { }

  ngOnInit(): void {
    this.bookId = this._route.snapshot.params['bookId'];
    this._book.getBook(this.bookId).subscribe(
      (data:any) => {
        this.books = data;
      },(error) => {
        console.log(error);
      }
    )
  }

}
