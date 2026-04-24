import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PokemonImage } from './pokemon-image';

describe('PokemonImage', () => {
  let component: PokemonImage;
  let fixture: ComponentFixture<PokemonImage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PokemonImage],
    }).compileComponents();

    fixture = TestBed.createComponent(PokemonImage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
