import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PokemonDetailDto } from '../../../models/model';
import { PokemonCard } from '../../molecules/pokemon-card/pokemon-card';

@Component({
  selector: 'app-pokemon-gallery',
  imports: [CommonModule, PokemonCard],
  templateUrl: './pokemon-gallery.html',
  styleUrl: './pokemon-gallery.css',
})
export class PokemonGallery {
  @Input() pokemons: PokemonDetailDto[] = [];
  @Input() offset: number = 0;
  @Output() selectPokemon = new EventEmitter<PokemonDetailDto>();
  @Output() next = new EventEmitter<void>();
  @Output() prev = new EventEmitter<void>();
}
