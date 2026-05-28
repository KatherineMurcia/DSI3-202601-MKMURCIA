import { Injectable, inject, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from '../models/cliente.model';

interface BackendCliente { idCliente: number; nombre: string; email: string; telefono: string; fechaRegistro?: string; }

@Injectable({ providedIn: 'root' })
export class ClienteService {
  private readonly http = inject(HttpClient);
  private _clientes = signal<Cliente[]>([]);
  readonly clientes = this._clientes.asReadonly();

  constructor() { this.load(); }

  private toCliente(b: BackendCliente): Cliente {
    return { id: String(b.idCliente), nombre: b.nombre, correo: b.email, telefono: b.telefono };
  }

  load(): void {
    this.http.get<BackendCliente[]>('/api/clientes').subscribe(data => this._clientes.set(data.map(b => this.toCliente(b))));
  }

  getAll(): Cliente[] { return this._clientes(); }

  search(query: string): Cliente[] {
    const q = query.toLowerCase();
    return this._clientes().filter(c => c.nombre.toLowerCase().includes(q) || c.correo.toLowerCase().includes(q));
  }

  create(nombre: string, correo: string, telefono: string): void {
    this.http.post<BackendCliente>('/api/clientes', { nombre, email: correo, telefono, fechaRegistro: new Date().toISOString() })
      .subscribe(() => this.load());
  }

  update(id: string, nombre: string, correo: string, telefono: string): void {
    this.http.put<BackendCliente>(`/api/clientes/${id}`, { nombre, email: correo, telefono })
      .subscribe(() => this.load());
  }

  delete(id: string): void {
    this.http.delete<void>(`/api/clientes/${id}`).subscribe(() => this.load());
  }
}
