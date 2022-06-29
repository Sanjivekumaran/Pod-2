import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const POLICY_API_BASE_URL = 'http://localhost:8080/api/v1/employees';
@Injectable({
  providedIn: 'root',
})
export class PolicyService {
  constructor(private http: HttpClient) {}
  addPolicy(consumer: Policy) {
    return this.http.post<Policy>(POLICY_API_BASE_URL, consumer);
  }
  getPolicy(id: Number) {
    return this.http.get<Policy>(POLICY_API_BASE_URL + '/' + id);
  }
}
