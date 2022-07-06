import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Consumer } from 'app/models/consumer.model';
import { ConsumerService } from 'app/services/consumer.service';

@Component({
  selector: 'app-create-consumer-business',
  templateUrl: './create-consumer-business.component.html',
  styleUrls: ['./create-consumer-business.component.css'],
})
export class CreateConsumerBusinessComponent implements OnInit {
  public consumerForm!: FormGroup;
  public hasError: boolean = false;
  public errorMsg: string = '';
  public response: any;

  constructor(
    private _consumerService: ConsumerService,
    private _fb: FormBuilder,
    private _router: Router
  ) {
    this.myForm();
  }

  //Create required field validator for name
  myForm() {
    this.consumerForm = this._fb.group({
      firstName: [
        '',
        Validators.compose([Validators.required, Validators.minLength(3)]),
      ],
      lastName: ['', Validators.required],
      email: ['', Validators.required],
      pan: ['', Validators.required],
      dob: ['', Validators.required],
      businessName: ['', Validators.required],
      businessType: ['', Validators.required],
      capitalInvested: ['', Validators.required],
      validity: ['', Validators.required],
      agentId: ['', Validators.required],
      agentName: ['', Validators.required],
      businessTurnover: ['', Validators.required],
      businessAge: ['', Validators.required],
      totalEmployees: ['', Validators.required],
    });
  }
  ngOnInit(): void {
    // this.consumerForm = new FormGroup({
    //   firstName: new FormControl(),
    //   lastName: new FormControl(),
    //   email: new FormControl(),
    //   pan: new FormControl(),
    //   dob: new FormControl(),
    //   businessName: new FormControl(),
    //   businessType: new FormControl(),
    //   capitalInvested: new FormControl(),
    //   validity: new FormControl(),
    //   agentId: new FormControl(),
    //   agentName: new FormControl(),
    //   businessTurnover: new FormControl(),
    //   businessAge: new FormControl(),
    //   totalEmployees: new FormControl(),
    // });
  }

  onSubmit(consumerForm: any): void {
    console.log(consumerForm);

    // if (!consumerForm.valid) {
    //   this.errorMsg = 'Invalid consumer form';
    //   return;
    // }
    this._consumerService.addConsumerBusiness(consumerForm).subscribe(
      (data: any) => {
        console.log(data);
        if (data == 'Created')
          this.response = 'Successfully created Consumer Business';
        // 'Successfully created Consumer Business with Consumer ID: ' +
        // data.consumerId +
        // 'and Business ID: ' +
        // data.businessId;
        // this._router.navigate(['/']);
      },
      (error: HttpErrorResponse) => {
        this.hasError = true;
        if (error.error.error != null) this.errorMsg = error.error.error;
        else this.errorMsg = error.error;
        console.error(error);
      }
    );
  }

  onCancel(): void {
    this._router.navigate(['/']);
  }
}
