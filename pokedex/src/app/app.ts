import { Component, signal } from '@angular/core';
import { PokemonService } from './services/pokemon-service';
import { PokemonsListDto, PokemonDetailDto } from './models/model';
import { Router, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrls: ['./app.css'],

})
export class App {
  protected readonly isSignal = signal('pokedex');

}


