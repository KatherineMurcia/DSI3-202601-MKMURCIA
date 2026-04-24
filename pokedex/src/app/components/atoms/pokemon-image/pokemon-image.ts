import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-pokemon-image',
  imports: [CommonModule],
  templateUrl: './pokemon-image.html',
  styleUrl: './pokemon-image.css',
})
export class PokemonImage {
  @Input() src: string = '';
  @Input() alt: string = '';
}
