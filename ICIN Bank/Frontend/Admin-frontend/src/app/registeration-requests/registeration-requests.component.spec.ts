import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterationRequestsComponent } from './registeration-requests.component';

describe('RegisterationRequestsComponent', () => {
  let component: RegisterationRequestsComponent;
  let fixture: ComponentFixture<RegisterationRequestsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegisterationRequestsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterationRequestsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
