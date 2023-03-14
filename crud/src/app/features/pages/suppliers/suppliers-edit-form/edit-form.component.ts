import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-suppliers-companies-edit-form',
  templateUrl: './edit-form.component.html',
  styleUrls: ['./edit-form.component.scss']
})
export class SuppliersEditFormComponent implements OnInit {
  user: any;
  editForm!: FormGroup;
  constructor(private formBuilder: FormBuilder,private router: Router) { }
  ngOnInit() {
    // let userId = window.localStorage.getItem("editUserId");
    // if(!userId) {
    //   alert("Invalid action.")
    //   this.router.navigate(['list-user']);
    //   return;
    // }
    this.editForm = this.formBuilder.group({
      documentNumber: ['', Validators.required],
      name: ['', Validators.required],
      postalcode: ['', Validators.required]
    });
    // this.apiService.getUserById(+userId)
    //   .subscribe( data => {
    //     this.editForm.setValue(data.result);
    //   });
  }
  onSubmit() {

  }

}
