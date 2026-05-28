import { Component, inject, OnInit, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MesaService } from '../../services/mesa.service';
import { PedidoService } from '../../services/pedido.service';
import { ProductoService } from '../../services/producto.service';
import { Pedido } from '../../models/pedido.model';
import { StatCard } from '../../components/molecules/stat-card/stat-card';
import { Badge } from '../../components/atoms/badge/badge';

interface DashboardResumen {
  totalProductosActivos: number;
  mesasDisponibles: number;
  pedidosActivos: number;
  pedidosEntregadosHoy: number;
}

@Component({
  selector: 'app-dashboard',
  imports: [StatCard, Badge],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class Dashboard implements OnInit {
  private http            = inject(HttpClient);
  mesaService             = inject(MesaService);
  private pedidoService   = inject(PedidoService);
  private productoService = inject(ProductoService);

  get totalMesas(): number { return this.mesaService.mesas().length; }
  mesasDisponibles  = 0;
  totalProductos    = signal(0);
  pedidosActivos: Pedido[] = [];
  pedidosEntregados = 0;
  pedidosRecientes: Pedido[] = [];

  ngOnInit(): void {
    this.http.get<DashboardResumen>('/api/dashboard/resumen').subscribe(r => {
      this.mesasDisponibles  = r.mesasDisponibles;
      this.pedidosEntregados = r.pedidosEntregadosHoy;
      this.totalProductos.set(r.totalProductosActivos);
    });

    this.pedidoService.loadPedidos();
    const todos = this.pedidoService.getAll();
    this.pedidosActivos   = todos.filter(p => p.estado !== 'Entregada');
    this.pedidosRecientes = [...todos].reverse().slice(0, 5);

    this.productoService.getAll().subscribe({
      next:  p => this.totalProductos.set(p.filter(x => x.disponible).length),
      error: () => {}
    });
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
    const map: Record<string, string> = {
      'Creada': 'CREADA',
      'En preparacion': 'EN PREP.',
      'Entregada': 'ENTREGADA'
    };
    return map[estado] ?? estado;
  }
}
