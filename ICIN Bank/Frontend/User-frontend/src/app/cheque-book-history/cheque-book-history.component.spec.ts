import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequeBookHistoryComponent } from './cheque-book-history.component';

describe('ChequeBookHistoryComponent', () => {
  let component: ChequeBookHistoryComponent;
  let fixture: ComponentFixture<ChequeBookHistoryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChequeBookHistoryComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChequeBookHistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
