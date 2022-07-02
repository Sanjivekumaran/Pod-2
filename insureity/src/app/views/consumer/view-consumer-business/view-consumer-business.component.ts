import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConsumerService } from 'app/services/consumer.service';

@Component({
  selector: 'app-view-consumer-business',
  templateUrl: './view-consumer-business.component.html',
  styleUrls: ['./view-consumer-business.component.css'],
})
export class ViewConsumerBusinessComponent implements OnInit {
  public consumerId: any;
  public response: any;
  state: any;
  constructor(
    private _consumerService: ConsumerService,
    private _router: Router
  ) {}

  ngOnInit(): void {
    this.state = history.state;
    console.log(this.state);

    this.getConsumerBusiness();
  }

  public getConsumerBusiness(): any {
    return this._consumerService
      .getConsumerBusiness(this.state.consumerId)
      .subscribe(
        (consumerBusiness: any) => {
          console.log(consumerBusiness);
          this.response = consumerBusiness;
        },
        (error: any) => {
          console.error(error);
        }
      );
  }
}
