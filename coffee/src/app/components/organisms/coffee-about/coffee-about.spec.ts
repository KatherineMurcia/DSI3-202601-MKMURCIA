import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeAbout } from './coffee-about';

describe('CoffeeAbout', () => {
  let component: CoffeeAbout;
  let fixture: ComponentFixture<CoffeeAbout>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoffeeAbout],
    }).compileComponents();

    fixture = TestBed.createComponent(CoffeeAbout);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
