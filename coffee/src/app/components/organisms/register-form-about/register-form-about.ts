import { Component, Input, Output, EventEmitter } from '@angular/core';
import { InputField } from '../../atoms/input-field/input-field';
import { Button } from '../../atoms/button/button';
import { User } from '../../../models/user.interface';
import { LoginService } from '../../../services/login';

@Component({
  selector: 'app-register-form-about',
  standalone: true,
  imports: [InputField, Button],
  templateUrl: './register-form-about.html',
  styleUrl: './register-form-about.css',
})
export class RegisterFormAbout {
  cedula = '';
  nombre = '';
  apellidos = '';
  correo = '';
  ciudad = '';
  contrasena = '';
  @Input() errorMessage = '';
  @Output() register = new EventEmitter<User>();
  @Output() switchToLogin = new EventEmitter<void>();

  constructor(private loginService: LoginService) {}

  onSubmit(): void {
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
    const user: User = {
      cedula: this.cedula,
      nombre: this.nombre,
      apellidos: this.apellidos,
      correo: this.correo,
      ciudad: this.ciudad,
      contrasena: this.contrasena,
    };
    this.register.emit(user);
    const success = this.loginService.register(user);
    if (success.success) {
      alert('Registro exitoso. Ahora puedes iniciar sesión.');
      this.switchToLogin.emit();
      this.resetForm();
    } else {
      this.errorMessage = success.message;
    }

    
  }

  resetForm(): void {
    this.cedula = '';
    this.nombre = '';
    this.apellidos = '';
    this.correo = '';
    this.ciudad = '';
    this.contrasena = '';
    this.errorMessage = '';
  }
}
