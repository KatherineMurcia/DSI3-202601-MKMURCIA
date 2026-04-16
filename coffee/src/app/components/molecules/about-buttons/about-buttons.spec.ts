import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutButtons } from './about-buttons';

describe('AboutButtons', () => {
  let component: AboutButtons;
  let fixture: ComponentFixture<AboutButtons>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AboutButtons],
    }).compileComponents();

    fixture = TestBed.createComponent(AboutButtons);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
