import { Component, signal, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../../services/auth.service';
import { AppLogo } from '../../atoms/app-logo/app-logo';
import { Button } from '../../atoms/button/button';

@Component({
  selector: 'app-register-form',
  imports: [FormsModule, RouterLink, AppLogo, Button],
  templateUrl: './register-form.html',
  styleUrl: './register-form.css'
})
export class RegisterForm {
  private auth = inject(AuthService);
  private router = inject(Router);

  nombre = '';
  correo = '';
  contrasena = '';
  error = signal('');
  success = signal('');

  onRegister(): void {
    this.error.set('');
    if (!this.nombre || !this.correo || !this.contrasena) {
      this.error.set('Completa todos los campos.');
      return;
    }
    this.auth.register(this.nombre, this.correo, this.contrasena).subscribe(ok => {
      if (ok) {
        this.success.set('¡Cuenta creada! Redirigiendo...');
        setTimeout(() => this.router.navigate(['/auth/login']), 1200);
      } else {
        this.error.set('Ese correo ya está registrado.');
      }
    });
  }
}
