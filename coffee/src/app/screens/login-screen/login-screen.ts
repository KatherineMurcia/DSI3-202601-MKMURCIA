import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginTemplate } from '../../templates/login-template/login-template';
import { LoginService } from '../../services/login';
import { User } from '../../models/user.interface';

@Component({
  selector: 'app-login-screen',
  imports: [LoginTemplate],
  templateUrl: './login-screen.html',
  styleUrl: './login-screen.css',
})
export class LoginScreen {
  loginError = '';
  registerError = '';

  constructor(
    private loginService: LoginService,
    private router: Router
  ) {}

  onLogin(credentials: { correo: string; contrasena: string }): void {
    const result = this.loginService.login(credentials.correo, credentials.contrasena);
    if (result.success) {
      this.router.navigate(['/']);
    } else {
      this.loginError = result.message;
    }
  }

  onRegister(user: User): void {
    const result = this.loginService.register(user);
    if (result.success) {
      this.registerError = '';
      this.loginError = '';
      alert('Registro exitoso. Ahora puedes iniciar sesi\u00f3n.');
    } else {
      this.registerError = result.message;
    }
  }
}
