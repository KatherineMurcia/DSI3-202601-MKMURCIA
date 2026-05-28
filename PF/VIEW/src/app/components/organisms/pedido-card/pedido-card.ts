import { Component, input, output } from '@angular/core';
import { Pedido, EstadoPedido } from '../../../models/pedido.model';
import { Badge } from '../../atoms/badge/badge';

@Component({
  selector: 'app-pedido-card',
  imports: [Badge],
  templateUrl: './pedido-card.html',
  styleUrl: './pedido-card.css'
})
export class PedidoCard {
  pedido = input.required<Pedido>();
  avanzarClick = output<void>();
  deleteClick = output<void>();
  detailClick = output<void>();

  estadoBadge(estado: string): string {
    const map: Record<string, string> = {
      'Creada': 'gray',
      'En preparacion': 'warning',
      'Entregada': 'success'
    };
    return map[estado] ?? 'gray';
  }

  estadoLabel(estado: string): string {
    return estado === 'En preparacion' ? 'En preparación' : estado;
  }

  accionLabel(estado: EstadoPedido): string {
    const map: Record<EstadoPedido, string> = {
      'Creada': 'Pasar a En Preparación',
      'En preparacion': 'Pasar a Entrega',
      'Entregada': '',
    };
    return map[estado];
  }
}
