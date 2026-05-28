import { Injectable, inject, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Mesa, EstadoMesa } from '../models/mesa.model';

interface BackendMesa { idMesa: number; numero: number; capacidad: number; estado: string; }

@Injectable({ providedIn: 'root' })
export class MesaService {
  private readonly http = inject(HttpClient);
  private _mesas = signal<Mesa[]>([]);
  readonly mesas = this._mesas.asReadonly();

  constructor() { this.load(); }

  private toMesa(b: BackendMesa): Mesa {
    return { id: String(b.idMesa), numero: b.numero, capacidad: b.capacidad, estado: b.estado as EstadoMesa };
  }

  load(): void {
    this.http.get<BackendMesa[]>('/api/mesas').subscribe(data => this._mesas.set(data.map(b => this.toMesa(b))));
  }

  getAll(): Mesa[] { return this._mesas(); }

  getDisponibles(): Mesa[] {
    return this._mesas().filter(m => m.estado === 'Disponible');
  }

  create(numero: number, capacidad: number): void {
    this.http.post<BackendMesa>('/api/mesas', { numero, capacidad, estado: 'Disponible' })
      .subscribe(() => this.load());
  }

  update(id: string, numero: number, capacidad: number): void {
    const mesa = this._mesas().find(m => m.id === id);
    this.http.put<BackendMesa>(`/api/mesas/${id}`, { numero, capacidad, estado: mesa?.estado ?? 'Disponible' })
      .subscribe(() => this.load());
  }

  delete(id: string): void {
    this.http.delete<void>(`/api/mesas/${id}`).subscribe(() => this.load());
  }

  setEstado(id: string, estado: EstadoMesa): void {
    const mesa = this._mesas().find(m => m.id === id);
    if (!mesa) return;
    this.http.put<BackendMesa>(`/api/mesas/${id}`, { numero: mesa.numero, capacidad: mesa.capacidad, estado })
      .subscribe(() => this.load());
  }
}
