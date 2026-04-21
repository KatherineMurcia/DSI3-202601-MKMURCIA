import { ChangeDetectorRef, Component } from '@angular/core';
import { PokemonDetailDto, PokemonsListDto } from '../../models/model';
import { PokemonService } from '../../services/pokemon-service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-pokemon-pages',
  imports: [CommonModule],
  templateUrl: './pokemon-pages.html',
  styleUrl: './pokemon-pages.css',
})
export class PokemonPages {
   pokemons: PokemonsListDto[] = [];
  listPokemons: PokemonDetailDto[] = [];

  constructor(pokemonService: PokemonService, private cdr: ChangeDetectorRef) {
    pokemonService.getPokemons(0,100).subscribe((result) => {
    this.listPokemons = result as PokemonDetailDto[];
    console.log(this.listPokemons);
    this.cdr.detectChanges();
}
    );
  }}
