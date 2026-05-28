import { Component, input } from '@angular/core';

@Component({
  selector: 'app-stat-card',
  templateUrl: './stat-card.html',
  styleUrl: './stat-card.css'
})
export class StatCard {
  label = input('');
  value = input<string | number>('');
}
