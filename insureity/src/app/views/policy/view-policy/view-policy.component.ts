import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConsumerService } from 'app/services/consumer.service';
import { PolicyService } from 'app/services/policy.service';

@Component({
  selector: 'app-view-policy',
  templateUrl: './view-policy.component.html',
  styleUrls: ['./view-policy.component.css'],
})
export class ViewPolicyComponent implements OnInit {
  public consumerId: any;
  public response: any;
  state: any;
  constructor(private _policyService: PolicyService, private _router: Router) {}

  ngOnInit(): void {
    this.state = history.state;
    console.log(this.state);

    this.getConsumerBusiness();
  }

  public getConsumerBusiness(): any {
    return this._policyService
      .getPolicy(this.state.consumerId, this.state.policyId)
      .subscribe(
        (policy: any) => {
          console.log(policy);
          this.response = policy;
        },
        (error: any) => {
          console.error(error);
        }
      );
  }
}
