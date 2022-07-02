import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewConsumerComponent } from './view-consumer.component';

describe('ViewConsumerComponent', () => {
  let component: ViewConsumerComponent;
  let fixture: ComponentFixture<ViewConsumerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewConsumerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewConsumerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
