import { Component } from '@angular/core';
import { LoginFormComponent } from '../../components/organisms/login-form/login-form';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [LoginFormComponent],
  templateUrl: './login-page.html',
  styleUrl: './login-page.css'
})
export class LoginPageComponent {}
