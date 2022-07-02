import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { PolicyService } from 'app/services/policy.service';

@Component({
  selector: 'app-issue-policy',
  templateUrl: './issue-policy.component.html',
  styleUrls: ['./issue-policy.component.css'],
})
export class IssuePolicyComponent implements OnInit {
  public issuePolicyForm!: FormGroup;
  public policyResponse: any;
  constructor(private _policyService: PolicyService) {}

  ngOnInit(): void {
    this.issuePolicyForm = new FormGroup({
      policyId: new FormControl(),
      consumerId: new FormControl(),
      businessId: new FormControl(),
      paymentDetails: new FormControl(),
      acceptanceStatus: new FormControl(),
    });
  }

  public onClickIssuePolicy(issuePolicyForm: any): void {
    // todo: check
    this._policyService.issuePolicy(issuePolicyForm).subscribe((data: any) => {
      this.policyResponse =
        'Policy has been issued to Policy Customer Id:' + data.customerId;
    });
  }
}
