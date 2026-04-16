import { Component, Input, Output, EventEmitter } from '@angular/core';
import { LoginForm } from '../../components/organisms/login-form/login-form';
import { RegisterForm } from '../../components/organisms/register-form/register-form';
import { User } from '../../models/user.interface';

@Component({
  selector: 'app-login-template',
  imports: [LoginForm, RegisterForm],
  templateUrl: './login-template.html',
  styleUrl: './login-template.css',
})
export class LoginTemplate {
  isRegisterMode = false;
  @Input() loginError = '';
  @Input() registerError = '';
  @Output() login = new EventEmitter<{ correo: string; contrasena: string }>();
  @Output() register = new EventEmitter<User>();

  toggleMode(): void {
    this.isRegisterMode = !this.isRegisterMode;
    this.loginError = '';
    this.registerError = '';
  }
}
