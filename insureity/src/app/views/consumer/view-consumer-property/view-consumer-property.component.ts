import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConsumerService } from 'app/services/consumer.service';

@Component({
  selector: 'app-view-consumer-property',
  templateUrl: './view-consumer-property.component.html',
  styleUrls: ['./view-consumer-property.component.css'],
})
export class ViewConsumerPropertyComponent implements OnInit {
  public consumerId: any;
  public propertyId: any;
  public response: any;
  state: any;
  constructor(
    private _consumerService: ConsumerService,
    private _router: Router
  ) {}

  ngOnInit(): void {
    this.state = history.state;
    console.log(this.state);

    this.getConsumerProperty();
  }

  public getConsumerProperty(): any {
    return this._consumerService
      .getConsumerProperty(this.state.consumerId, this.state.propertyId)
      .subscribe(
        (res: any) => {
          console.log(res);
          this.response = res;
        },
        (error: any) => {
          console.error(error);
        }
      );
  }
}
