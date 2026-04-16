import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeCategories } from './coffee-categories';

describe('CoffeeCategories', () => {
  let component: CoffeeCategories;
  let fixture: ComponentFixture<CoffeeCategories>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoffeeCategories],
    }).compileComponents();

    fixture = TestBed.createComponent(CoffeeCategories);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
