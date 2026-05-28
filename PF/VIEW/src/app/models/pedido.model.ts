import { Mesa } from './mesa.model';
import { Cliente } from './cliente.model';
import { Producto } from './producto.model';

export type EstadoPedido = 'Creada' | 'En preparacion' | 'Entregada';

export interface ItemPedido {
  producto: Producto;
  cantidad: number;
  subtotal: number;
}

export interface Pedido {
  id: string;
  mesa: Mesa;
  cliente?: Cliente;
  items: ItemPedido[];
  estado: EstadoPedido;
  fechaCreacion: string;
  total: number;
}
