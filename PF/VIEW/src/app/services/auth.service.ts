import { Injectable, inject, signal } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, map, of, tap } from 'rxjs';
import { Usuario } from '../models/usuario.model';

const CURRENT_KEY = 'my_current_user';

interface BackendUsuario { idUsuario: number; nombre: string; email: string; }

@Injectable({ providedIn: 'root' })
export class AuthService {
  private readonly http = inject(HttpClient);
  private _currentUser = signal<Usuario | null>(this.loadCurrentUser());
  readonly currentUser = this._currentUser.asReadonly();

  private loadCurrentUser(): Usuario | null {
    try { return JSON.parse(localStorage.getItem(CURRENT_KEY) ?? 'null'); }
    catch { return null; }
  }

  private toUsuario(b: BackendUsuario): Usuario {
    return { id: String(b.idUsuario), nombre: b.nombre, correo: b.email, contrasena: '' };
  }

  register(nombre: string, correo: string, contrasena: string): Observable<boolean> {
    return this.http.post<BackendUsuario>('/api/auth/registro', { nombre, email: correo, password: contrasena }).pipe(
      map(() => true),
      catchError(() => of(false))
    );
  }

  login(correo: string, contrasena: string): Observable<boolean> {
    return this.http.post<BackendUsuario>('/api/auth/login', { email: correo, password: contrasena }).pipe(
      tap(b => {
        const user = this.toUsuario(b);
        localStorage.setItem(CURRENT_KEY, JSON.stringify(user));
        this._currentUser.set(user);
      }),
      map(() => true),
      catchError(() => of(false))
    );
  }

  logout(): void {
    localStorage.removeItem(CURRENT_KEY);
    this._currentUser.set(null);
  }

  isLoggedIn(): boolean {
    return this._currentUser() !== null;
  }
}
