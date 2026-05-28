import { Component, OnInit, signal, inject, computed } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { PedidoService } from '../../services/pedido.service';
import { MesaService } from '../../services/mesa.service';
import { ClienteService } from '../../services/cliente.service';
import { ProductoService } from '../../services/producto.service';
import { Pedido, ItemPedido, EstadoPedido } from '../../models/pedido.model';
import { Mesa } from '../../models/mesa.model';
import { Cliente } from '../../models/cliente.model';
import { Producto } from '../../models/producto.model';
import { TabBar } from '../../components/molecules/tab-bar/tab-bar';
import { PedidoCard } from '../../components/molecules/pedido-card/pedido-card';
import { Button } from '../../components/atoms/button/button';
import { Badge } from '../../components/atoms/badge/badge';

@Component({
  selector: 'app-pedidos',
  imports: [FormsModule, DatePipe, TabBar, PedidoCard, Button, Badge],
  templateUrl: './pedidos.html',
  styleUrl: './pedidos.css'
})
export class Pedidos implements OnInit {
  private pedidoService   = inject(PedidoService);
  private mesaService     = inject(MesaService);
  private clienteService  = inject(ClienteService);
  private productoService = inject(ProductoService);

  pedidos      = this.pedidoService.pedidos;
  filtroEstado = signal<EstadoPedido | ''>('');

  tabsConCuenta = computed(() => [
    { label: 'Todos',          value: '',               count: this.pedidos().length },
    { label: 'Creada',         value: 'Creada',         count: this.pedidos().filter(p => p.estado === 'Creada').length },
    { label: 'En preparación', value: 'En preparacion', count: this.pedidos().filter(p => p.estado === 'En preparacion').length },
    { label: 'Entregada',      value: 'Entregada',      count: this.pedidos().filter(p => p.estado === 'Entregada').length },
  ]);

  pedidosFiltrados = computed(() => {
    const f = this.filtroEstado();
    const all = this.pedidos();
    return f ? all.filter(p => p.estado === f) : all;
  });

  onFiltroChange(v: string): void {
    this.filtroEstado.set(v as EstadoPedido | '');
  }

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

  showModal        = signal(false);
  showConfirm      = signal(false);
  showDetail       = signal(false);
  selectedPedido   = signal<Pedido | null>(null);
  selectedDeleteId = signal<string | null>(null);

  mesasDisponibles: Mesa[]     = [];
  clientes: Cliente[]          = [];
  productos: Producto[]        = [];
  selectedMesaId               = '';
  selectedClienteId            = '';
  selectedProductoId           = '';
  cantidadItem                 = 1;
  items: ItemPedido[]          = [];
  loadingProductos             = signal(true);

  ngOnInit(): void {
    this.productoService.getAll().subscribe({
      next:  (p) => { this.productos = p.filter(pr => pr.disponible); this.loadingProductos.set(false); },
      error: ()  => this.loadingProductos.set(false)
    });
  }

  openCreate(): void {
    this.mesasDisponibles    = this.mesaService.getDisponibles();
    this.clientes            = this.clienteService.getAll();
    this.selectedMesaId      = '';
    this.selectedClienteId   = '';
    this.selectedProductoId  = '';
    this.cantidadItem        = 1;
    this.items               = [];
    this.showModal.set(true);
  }

  addItem(): void {
    const prod = this.productos.find(p => String(p.idProducto) === this.selectedProductoId);
    if (!prod || this.cantidadItem <= 0) return;
    const existing = this.items.find(i => i.producto.idProducto === prod.idProducto);
    if (existing) {
      existing.cantidad += this.cantidadItem;
      existing.subtotal  = existing.cantidad * prod.precio;
    } else {
      this.items = [...this.items, { producto: prod, cantidad: this.cantidadItem, subtotal: this.cantidadItem * prod.precio }];
    }
    this.selectedProductoId = '';
    this.cantidadItem       = 1;
  }

  removeItem(idx: number): void {
    this.items = this.items.filter((_, i) => i !== idx);
  }

  totalItems(): number {
    return this.items.reduce((s, i) => s + i.subtotal, 0);
  }

  savePedido(): void {
    if (!this.selectedMesaId || this.items.length === 0) return;
    const mesa    = this.mesaService.getAll().find(m => m.id === this.selectedMesaId)!;
    const cliente = this.selectedClienteId ? this.clientes.find(c => c.id === this.selectedClienteId) : undefined;
    this.pedidoService.create(mesa, cliente, this.items);
    this.showModal.set(false);
  }

  avanzar(p: Pedido): void {
    this.pedidoService.avanzarEstado(p.id);
  }

  askDelete(p: Pedido): void {
    this.selectedDeleteId.set(p.id);
    this.showConfirm.set(true);
  }

  confirmDelete(): void {
    this.pedidoService.delete(this.selectedDeleteId()!);
    this.showConfirm.set(false);
  }

  openDetail(p: Pedido): void {
    this.selectedPedido.set(p);
    this.showDetail.set(true);
  }
}
