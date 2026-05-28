import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Producto } from '../models/producto.model';

@Injectable({ providedIn: 'root' })
export class ProductoService {
  private readonly url = '/api/productos';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Producto[]> {
    return this.http.get<Producto[]>(this.url);
  }

  getById(id: number): Observable<Producto> {
    return this.http.get<Producto>(`${this.url}/${id}`);
  }

  create(dto: Omit<Producto, 'idProducto'>): Observable<Producto> {
    return this.http.post<Producto>(this.url, dto);
  }

  update(id: number, dto: Omit<Producto, 'idProducto'>): Observable<Producto> {
    return this.http.put<Producto>(`${this.url}/${id}`, dto);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
}
