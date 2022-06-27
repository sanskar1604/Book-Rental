import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CategoryService } from 'src/app/service/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  categories=[
    {
      catId:'',
      catTitle:'',
      catDescription:''
    }
  ]
  cat={
    catId:'',
    catTitle:'',
    catDescription:''
  }
  constructor(private _category:CategoryService, private _snack:MatSnackBar) { }

  ngOnInit(): void {
    this._category.getAllCategory().subscribe((data:any)=>{
      this.categories=data;
      console.log(this.categories);
    },(error)=>{
      console.log(error);
    })
  }

  formSubmit(){
    if(this.cat.catTitle.trim() == ''){
      this._snack.open('Category required','',{duration:3000,});
      return;
    }else if(this.cat.catDescription.trim() == ''){
      this._snack.open('Category Description required','',{duration:3000,});
      return;
    }
    this._category.addCategory(this.cat).subscribe(
      (data:any)=>{
        this.cat.catTitle = '';
        this.cat.catDescription = '';
        console.log(this.cat.catTitle);
        console.log(this.cat.catDescription);
        Swal.fire("Success !!", 'Language added successfully', 'success');
      },(error) => {
        console.log(error);
        Swal.fire("Error !!", 'Server Error', 'error');
      }
    )
  }

  deleteCategory(catId:any){
    console.log("language id" + this.cat.catId);
    Swal.fire({
      title: 'Do you want to delete this category?',
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
        this._category.deleteCategory(catId).subscribe(
          (data:any)=>{
            console.log(data);
          },(error) => {
            console.log(error);
            Swal.fire("Error !! ","Error in deleting category","error");
          this._snack.open('something went wrong ','',{duration:3000})
          }
        )
        Swal.fire('Deleted !', '', 'success')
      }else if (result.isDenied) {
        Swal.fire('Category is not delete', '', 'info')
      }
    })
  }
}
