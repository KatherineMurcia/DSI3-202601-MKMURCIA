import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeNav } from './coffee-nav';

describe('CoffeeNav', () => {
  let component: CoffeeNav;
  let fixture: ComponentFixture<CoffeeNav>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoffeeNav],
    }).compileComponents();

    fixture = TestBed.createComponent(CoffeeNav);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
