import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Consumer } from 'app/models/consumer.model';
import { Property } from 'app/models/property.model';

const CONSUMER_API_BASE_URL = 'https://jsonplaceholder.typicode.com/todos';

@Injectable({
  providedIn: 'root',
})
export class ConsumerService {
  constructor(private http: HttpClient) {}
  // createConsumerBusiness
  public addConsumerBusiness(consumer: Consumer): any {
    return this.http.post<Consumer>(CONSUMER_API_BASE_URL, consumer);
  }

  // createBusinessProperty
  public addBusinessProperty(property: Property): any {
    return this.http.post<Property>(CONSUMER_API_BASE_URL, property);
  }

  // updateConsumerBusiness
  public updateConsumerBusiness(consumer: Consumer): any {
    return this.http.put<Consumer>(CONSUMER_API_BASE_URL, consumer);
  }

  // updateBusinessProperty
  public updateBusinessProperty(property: Property): any {
    return this.http.put<Consumer>(CONSUMER_API_BASE_URL, property);
  }

  // viewConsumerBusiness
  public getConsumerBusiness(id: number): any {
    console.log(CONSUMER_API_BASE_URL + '/' + id);
    return this.http.get<Consumer>(CONSUMER_API_BASE_URL + '/' + id); //.pipe(map((response: any) => response.json()));
  }

  // viewConsumerProperty
  public getConsumerProperty(consumerId: number, propertyId: number): any {
    return this.http.get<Property>(
      CONSUMER_API_BASE_URL + '/' + consumerId + '/' + propertyId
    );
  }
}
