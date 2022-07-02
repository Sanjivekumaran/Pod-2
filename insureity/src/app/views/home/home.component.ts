import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ConsumerService } from 'app/services/consumer.service';
import { PolicyService } from 'app/services/policy.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  public consumerId: any;

  public consumerId2: any;
  public propertyId: any;

  public businessValue: any;
  public propertyValue: any;
  public propertyType: any;

  public consumerId3: any;
  public policyId: any;

  public quoteResponse: any;

  public consumerBusinessForm!: FormGroup;
  public consumerPropertyForm!: FormGroup;
  public policyForm!: FormGroup;
  public quotesForm!: FormGroup;

  constructor(
    private _consumerService: ConsumerService,
    private _policyService: PolicyService,
    private _router: Router
  ) {}

  ngOnInit(): void {
    this.consumerBusinessForm = new FormGroup({
      consumerId: new FormControl(),
    });

    this.consumerPropertyForm = new FormGroup({
      consumerId2: new FormControl(),
      propertyId: new FormControl(),
    });

    this.quotesForm = new FormGroup({
      businessValue: new FormControl(),
      propertyValue: new FormControl(),
      propertyType: new FormControl(),
    });

    this.policyForm = new FormGroup({
      consumerId3: new FormControl(),
      policyId: new FormControl(),
    });
  }

  // consumerbusiness function
  public onClickAddConsumerBusiness(): void {
    this._router.navigate(['/createConsumerBusiness']);
  }
  public onClickViewConsumerBusiness(consumerBusinessForm: any): void {
    // this._router.navigate(['/viewConsumerBusiness/']);
    this._router.navigateByUrl('/viewConsumerBusiness', {
      state: consumerBusinessForm,
    });
  }
  public onClickUpdateConsumerBusiness(): void {
    this._router.navigate(['/updateConsumerBusiness']);
  }

  // consumer property function
  public onClickViewConsumerProperty(consumerPropertyForm: any): void {
    // this._router.navigate(['/viewConsumerProperty']);
    this._router.navigateByUrl('/viewConsumerProperty', {
      state: consumerPropertyForm,
    });
  }
  public onClickAddConsumerProperty(): void {
    this._router.navigate(['/createConsumerProperty']);
  }
  public onClickUpdateConsumerProperty(): void {
    this._router.navigate(['/updateConsumerProperty']);
  }

  // quotes function
  public onClickViewQuotes(quotesForm: any): void {
    // todo: check
    this.quoteResponse = '81,000 INR';
  }

  // policy function
  public onClickViewPolicy(policyForm: any): void {
    // this._router.navigate(['/viewPolicy']);

    this._router.navigateByUrl('/viewPolicy', {
      state: policyForm,
    });
  }
  public onClickAddPolicy(): void {
    this._router.navigate(['/createPolicy']);
  }
}
