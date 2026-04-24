import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PokemonDetailDto } from '../../../models/model';
import { SearchBar } from '../../molecules/search-bar/search-bar';

@Component({
  selector: 'app-pokemon-detail',
  imports: [CommonModule, SearchBar],
  templateUrl: './pokemon-detail.html',
  styleUrl: './pokemon-detail.css',
})
export class PokemonDetail {
  @Input() pokemon!: PokemonDetailDto;
  @Output() search = new EventEmitter<string>();
}
