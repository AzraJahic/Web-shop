import { ProductsService } from './../products.service';
import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Client } from '../client.model';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  clientMessage: Client
  registerForm: FormGroup;
  submitted = false;

  constructor(private productsService: ProductsService, private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
        name: ['', Validators.required],
        lastName: ['', Validators.required],
        phoneNumber: ['', [Validators.required]],
        clientEmail: ['', [Validators.required, Validators.email]],
        clientMessage: ['', [Validators.required]]
    });
  }

  onSubmit() {
    this.submitted = true;

    if (this.registerForm.invalid) {
      alert('Niste ispravno popunili sva polja!')
        return;
    }
    else{
      const clientMessage: Client = {
          "clientName" :  this.registerForm.controls['name'].value,
          "clientLastName" : this.registerForm.controls['lastName'].value, 
          "clientPhoneNumber" : this.registerForm.controls['phoneNumber'].value,
          "clientEmail" : this.registerForm.controls['clientEmail'].value,
          "clientMsg" : this.registerForm.controls['clientMessage'].value
      };

      this.productsService.sendMessageToServer(clientMessage).subscribe(
        () => { alert('Vaša poruka je uspješno poslana!'); this.submitted = false; this.registerForm.reset(); },
        error => { alert("No response from Server!"); this.submitted = false; this.registerForm.reset(); }
      );
    }

  }

}
