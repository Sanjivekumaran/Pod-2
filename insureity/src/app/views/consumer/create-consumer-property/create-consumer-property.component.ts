import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Consumer } from 'app/models/consumer.model';
import { Property } from 'app/models/property.model';
import { ConsumerService } from 'app/services/consumer.service';

@Component({
  selector: 'app-create-consumer-property',
  templateUrl: './create-consumer-property.component.html',
  styleUrls: ['./create-consumer-property.component.css'],
})
export class CreateConsumerPropertyComponent implements OnInit {
  public propertyForm!: FormGroup;
  public response: any;
  constructor(
    private _consumerService: ConsumerService,
    private _router: Router
  ) {}

  ngOnInit(): void {
    this.propertyForm = new FormGroup({
      businessId: new FormControl(),
      consumerId: new FormControl(),
      buildingSqFt: new FormControl(),
      buildingType: new FormControl(),
      buildingStoreys: new FormControl(),
      buildingAge: new FormControl(),
      propertyValue: new FormControl(),
      costOftheAsset: new FormControl(),
      salvageValue: new FormControl(),
      usefulLifeofAsset: new FormControl(),
    });
  }

  onSubmit(consumerForm: Property): void {
    console.log(consumerForm);

    this._consumerService
      .addBusinessProperty(consumerForm)
      .subscribe((data: any) => {
        this.response =
          'Successfully created Business Property with Consumer ID: ' +
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
