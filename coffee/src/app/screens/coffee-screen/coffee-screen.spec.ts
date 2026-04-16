import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeScreen } from './coffee-screen';

describe('CoffeeScreen', () => {
  let component: CoffeeScreen;
  let fixture: ComponentFixture<CoffeeScreen>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoffeeScreen],
    }).compileComponents();

    fixture = TestBed.createComponent(CoffeeScreen);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
