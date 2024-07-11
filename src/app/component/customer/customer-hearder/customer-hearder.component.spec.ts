import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerHearderComponent } from './customer-hearder.component';

describe('CustomerHearderComponent', () => {
  let component: CustomerHearderComponent;
  let fixture: ComponentFixture<CustomerHearderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerHearderComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerHearderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
