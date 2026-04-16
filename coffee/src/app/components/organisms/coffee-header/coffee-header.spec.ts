import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CoffeeHeader } from './coffee-header';

describe('CoffeeHeader', () => {
  let component: CoffeeHeader;
  let fixture: ComponentFixture<CoffeeHeader>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CoffeeHeader],
    }).compileComponents();

    fixture = TestBed.createComponent(CoffeeHeader);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
