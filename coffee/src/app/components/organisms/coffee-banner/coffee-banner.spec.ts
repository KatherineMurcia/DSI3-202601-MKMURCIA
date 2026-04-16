import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeBanner } from './coffee-banner';

describe('CoffeeBanner', () => {
  let component: CoffeeBanner;
  let fixture: ComponentFixture<CoffeeBanner>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoffeeBanner],
    }).compileComponents();

    fixture = TestBed.createComponent(CoffeeBanner);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
