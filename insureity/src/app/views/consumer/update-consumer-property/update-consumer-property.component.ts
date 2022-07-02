import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Consumer } from 'app/models/consumer.model';
import { Property } from 'app/models/property.model';
import { ConsumerService } from 'app/services/consumer.service';

@Component({
  selector: 'app-update-consumer-property',
  templateUrl: './update-consumer-property.component.html',
  styleUrls: ['./update-consumer-property.component.css'],
})
export class UpdateConsumerPropertyComponent implements OnInit {
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
      // propertyValue: new FormControl(),
      costOftheAsset: new FormControl(),
      salvageValue: new FormControl(),
      usefulLifeofAsset: new FormControl(),
    });
  }

  onSubmit(consumerForm: Consumer): void {
    console.log(consumerForm);

    this._consumerService
      .updateBusinessProperty(consumerForm)
      .subscribe((data: any) => {
        this.response =
          'Successfully updated Business Property with Consumer ID: ' +
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
