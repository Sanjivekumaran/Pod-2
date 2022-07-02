import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Consumer } from 'app/models/consumer.model';
import { ConsumerService } from 'app/services/consumer.service';

@Component({
  selector: 'app-update-consumer-business',
  templateUrl: './update-consumer-business.component.html',
  styleUrls: ['./update-consumer-business.component.css'],
})
export class UpdateConsumerBusinessComponent implements OnInit {
  public consumerForm!: FormGroup;
  public response: any;
  constructor(
    private _consumerService: ConsumerService,
    private _router: Router
  ) {}

  ngOnInit(): void {
    this.consumerForm = new FormGroup({
      firstName: new FormControl(),
      lastName: new FormControl(),
      email: new FormControl(),
      pan: new FormControl(),
      dob: new FormControl(),
      businessName: new FormControl(),
      businessType: new FormControl(),
      capitalInvested: new FormControl(),
      validity: new FormControl(),
      agentId: new FormControl(),
      agentName: new FormControl(),
      businessTurnover: new FormControl(),
      businessAge: new FormControl(),
      totalEmployees: new FormControl(),
    });
  }

  onSubmit(consumerForm: Consumer): void {
    console.log(consumerForm);

    this._consumerService
      .updateConsumerBusiness(consumerForm)
      .subscribe((data: any) => {
        this.response =
          'Successfully updated Consumer Business with Consumer ID: ' +
          data.consumerId +
          'and Business ID: ' +
          data.businessId;
        // this._router.navigate(['/']);
      });
  }

  onCancel(): void {
    this._router.navigate(['/']);
  }
}
