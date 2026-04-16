import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeFooter } from './coffee-footer';

describe('CoffeeFooter', () => {
  let component: CoffeeFooter;
  let fixture: ComponentFixture<CoffeeFooter>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoffeeFooter],
    }).compileComponents();

    fixture = TestBed.createComponent(CoffeeFooter);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
