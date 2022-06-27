import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LanguageService } from 'src/app/service/language.service';
import swal from 'sweetalert2';

@Component({
  selector: 'app-language',
  templateUrl: './language.component.html',
  styleUrls: ['./language.component.css']
})
export class LanguageComponent implements OnInit {

  languages=[
    {
      langId:'',
      language:''
    }
  ]
  lang={
    langId:'',
    language:''
  }

  // l={
  //   langId:''
  // }
  constructor(private _language:LanguageService, private _snack:MatSnackBar) { }

  ngOnInit(): void {
    this._language.getLanguage().subscribe((data:any)=>{
      this.languages=data;
      console.log(this.languages);
    },(error)=>{
      console.log(error);
    })
  }

  formSubmit(){
    if(this.lang.language.trim() == ''){
      this._snack.open('Language Required', '', {
        duration:3000,
      })
      return;
    }
    this._language.addLanguage(this.lang).subscribe(
      (data:any)=>{
        this.lang.language='';
        console.log(this.lang.language);
        swal.fire("Success !!", 'Language added successfully', 'success');
      },(error)=>{
        console.log(error);
        swal.fire("Error !!", 'Server Error', 'error');
      }
    )
  }

  deleteLanguage(langId:any){
    console.log("language id" + this.lang.langId);
    swal.fire({
      title: 'Do you want to delete this language?',
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
        this._language.deleteLanguage(langId).subscribe(
          (data:any)=>{
            console.log(data);
          },(error) => {
            console.log(error);
            swal.fire("Error !! ","Error in deleting language","error");
          this._snack.open('something went wrong ','',{duration:3000})
          }
        )
        swal.fire('Deleted !', '', 'success')
      }else if (result.isDenied) {
        swal.fire('Language is not delete', '', 'info')
      }
    })
  }
}
