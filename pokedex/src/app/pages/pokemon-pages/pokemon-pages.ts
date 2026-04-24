import { ChangeDetectorRef, Component } from '@angular/core';
import { PokemonDetailDto, PokemonsListDto } from '../../models/model';
import { PokemonService } from '../../services/pokemon-service';
import { CommonModule } from '@angular/common';
import { PokemonGallery } from '../../components/organisms/pokemon-gallery/pokemon-gallery';
import { PokemonDetail } from '../../components/organisms/pokemon-detail/pokemon-detail';
import { MainLayout } from '../../components/templates/main-layout/main-layout';

@Component({
  selector: 'app-pokemon-pages',
  imports: [CommonModule, PokemonGallery, PokemonDetail, MainLayout],
  templateUrl: './pokemon-pages.html',
  styleUrl: './pokemon-pages.css',
})
export class PokemonPages {
  pokemons: PokemonsListDto[] = [];
  listPokemons: PokemonDetailDto[] = [];
  selectedPokemon: PokemonDetailDto | null = null;
  searchError: boolean = false;
  offset: number = 0;
  limit: number = 20;

  constructor(private pokemonService: PokemonService, private cdr: ChangeDetectorRef) {
    this.loadPokemons();
  }

  loadPokemons(): void {
    this.pokemonService.getPokemons(this.offset, this.limit).subscribe((result) => {
      this.listPokemons = result as PokemonDetailDto[];
      console.log(this.listPokemons);
      this.cdr.detectChanges();
    });
  }

  onSelectPokemon(pokemon: PokemonDetailDto): void {
    this.selectedPokemon = pokemon;
    this.searchError = false;
    this.cdr.detectChanges();
  }

  onSearch(query: string): void {
    if (!query.trim()) {
    this.selectedPokemon = null;
    this.searchError = false;
    this.cdr.detectChanges();
    return;
  }
  this.pokemonService.getPokemon(query.trim().toLowerCase()).subscribe({
    next: (pokemon) => {
      this.selectedPokemon = pokemon;
      this.searchError = false;
      this.cdr.detectChanges();
    },
    error: () => {
      this.selectedPokemon = null;
      this.searchError = true;
      this.cdr.detectChanges();
    }
  });
}

  onNext(): void {
    this.offset += this.limit;
    this.loadPokemons();
  }

  onPrev(): void {
    if (this.offset > 0) {
      this.offset -= this.limit;
      this.loadPokemons();
    }
  }

}

