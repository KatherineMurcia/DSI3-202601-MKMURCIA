import { Component, signal, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../../services/auth.service';
import { AppLogo } from '../../atoms/app-logo/app-logo';
import { Button } from '../../atoms/button/button';

@Component({
  selector: 'app-login-form',
  imports: [FormsModule, RouterLink, AppLogo, Button],
  templateUrl: './login-form.html',
  styleUrl: './login-form.css'
})
export class LoginForm {
  private auth = inject(AuthService);
  private router = inject(Router);

  correo = '';
  contrasena = '';
  error = signal('');
  loading = signal(false);

  onLogin(): void {
    this.error.set('');
    if (!this.correo || !this.contrasena) {
      this.error.set('Completa todos los campos.');
      return;
    }
    this.loading.set(true);
    this.auth.login(this.correo, this.contrasena).subscribe(ok => {
      this.loading.set(false);
      if (ok) this.router.navigate(['/app/dashboard']);
      else this.error.set('Correo o contraseña incorrectos.');
    });
  }
}
