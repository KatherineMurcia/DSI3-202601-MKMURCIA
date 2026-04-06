import { Component } from '@angular/core';
import { LoginHeaderComponent } from '../../molecules/login-header/login-header';
import { CredentialsFormComponent } from '../../molecules/credentials-form/credentials-form';
import { FormActionsComponent } from '../../molecules/form-actions/form-actions';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [LoginHeaderComponent, CredentialsFormComponent, FormActionsComponent],
  templateUrl: './login-form.html',
  styleUrl: './login-form.css'
})
export class LoginFormComponent {}
