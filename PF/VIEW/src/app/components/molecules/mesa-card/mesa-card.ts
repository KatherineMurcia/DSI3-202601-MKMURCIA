import { Component, input, output } from '@angular/core';
import { Mesa } from '../../../models/mesa.model';

@Component({
  selector: 'app-mesa-card',
  templateUrl: './mesa-card.html',
  styleUrl: './mesa-card.css'
})
export class MesaCard {
  mesa = input.required<Mesa>();
  editClick = output<void>();
  deleteClick = output<void>();
}
