import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateConsumerComponent } from './create-consumer.component';

describe('CreateConsumerComponent', () => {
  let component: CreateConsumerComponent;
  let fixture: ComponentFixture<CreateConsumerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateConsumerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateConsumerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
