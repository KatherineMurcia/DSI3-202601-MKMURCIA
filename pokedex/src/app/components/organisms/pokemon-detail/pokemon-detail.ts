import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PokemonDetailDto } from '../../../models/model';
import { SearchBar } from '../../molecules/search-bar/search-bar';
import { Badge } from '../../atoms/badge/badge';

@Component({
  selector: 'app-pokemon-detail',
  imports: [CommonModule, SearchBar, Badge],
  templateUrl: './pokemon-detail.html',
  styleUrl: './pokemon-detail.css',
})
export class PokemonDetail {
  @Input() pokemon!: PokemonDetailDto;
  @Output() search = new EventEmitter<string>();
}
