import { Injectable, inject, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pedido, EstadoPedido, ItemPedido } from '../models/pedido.model';
import { Mesa } from '../models/mesa.model';
import { Cliente } from '../models/cliente.model';
import { Producto } from '../models/producto.model';

interface BackendDetalle { idDetalle: number; producto: Producto; cantidad: number; precioUnitario: number; subtotal: number; }
interface BackendMesa    { idMesa: number; numero: number; capacidad: number; estado: string; }
interface BackendCliente { idCliente: number; nombre: string; email: string; telefono: string; }
interface BackendPedido  {
  idPedido: number;
  mesa: BackendMesa;
  cliente?: BackendCliente;
  detalles: BackendDetalle[];
  estado: string;
  fechaCreacion: string;
  total: number;
}

@Injectable({ providedIn: 'root' })
export class PedidoService {
  private readonly http = inject(HttpClient);
  private _pedidos = signal<Pedido[]>([]);
  readonly pedidos = this._pedidos.asReadonly();

  constructor() { this.loadPedidos(); }

  private toMesa(b: BackendMesa): Mesa {
    return { id: String(b.idMesa), numero: b.numero, capacidad: b.capacidad, estado: b.estado as any };
  }

  private toCliente(b: BackendCliente): Cliente {
    return { id: String(b.idCliente), nombre: b.nombre, correo: b.email, telefono: b.telefono };
  }

  private toItem(d: BackendDetalle): ItemPedido {
    return { producto: d.producto, cantidad: d.cantidad, subtotal: d.subtotal };
  }

  private toPedido(b: BackendPedido): Pedido {
    const estadoMap: Record<string, EstadoPedido> = {
      'Creada': 'Creada',
      'En preparación': 'En preparacion',
      'Entregada': 'Entregada'
    };
    return {
      id: String(b.idPedido),
      mesa: this.toMesa(b.mesa),
      cliente: b.cliente ? this.toCliente(b.cliente) : undefined,
      items: (b.detalles ?? []).map(d => this.toItem(d)),
      estado: (estadoMap[b.estado] ?? b.estado) as EstadoPedido,
      fechaCreacion: b.fechaCreacion,
      total: b.total
    };
  }

  loadPedidos(): void {
    this.http.get<BackendPedido[]>('/api/pedidos')
      .subscribe(data => this._pedidos.set(data.map(b => this.toPedido(b))));
  }

  getAll(): Pedido[] { return this._pedidos(); }

  getActivos(): Pedido[] {
    return this._pedidos().filter(p => p.estado !== 'Entregada');
  }

  create(mesa: Mesa, cliente: Cliente | undefined, items: ItemPedido[]): void {
    const body = {
      idMesa: Number(mesa.id),
      idCliente: cliente ? Number(cliente.id) : null,
      items: items.map(i => ({ idProducto: i.producto.idProducto!, cantidad: i.cantidad }))
    };
    this.http.post<BackendPedido>('/api/pedidos', body)
      .subscribe(() => this.loadPedidos());
  }

  avanzarEstado(id: string): void {
    this.http.patch<BackendPedido>(`/api/pedidos/${id}/estado`, {})
      .subscribe(() => this.loadPedidos());
  }

  delete(id: string): void {
    this.http.delete<void>(`/api/pedidos/${id}`)
      .subscribe(() => this.loadPedidos());
  }
}
