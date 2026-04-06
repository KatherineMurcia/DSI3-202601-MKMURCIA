import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InputFiel } from './input-field';

describe('InputFiel', () => {
  let component: InputFiel;
  let fixture: ComponentFixture<InputFiel>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InputFiel],
    }).compileComponents();

    fixture = TestBed.createComponent(InputFiel);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
