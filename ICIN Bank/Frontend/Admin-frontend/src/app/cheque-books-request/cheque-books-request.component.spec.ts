import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequeBooksRequestComponent } from './cheque-books-request.component';

describe('ChequeBooksRequestComponent', () => {
  let component: ChequeBooksRequestComponent;
  let fixture: ComponentFixture<ChequeBooksRequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChequeBooksRequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChequeBooksRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
