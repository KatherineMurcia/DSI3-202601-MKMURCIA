import { PokemonDetailDto } from './../models/model';
import { PokemonsDto, PokemonsListDto } from '../models/model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class PokemonService {
  private readonly BASE_URL = "https://pokeapi.co/api/v2";
  private readonly POKEMON_PATH = "/pokemon";
  private readonly TYPE_PATH = "/type";

  constructor(private http: HttpClient) {}

  getPokemons(offset: number = 0, limit: number = 20): Observable<PokemonsDto> {
    return this.http.get<PokemonsDto>(
      `${this.BASE_URL}${this.POKEMON_PATH}?offset=${offset}&limit=${limit}`
    );
  }

  getPokemon(name: string): Observable<PokemonDetailDto>{
    return this.http.get<PokemonDetailDto>(`${this.BASE_URL}${this.POKEMON_PATH}/${name}`

    );
}
}


