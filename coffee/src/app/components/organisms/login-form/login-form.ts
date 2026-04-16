import { Component, Input, Output, EventEmitter } from '@angular/core';
import { InputField } from '../../atoms/input-field/input-field';
import { Button } from '../../atoms/button/button';
import { LinkText } from '../../atoms/link-text/link-text';
import { AppLogo } from '../../atoms/app-logo/app-logo';
import { User } from '../../../models/user.interface';

@Component({
  selector: 'app-login-form',
  imports: [InputField, Button, LinkText, AppLogo],
  templateUrl: './login-form.html',
  styleUrl: './login-form.css',
})
export class LoginForm {
  cedula = '';
  nombre = '';
  apellidos = '';
  correo = '';
  ciudad = '';
  contrasena = '';
  @Input() errorMessage = '';
  @Output() login = new EventEmitter<{ correo: string; contrasena: string }>();
  @Output() register = new EventEmitter<User>();
  @Output() switchToRegister = new EventEmitter<void>();

  onSubmit(): void {
    this.errorMessage = '';
    if (!this.correo || !this.contrasena) {
      this.errorMessage = 'Todos los campos son obligatorios.';
      return;
    }
    this.login.emit({ correo: this.correo, contrasena: this.contrasena });
  }

  onRegister(): void {
    this.errorMessage = '';
    if (
      !this.cedula ||
      !this.nombre ||
      !this.apellidos ||
      !this.correo ||
      !this.ciudad ||
      !this.contrasena
    ) {
      this.errorMessage = 'Todos los campos son obligatorios.';
      return;
    }
    this.register.emit({
      cedula: this.cedula,
      nombre: this.nombre,
      apellidos: this.apellidos,
      correo: this.correo,
      ciudad: this.ciudad,
      contrasena: this.contrasena,
    });
  }
}
