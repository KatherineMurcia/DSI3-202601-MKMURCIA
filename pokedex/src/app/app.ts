import { Component, signal } from '@angular/core';
import { PokemonService } from './services/pokemon-service';
import { PokemonsListDto, PokemonDetailDto } from './models/model';

@Component({
  selector: 'app-root',
  imports: [],
  templateUrl: './app.html',
  styleUrls: ['./app.css'],

})
export class App {
  protected readonly isSignal = signal('pokedex');

  pokemons: PokemonsListDto[] = [];
  listPokemons: PokemonDetailDto[] = [];

  constructor(pokemonService: PokemonService) {
    pokemonService.getPokemons(0,100).subscribe((result) => {
    console.log(result);
    console.log(result.results);
    this.pokemons = result.results;

    this.pokemons.map((pokemon) => {
      pokemonService.getPokemon(pokemon.name).subscribe((response) => {
        this.listPokemons.push(response);
      });
    });
    console.log(this.listPokemons);
  }
  );
  }

}
