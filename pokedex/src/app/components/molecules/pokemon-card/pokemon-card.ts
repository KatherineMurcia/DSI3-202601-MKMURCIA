import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PokemonDetailDto } from '../../../models/model';
import { PokemonImage } from '../../atoms/pokemon-image/pokemon-image';

@Component({
  selector: 'app-pokemon-card',
  imports: [CommonModule, PokemonImage],
  templateUrl: './pokemon-card.html',
  styleUrl: './pokemon-card.css',
})
export class PokemonCard {
  @Input() pokemon!: PokemonDetailDto;
}
