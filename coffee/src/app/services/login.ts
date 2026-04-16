import { Injectable } from '@angular/core';
import { User } from '../models/user.interface';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private readonly STORAGE_KEY = 'usuarios';
  private readonly LOGGED_USER_KEY = 'usuarioLogueado';

  getUsers(): User[] {
    const data = localStorage.getItem(this.STORAGE_KEY);
    return data ? JSON.parse(data) : [];
  }

  register(user: User): { success: boolean; message: string } {
    const users = this.getUsers();
    const exists = users.some((u) => u.cedula === user.cedula || u.correo === user.correo);
    if (exists) {
      return { success: false, message: 'Ya existe un usuario con esta cédula o correo.' };
    }
    users.push(user);
    localStorage.setItem(this.STORAGE_KEY, JSON.stringify(users));
    return { success: true, message: 'Registro exitoso.' };
  }

  login(correo: string, contrasena: string): { success: boolean; message: string } {
    const users = this.getUsers();
    const user = users.find(
      (u) => u.correo === correo && u.contrasena === contrasena
    );
    if (user) {
      localStorage.setItem(this.LOGGED_USER_KEY, JSON.stringify(user));
      return { success: true, message: 'Inicio de sesión exitoso.' };
    }
    return { success: false, message: 'Credenciales incorrectas.' };
  }

  getLoggedUser(): User | null {
    const data = localStorage.getItem(this.LOGGED_USER_KEY);
    return data ? JSON.parse(data) : null;
  }

  logout(): void {
    localStorage.removeItem(this.LOGGED_USER_KEY);
  }

  isLoggedIn(): boolean {
    return localStorage.getItem(this.LOGGED_USER_KEY) !== null;
  }
}
