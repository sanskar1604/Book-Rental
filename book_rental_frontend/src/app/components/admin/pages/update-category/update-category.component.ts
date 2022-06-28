import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/service/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-category',
  templateUrl: './update-category.component.html',
  styleUrls: ['./update-category.component.css']
})
export class UpdateCategoryComponent implements OnInit {

  catId:any;

  category = {
    catId:'',
    catTitle:'',
    catDescription:''
  }

  constructor(
    private _route:ActivatedRoute,
    private _router:Router,
    private _category:CategoryService,
    private _snack:MatSnackBar
  ) { }

  ngOnInit(): void {
    this.catId = this._route.snapshot.params['catId'];
    this._category.getCategory(this.catId).subscribe(
      (data:any) => {
        this.category = data;
      },(error) => {
        console.log(error);
      }
    )
  }


  formSubmit(){
    if(this.category.catTitle.trim() == ''){
      this._snack.open('Category required','',{duration:3000,});
      return;
    }else if(this.category.catDescription.trim() == ''){
      this._snack.open('Category Description required','',{duration:3000,});
      return;
    }
    this._category.updateCategory(this.category, this.catId).subscribe(
      (data:any)=>{
        this.category.catTitle = '';
        this.category.catDescription = '';
        Swal.fire("Success !!", 'Category updated successfully', 'success');
        this._router.navigate(['/admin/category']);
      },(error) => {
        console.log(error);
        Swal.fire("Error !!", 'Server Error', 'error');
      }
    )
  }
}
