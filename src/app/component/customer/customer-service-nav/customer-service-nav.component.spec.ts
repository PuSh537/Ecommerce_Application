import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerServiceNavComponent } from './customer-service-nav.component';

describe('CustomerServiceNavComponent', () => {
  let component: CustomerServiceNavComponent;
  let fixture: ComponentFixture<CustomerServiceNavComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerServiceNavComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerServiceNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
