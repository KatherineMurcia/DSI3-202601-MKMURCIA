import { Component } from '@angular/core';
import { AppLogoComponent } from '../../atoms/app-logo/app-logo';

@Component({
  selector: 'app-login-header',
  standalone: true,
  imports: [AppLogoComponent],
  templateUrl: './login-header.html',
  styleUrl: './login-header.css'
})
export class LoginHeaderComponent {}
