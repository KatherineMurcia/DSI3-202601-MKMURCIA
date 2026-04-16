import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeCard } from './coffee-card';

describe('CoffeeCard', () => {
  let component: CoffeeCard;
  let fixture: ComponentFixture<CoffeeCard>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoffeeCard],
    }).compileComponents();

    fixture = TestBed.createComponent(CoffeeCard);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
