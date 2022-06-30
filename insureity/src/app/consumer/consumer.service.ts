import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const CONSUMER_API_BASE_URL = 'http://localhost:8080/api/v1/employees';

@Injectable({
  providedIn: 'root',
})
export class ConsumerService {
  constructor(private http: HttpClient) {}
  addConsumer(consumer: Consumer) {
    return this.http.post<Consumer>(CONSUMER_API_BASE_URL, consumer);
  }

  addProperty(property: Property) {
    return this.http.post<Property>(CONSUMER_API_BASE_URL, property);
  }

  updateConsumer(consumer: Consumer) {
    return this.http.put<Consumer>(CONSUMER_API_BASE_URL, consumer);
  }

  getConsumer(id: Number) {
    return this.http.get<Consumer>(CONSUMER_API_BASE_URL + '/' + id);
  }
  getProperty(id: Number) {
    return this.http.get<Property>(CONSUMER_API_BASE_URL + '/' + id);
  }
}
