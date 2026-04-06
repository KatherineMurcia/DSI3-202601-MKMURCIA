import { Component } from '@angular/core';
import { AppLogoComponent } from '../../atoms/app-logo/app-logo';

@Component({
  selector: 'app-register-header',
  standalone: true,
  imports: [AppLogoComponent],
  templateUrl: './register-header.html',
  styleUrl: './register-header.css'
})
export class RegisterHeader {}
