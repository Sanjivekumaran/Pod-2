import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateConsumerComponent } from './update-consumer.component';

describe('UpdateConsumerComponent', () => {
  let component: UpdateConsumerComponent;
  let fixture: ComponentFixture<UpdateConsumerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateConsumerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateConsumerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
