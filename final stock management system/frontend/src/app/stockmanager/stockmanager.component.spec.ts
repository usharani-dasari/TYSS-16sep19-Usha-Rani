import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StockmanagerComponent } from './stockmanager.component';

describe('StockmanagerComponent', () => {
  let component: StockmanagerComponent;
  let fixture: ComponentFixture<StockmanagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StockmanagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StockmanagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
