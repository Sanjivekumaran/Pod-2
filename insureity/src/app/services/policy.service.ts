import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Policy } from 'app/models/policy.model';

const POLICY_API_BASE_URL = 'http://localhost:8080/api/v1/employees';
@Injectable({
  providedIn: 'root',
})
export class PolicyService {
  constructor(private http: HttpClient) {}
  // createPolicy
  public addPolicy(consumer: Policy): any {
    return this.http.post<Policy>(POLICY_API_BASE_URL, consumer);
  }
  // issuePolicy;
  public issuePolicy(policy: Policy): any {
    // todo
    return this.http.get<Policy>(POLICY_API_BASE_URL + '/');
  }

  // viewPolicy
  public getPolicy(policyId: string, consumerId: string) {
    return this.http.get<Policy>(
      POLICY_API_BASE_URL + '/' + policyId + '/' + consumerId
    );
  }

  // getQuotes;
  public getQuotes(businessValue: Number, propertyValue: Number) {
    return this.http.get<any>(
      POLICY_API_BASE_URL + '/' + businessValue + '/' + propertyValue
    );
  }
}
