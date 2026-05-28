import { Component, input, output } from '@angular/core';
import { Producto } from '../../../models/producto.model';

@Component({
  selector: 'app-producto-card',
  templateUrl: './producto-card.html',
  styleUrl: './producto-card.css'
})
export class ProductoCard {
  producto = input.required<Producto>();
  editClick = output<void>();
  deleteClick = output<void>();

  formatPrice(price: number): string {
    return '$ ' + Math.round(price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, '.');
  }
}
