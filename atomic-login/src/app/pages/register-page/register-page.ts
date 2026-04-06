import { Component } from '@angular/core';
import { RegisterFormComponent } from '../../components/organisms/register-form/register-form';

@Component({
  selector: 'app-register-page',
  standalone: true,
  imports: [RegisterFormComponent],
  templateUrl: './register-page.html',
  styleUrl: './register-page.css'
})
export class RegisterPageComponent {}
