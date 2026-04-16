import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-coffee-card',
  imports: [],
  templateUrl: './coffee-card.html',
  styleUrl: './coffee-card.css',
})
export class CoffeeCard {
  @Input() image: string = '';
  @Input() title: string = '';
}
